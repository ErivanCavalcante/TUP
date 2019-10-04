package com.indieappsbrasil.calculotup;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.Bind;
import butterknife.ButterKnife;

public class PrincipalActivity extends Activity 
{
	@Bind(R.id.spTipoMetodo)
	Spinner spTipo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_principal);
		
		ButterKnife.bind(this);
		
		//Coloca as opcoes no spinner
		ArrayList<String> str = new ArrayList<String>();
		str.add("Método ACI");
		str.add("Método ABCP");
		
		ArrayAdapter<String> adpTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
		
		spTipo.setAdapter(adpTipo);
		
		if(savedInstanceState != null)
		{
			spTipo.setSelection(savedInstanceState.getInt("tipo"));
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.menu_sobre, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
		if(item.getItemId() == R.id.menu_sobre)
		{
			Intent it = new Intent(this, SobreActivity.class);
			startActivity(it);
			overridePendingTransition(R.anim.anim_baixo_cima, R.anim.anim_hold);
			finish();
			return true;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onBackPressed() 
	{
		finish();
		PrincipalActivity.this.overridePendingTransition(R.anim.anim_hold, R.anim.anim_cima_baixo);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle out) 
	{
		out.putInt("tipo", spTipo.getSelectedItemPosition());
		// TODO Auto-generated method stub
		super.onSaveInstanceState(out);
	}
	
	public void clickIniciar(View v)
	{
		if(spTipo.getSelectedItemPosition() == 0)
		{
			Intent it = new Intent(this, CalculoActivity.class);
			startActivity(it);
			overridePendingTransition(R.anim.anim_baixo_cima, R.anim.anim_hold);
			finish();
		}
		else
		{
			Intent it = new Intent(this, CalculoABCPActivity.class);
			startActivity(it);
			overridePendingTransition(R.anim.anim_baixo_cima, R.anim.anim_hold);
			finish();
		}
	}
}
