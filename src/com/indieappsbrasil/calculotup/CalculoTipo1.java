package com.indieappsbrasil.calculotup;

import android.util.Log;
import java.lang.Math;

public class CalculoTipo1 extends Calculo
{
	//Variaveis	
	float gamaC = 0.0000f;
	float gamaB = 0.0000f;
	float gamaA = 0.0000f;
	
	//Calculados de acordo com o tipo de cimento  e mandado pra ca
	float k1 = 0;
	float k2 = 0;
	
	//Tabelas
	//Abatimento x diametro maximo ( abt x dm )
	float abtXdm[][] = new float[3][5];
	
	
	//Modulo de finura x diametro maximo ( mf x dm )
	float mfXdm[][] = new float[10][5];
	
	
	public float getGamaC() {
		return gamaC;
	}

	public void setGamaC(float gamaC) {
		this.gamaC = gamaC;
	}

	public float getGamaB() {
		return gamaB;
	}

	public void setGamaB(float gamaB) {
		this.gamaB = gamaB;
	}

	public float getGamaA() {
		return gamaA;
	}

	public void setGamaA(float gamaA) {
		this.gamaA = gamaA;
	}

	public float getK1() {
		return k1;
	}

	public void setK1(float k1) {
		this.k1 = k1;
	}

	public float getK2() {
		return k2;
	}

	public void setK2(float k2) {
		this.k2 = k2;
	}

	public CalculoTipo1() 
	{
		iniciaTabelas();
	}
	
	void iniciaTabelas()
	{
		//Abt x dm
		abtXdm[0][0] = 220;
		abtXdm[0][1] = 195;
		abtXdm[0][2] = 190;
		abtXdm[0][3] = 185;
		abtXdm[0][4] = 180;
		
		abtXdm[1][0] = 225;
		abtXdm[1][1] = 200;
		abtXdm[1][2] = 195;
		abtXdm[1][3] = 190;
		abtXdm[1][4] = 185;
		
		abtXdm[2][0] = 230;
		abtXdm[2][1] = 205;
		abtXdm[2][2] = 200;
		abtXdm[2][3] = 195;
		abtXdm[2][4] = 190;
		
		
		//Mf x dm
		mfXdm[0][0] = 0.645f;
		mfXdm[0][1] = 0.770f;
		mfXdm[0][2] = 0.795f;
		mfXdm[0][3] = 0.82f;
		mfXdm[0][4] = 0.845f;
		
		mfXdm[1][0] = 0.625f;
		mfXdm[1][1] = 0.75f;
		mfXdm[1][2] = 0.775f;
		mfXdm[1][3] = 0.8f;
		mfXdm[1][4] = 0.825f;
		
		mfXdm[2][0] = 0.605f;
		mfXdm[2][1] = 0.73f;
		mfXdm[2][2] = 0.755f;
		mfXdm[2][3] = 0.78f;
		mfXdm[2][4] = 0.805f;
		
		mfXdm[3][0] = 0.585f;
		mfXdm[3][1] = 0.71f;
		mfXdm[3][2] = 0.735f;
		mfXdm[3][3] = 0.76f;
		mfXdm[3][4] = 0.785f;
		
		mfXdm[4][0] = 0.565f;
		mfXdm[4][1] = 0.69f;
		mfXdm[4][2] = 0.715f;
		mfXdm[4][3] = 0.74f;
		mfXdm[4][4] = 0.765f;
		
		mfXdm[5][0] = 0.545f;
		mfXdm[5][1] = 0.67f;
		mfXdm[5][2] = 0.695f;
		mfXdm[5][3] = 0.72f;
		mfXdm[5][4] = 0.745f;
		
		mfXdm[6][0] = 0.525f;
		mfXdm[6][1] = 0.65f;
		mfXdm[6][2] = 0.675f;
		mfXdm[6][3] = 0.7f;
		mfXdm[6][4] = 0.725f;
		
		mfXdm[7][0] = 0.505f;
		mfXdm[7][1] = 0.63f;
		mfXdm[7][2] = 0.655f;
		mfXdm[7][3] = 0.68f;
		mfXdm[7][4] = 0.705f;
		
		mfXdm[8][0] = 0.485f;
		mfXdm[8][1] = 0.61f;
		mfXdm[8][2] = 0.635f;
		mfXdm[8][3] = 0.66f;
		mfXdm[8][4] = 0.685f;
		
		mfXdm[9][0] = 0.465f;
		mfXdm[9][1] = 0.59f;
		mfXdm[9][2] = 0.615f;
		mfXdm[9][3] = 0.64f;
		mfXdm[9][4] = 0.665f;
	}
	
	void calculaFcj()
	{
		fcj = fck + 1.65f * 4.00f;
		Log.d("Debug", "Calculo Fcj...");
		Log.d("Debug", "FCJ = " + fcj);
	}
	
	boolean calculaFatorAguaCimento()
	{
		fatorAC = (float)( ( Math.log10( k1 ) - Math.log10( fcj ) ) / Math.log10( k2 ) );
		
		Log.d("Debug", "Calculo Fator cimento / agua...");
		Log.d("Debug", "Fator Agua Cimento = " + fatorAC);
		
		return true;
	}
	
	boolean calculaConsumoAgua()
	{
		int linha = 0, coluna = 0;
		
		//Pega a linhaq
		if(abt >= 40 && abt < 60)
		{
			linha = 0;
		}
		else if(abt >= 60 && abt < 80)
		{
			linha = 1;
		}
		else if(abt >= 80 && abt <= 100)
		{
			linha = 2;
		}
		//Nao pode ser calculado abatimento errado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		//Pega a coluna
		if(dm == 9.5f)
		{
			coluna = 0;
		}
		else if(dm == 19.0f)
		{
			coluna = 1;
		}
		else if(dm == 25.0f)
		{
			coluna = 2;
		}
		else if(dm == 32.0f)
		{
			coluna = 3;
		}
		else if(dm == 38.0f)
		{
			coluna = 4;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
			
		//Pega o volume da tabela
		ca = abtXdm[linha][coluna];
		
		Log.d("Debug", "Calculo Volume de agua...");
		Log.d("Debug", "Volume Agua = " + ca);
		
		return true;
	}
	
	boolean calculaConsumoBrita()
	{
		int linha = 0, coluna = 0;
		float v = 0.00f;
		
		//pega a linha
		if(mf == 1.8f)
		{
			linha = 0;
		}
		else if(mf == 2.0f)
		{
			linha = 1;
		}
		else if(mf == 2.2f)
		{
			linha = 2;
		}
		else if(mf == 2.4f)
		{
			linha = 3;
		}
		else if(mf == 2.6f)
		{
			linha = 4;
		}
		else if(mf == 2.8f)
		{
			linha = 5;
		}
		else if(mf == 3.0f)
		{
			linha = 6;
		}
		else if(mf == 3.2f)
		{
			linha = 7;
		}
		else if(mf == 3.4f)
		{
			linha = 8;
		}
		else if(mf == 3.6f)
		{
			linha = 9;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		//Pega a coluna
		if(dm == 9.5f)
		{
			coluna = 0;
		}
		else if(dm == 19.0f)
		{
			coluna = 1;
		}
		else if(dm == 25.0f)
		{
			coluna = 2;
		}
		else if(dm == 32.0f)
		{
			coluna = 3;
		}
		else if(dm == 38.0f)
		{
			coluna = 4;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		v = mfXdm[linha][coluna];
		
		cb =  v * mu * 1000.0000f;
		
		Log.d("Debug", "Calculo Consumo Brita...");
		Log.d("Debug", "V = " + v + " Consumo Brita = " + cb);
		
		return true;
	}
	
	boolean calculaConsumoCimento()
	{
		//Testa pra nao dividir por 0
		if( ca <= 0.000000f || fatorAC <= 0.000000f )
			return false;
		
		cc = ca / fatorAC;
		
		Log.d("Debug", "Calculo Consumo Cimento...");
		Log.d("Debug", "Ca = " + ca);
		Log.d("Debug", "A / C = " + fatorAC);
		Log.d("Debug", "Cc = " + cc);
		
		return true;
	}
	
	boolean calculaConsumoAreia()
	{
		float volumeAreia = 1 - ( ( cc / ( gamaC * 1000.0000f ) ) + 
						( cb / gamaB * 1000.0000f ) + 
						( ca / 1000 ) );
		
		cAreia = volumeAreia * gamaA * 1000;
		
		Log.d("Debug", "Calculo Consumo Areia...");
		Log.d("Debug", "Volume Agregado = " + cb);
		Log.d("Debug", "Fator agua cimento = " + cc);
		Log.d("Debug", "Volume Agua = " + ca );
		Log.d("Debug", "Volume areia = " + volumeAreia);
		
		Log.d("Debug", "Consumo areia = " + cAreia);
		
		return true;
	}
	
	@Override
	public boolean calcular() 
	{
		Log.d("Debug", "Inicio do calculo...");
		
		calculaFcj();
		
		//Testa os limites do fcj
		if(fcj > 40)
		{
			Log.d("Debug", "FCJ maior que 40");
			return false;
		}
		
		if(!calculaConsumoAgua())
			return false;
		
		if(!calculaConsumoBrita())
			return false;
		
		if(!calculaFatorAguaCimento())
			return false;
		
		if(!calculaConsumoAreia())
			return false;
		
		Log.d("Debug", "Fim do calculo...");
		
		return true;
	}

}
