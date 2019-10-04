package com.indieappsbrasil.calculotup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SobreActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_sobre);
	}
	
	@Override
	public void onBackPressed() 
	{
		super.onBackPressed();
		
		Intent it = new Intent(this, PrincipalActivity.class);
		startActivity(it);
		//faz a animação
		overridePendingTransition(R.anim.anim_dir_esq, R.anim.anim_hold);
		finish();
	}
}
