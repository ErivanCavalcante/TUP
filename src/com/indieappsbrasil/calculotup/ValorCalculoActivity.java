package com.indieappsbrasil.calculotup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ValorCalculoActivity extends Activity 
{
	@Bind(R.id.txtResultado)
	TextView txtResultado;
	
	@Bind(R.id.txtCimento)
	TextView txtCimento;
	
	@Bind(R.id.txtAreia)
	TextView txtAreia;
	
	@Bind(R.id.txtBrita)
	TextView txtBrita;
	
	@Bind(R.id.txtAgua)
	TextView txtAgua;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_valor_calculo);
		
		ButterKnife.bind(this);
		
		Intent it = getIntent();

		desenhaResultado(it);
	}
	
	@Override
	public void onBackPressed() 
	{
		super.onBackPressed();
		
		setResult(RESULT_OK);
		//faz a animação
		overridePendingTransition(R.anim.anim_dir_esq, R.anim.anim_hold);
		finish();
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle out) 
	{
		// TODO Auto-generated method stub
		super.onSaveInstanceState(out);
		
		out.putString("resul", txtResultado.getText().toString());
		out.putString("cimento", txtCimento.getText().toString());
		out.putString("brita", txtBrita.getText().toString());
		out.putString("agua", txtAgua.getText().toString());
		out.putString("areia", txtAreia.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle s) 
	{
		txtResultado.setText(s.getString("result"));
		txtCimento.setText(s.getString("cimento"));
		txtBrita.setText(s.getString("brita"));
		txtAgua.setText(s.getString("agua"));
		txtAreia.setText(s.getString("areia"));
		
		super.onRestoreInstanceState(s);
	}
	
	@Override
	protected void onDestroy() 
	{
		ButterKnife.unbind(this);
		super.onDestroy();
	}
	
	void desenhaResultado(Intent it)
	{
		if(it == null)
			return;
		
		txtResultado.setText(it.getStringExtra("result"));
		txtCimento.append(it.getStringExtra("cimento"));
		txtBrita.append(it.getStringExtra("brita"));
		txtAgua.append(it.getStringExtra("agua"));
		txtAreia.append(it.getStringExtra("areia"));
	}
}
