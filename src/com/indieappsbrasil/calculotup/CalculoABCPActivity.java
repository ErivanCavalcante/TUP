package com.indieappsbrasil.calculotup;

import java.text.DecimalFormat;

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

public class CalculoABCPActivity extends Activity 
{

	@Bind(R.id.edtFck)
	EditText edtFck;
	
	@Bind(R.id.spTipoCimento)
	Spinner spTipoCimento;
	
	@Bind(R.id.edtAbatimento)
	EditText edtAbatimento;
	
	@Bind(R.id.spDmax)
	Spinner sptDmax;
	
	@Bind(R.id.spFinura)
	Spinner spFinura;
	
	@Bind(R.id.edtMassaUni)
	EditText edtMassaUni;
	
	@Bind(R.id.edtGamaC)
	EditText edtGamaC;
	
	@Bind(R.id.edtGamaG)
	EditText edtGamaG;
	
	@Bind(R.id.edtGamaM)
	EditText edtGamaM;
	
	CalculoTipo1 calculo = new CalculoTipo1();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_calculo_abcp);
		
		ButterKnife.bind(this);
		
		/**********Ajusta o tipo de cimento***********/
		String str[] = { "CP26", "CP29", "CP32", "CP35", "CP38", "CP41", "CP44"};
	
		ArrayAdapter<String> adpStr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
		
		spTipoCimento.setAdapter(adpStr);
		
		/************************/
		
		/**********************Ajusta o diametros maximos**************/
		String strDm[] = {"9.5 mm", "19 mm", "25 mm", "32 mm", "38 mm"};
		ArrayAdapter<String> adpDm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strDm);
		
		sptDmax.setAdapter(adpDm);
		/*************************/
		
		/**************************Seta as finuras*****************/
		String[] strFin = {"1.8", "2", "2.2", "2.4", "2.6", "2.8", "3", "3.2", "3.4", "3.6"};
		ArrayAdapter<String> adpFin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strFin);
		
		spFinura.setAdapter(adpFin);
		/*********************************************/
		
		//Testa se mudou a orientação 
		//Se sim carrega as opcoes
		if(savedInstanceState != null)
		{
			sptDmax.setSelection(savedInstanceState.getInt("dmax"));
			edtFck.setText(savedInstanceState.getString("fck"));
			spTipoCimento.setSelection(savedInstanceState.getInt("tipo_cimento"));
			edtAbatimento.setText(savedInstanceState.getString("abatimento"));
			spFinura.setSelection(savedInstanceState.getInt("finura"));
			edtGamaC.setText(savedInstanceState.getString("gama_c"));
			edtGamaG.setText(savedInstanceState.getString("gama_g"));
			edtGamaM.setText(savedInstanceState.getString("gama_m"));
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle out) 
	{
		out.putString("fck", edtFck.getText().toString());
		out.putString("abatimento", edtAbatimento.getText().toString());
		out.putInt("tipo_cimento", spTipoCimento.getSelectedItemPosition());
		out.putInt("finura", spFinura.getSelectedItemPosition());
		out.putString("massa_uni", edtMassaUni.getText().toString());
		out.putInt("dmax", sptDmax.getSelectedItemPosition());
		out.putString("gama_c", edtGamaC.getText().toString());
		out.putString("gama_g", edtGamaG.getText().toString());
		out.putString("gama_m", edtGamaM.getText().toString());
		
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
	
	boolean existemCamposVazios()
	{
		if(edtFck.getText().length() == 0 || edtAbatimento.getText().length() == 0 ||
			edtMassaUni.getText().length() == 0 || edtGamaC.getText().length() == 0 ||
			edtGamaG.getText().length() == 0 || edtGamaM.getText().length() == 0)
		{
			return true;
		}
		
		return false;
	}
	
	boolean enviaOsDados()
	{
		float abt = Float.parseFloat(edtAbatimento.getText().toString());
		
		//Testa se ta dentro do limite
		if( abt < 40 || abt > 100 )
		{
			Toast.makeText(getApplicationContext(), "Parametro do abatimento é invalido.", Toast.LENGTH_LONG ).show();
			return false;
		}
		
		//Pega os valores das caixas de texto
		calculo.setFck( Integer.parseInt(edtFck.getText().toString()) );
		calculo.setAbt( abt );
		calculo.setMu( Float.parseFloat(edtMassaUni.getText().toString()) );
		
		//Massas especificas
		calculo.setGamaA( Float.parseFloat(edtGamaM.getText().toString()) );
		calculo.setGamaB( Float.parseFloat(edtGamaG.getText().toString()) );
		calculo.setGamaC( Float.parseFloat(edtGamaC.getText().toString()) );
		
		//Tipo do cimento
		switch(spTipoCimento.getSelectedItemPosition())
		{
			case 0:
				calculo.setK1(92.89664f);
				calculo.setK2(12.35947f);
				break;
			case 1:
				calculo.setK1(107.3989f);
				calculo.setK2(13.80384f);
				break;
			case 2:
				calculo.setK1(114.2878f);
				calculo.setK2(13.0017f);
				break;
			case 3:
				calculo.setK1(132.4342f);
				calculo.setK2(14.79108f);
				break;
			case 4:
				calculo.setK1(135.5189f);
				calculo.setK2(13.30454f);
				break;
			case 5:
				calculo.setK1(145.5459f);
				calculo.setK2(13.64583f);
				break;
			case 6:
				calculo.setK1(138.3566f);
				calculo.setK2(11.508f);
				break;
		}
		
		switch (spFinura.getSelectedItemPosition()) 
		{
			case 0:
				calculo.setMf(1.8f);
				break;
			case 1:
				calculo.setMf(2.0f);
				break;
			case 2:
				calculo.setMf(2.2f);
				break;
			case 3:
				calculo.setMf(2.4f);
				break;
			case 4:
				calculo.setMf(2.6f);
				break;
			case 5:
				calculo.setMf(2.8f);
				break;
			case 6:
				calculo.setMf(3.0f);
				break;
			case 7:
				calculo.setMf(3.2f);
				break;
			case 8:
				calculo.setMf(3.4f);
				break;
			case 9:
				calculo.setMf(3.6f);
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
				calculo.setDm(19.0f);
				break;
			case 2:
				calculo.setDm(25.0f);
				break;
			case 3:
				calculo.setDm(32.0f);
				break;
			case 4:
				calculo.setDm(38.0f);
				break;
			default:
				break;
		}
		
		Log.d("Debug", "FCK = " + calculo.getFck());
		Log.d("Debug", "Abatimento = " + calculo.getAbt());
		Log.d("Debug", "Dmax = " + calculo.getDm());
		Log.d("Debug", "MU = " + calculo.getMu());
		Log.d("Debug", "MF = " + calculo.getMf());
		
		return true;
	}
}
