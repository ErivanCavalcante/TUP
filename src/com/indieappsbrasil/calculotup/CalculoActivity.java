package com.indieappsbrasil.calculotup;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class CalculoActivity extends Activity
{
	@Bind(R.id.edtFck)
	EditText edtFck;
	
	@Bind(R.id.spListaAbatimento)
	Spinner spListaAbatimento;
	
	@Bind(R.id.edtAbatimento)
	EditText edtAbatimento;
	
	@Bind(R.id.spDmax)
	Spinner sptDmax;
	
	@Bind(R.id.spFinura)
	Spinner spFinura;
	
	@Bind(R.id.edtMassaUni)
	EditText edtMassaUni;
	
	CalculoTipo2 calculo = new CalculoTipo2();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_calculo2);
		
		ButterKnife.bind(this);
		
		//Coloca as opcoes no spinner
		ArrayList<String> str = new ArrayList<String>();
		str.add("9.5 mm");
		str.add("12.5 mm");
		str.add("19 mm");
		str.add("25 mm");
		str.add("37.5 mm");
		str.add("50 mm");
		str.add("75 mm");
		str.add("150 mm");
		
		ArrayAdapter<String> adpDmax = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
		
		sptDmax.setAdapter(adpDmax);
		
		
		//Spinner Finura
		String[] strFin = {"2.40", "2.60", "2.80", "3.00"};
		ArrayAdapter<String> adpFin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strFin);
		
		spFinura.setAdapter(adpFin);
		
		//Spinner Abatimento
		String []strAbatimento = { "Sapatas e fundações armadas", "Blocos e paredes", 
									"Vigas e paredes armadas", "Pilares", "Pavimentos e lajes", 
									"Grandes volumes" };
		
		ArrayAdapter<String> adpAbatimento = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strAbatimento);
		
		spListaAbatimento.setAdapter(adpAbatimento);
		
		//Carrega as variaveis 
		if(savedInstanceState != null)
		{
			sptDmax.setSelection(savedInstanceState.getInt("dmax"));
			edtFck.setText(savedInstanceState.getString("fck"));
			edtAbatimento.setText(savedInstanceState.getString("abatimento"));
			spFinura.setSelection(savedInstanceState.getInt("finura"));
			edtMassaUni.setText(savedInstanceState.getString("massa_uni"));
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle out) 
	{
		out.putString("fck", edtFck.getText().toString());
		out.putString("abatimento", edtAbatimento.getText().toString());
		out.putInt("finura", spFinura.getSelectedItemPosition());
		out.putString("massa_uni", edtMassaUni.getText().toString());
		out.putInt("dmax", sptDmax.getSelectedItemPosition());
		
		super.onSaveInstanceState(out);
	}
	
	@Override
	public void onBackPressed() 
	{
		Intent it = new Intent(this, PrincipalActivity.class);
		startActivity(it);
		overridePendingTransition(R.anim.anim_dir_esq, R.anim.anim_hold);
		finish();
	}
	
	@Override
	protected void onDestroy() 
	{
		ButterKnife.unbind(this);
		super.onDestroy();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.principal, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
		if(item.getItemId() == R.id.menu_calcular)
		{
			if(existemCamposVazios())
			{
				Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
				return true;
			}
			
			//Evia os dados antes de calcular qlq coisa
			enviaOsDados();
			
			//Calcula aqui
			if(calculo.calcular() == false)
			{
				Toast.makeText(this, "Erro ao Calcular!", Toast.LENGTH_LONG).show();
			}
			else
			{
				//Vai para a proxima activity
				Intent it = new Intent(this, ValorCalculoActivity.class);
				DecimalFormat f = new DecimalFormat("####.##");
				//Coloca os valores pra ser apresentados
				it.putExtra("cimento", " " + f.format( calculo.getCc() ) + " kg / m3");
				it.putExtra("brita", " " + f.format( calculo.getCb() ) + " kg / m3");
				it.putExtra("areia", " " + f.format( calculo.getcAreia() ) + " kg / m3");
				it.putExtra("agua", " " + f.format( calculo.getCa() ) + " kg / m3");
				
				it.putExtra("result", "" + f.format( calculo.getCc() / calculo.getCc() ) + " : " + 
						f.format( calculo.ca / calculo.getCc() ) + " : " +
						f.format( calculo.cb / calculo.getCc() ) + " : " + f.format( calculo.fatorAC ) );
				
				startActivityForResult(it, 1);
				overridePendingTransition(R.anim.anim_esq_dir, R.anim.anim_hold);
			}
		}
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	@OnItemSelected(R.id.spListaAbatimento)
	public void selecaoAbatimento(int pos)
	{
		switch(pos)
		{
			case 0:
				edtAbatimento.setHint("25-75 (mm)");
				break;
			case 1:
				edtAbatimento.setHint("25-75 (mm)");
				break;
			case 2:
				edtAbatimento.setHint("25-100 (mm)");
				break;
			case 3:
				edtAbatimento.setHint("25-100 (mm)");
				break;
			case 4:
				edtAbatimento.setHint("25-75 (mm)");
				break;
			case 5:
				edtAbatimento.setHint("25-50 (mm)");
				break;
		}
	}
	
	boolean existemCamposVazios()
	{
		if(edtFck.getText().length() == 0 || edtAbatimento.getText().length() == 0 ||
			edtMassaUni.getText().length() == 0)
		{
			return true;
		}
		
		return false;
	}
	
	void enviaOsDados()
	{
		//Pega os valores das caixas de texto
		calculo.setFck( Integer.parseInt(edtFck.getText().toString()) );
		calculo.setAbt( Float.parseFloat(edtAbatimento.getText().toString()) );
		calculo.setMu( Float.parseFloat(edtMassaUni.getText().toString()) );
		
		switch (spFinura.getSelectedItemPosition()) 
		{
			case 0:
				calculo.setMf(2.40f);
				break;
			case 1:
				calculo.setMf(2.60f);
				break;
			case 2:
				calculo.setMf(2.80f);
				break;
			case 3:
				calculo.setMf(3.00f);
				break;
			default:
				break;
		}
		
		
		switch (sptDmax.getSelectedItemPosition()) 
		{
			case 0:
				calculo.setDm(9.5f);
				break;
			case 1:
				calculo.setDm(12.5f);
				break;
			case 2:
				calculo.setDm(19.0f);
				break;
			case 3:
				calculo.setDm(25.0f);
				break;
			case 4:
				calculo.setDm(37.5f);
				break;
			case 5:
				calculo.setDm(50.0f);
				break;
			case 6:
				calculo.setDm(75.0f);
				break;
			case 7:
				calculo.setDm(150.0f);
				break;
			default:
				break;
		}
		
		Log.d("Debug", "FCK = " + calculo.getFck());
		Log.d("Debug", "Abatimento = " + calculo.getAbt());
		Log.d("Debug", "Dmax = " + calculo.getDm());
		Log.d("Debug", "MU = " + calculo.getMu());
		Log.d("Debug", "MF = " + calculo.getMf());
	}
}
