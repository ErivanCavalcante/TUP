package com.indieappsbrasil.calculotup;

import android.util.Log;

public class CalculoTipo2 extends Calculo
{
	//Tabela da agua
	//abatimento(mm) / diametro max (dmax)
	int tabelaAgua[][] = new int[3][8];
	float tabelaAC[] = { 0.42f, 0.47f, 0.54f, 0.61f, 0.69f, 0.79f };
	int tabelaMassaEsp[] = { 2280, 2310, 2345, 2380, 2410, 2445, 2490, 2530 };
	float tabelaAgregado[][] = new float[8][4];

	/**********Construtor*************/
	public CalculoTipo2() 
	{
		iniciaTabelas();
	}
	
	void iniciaTabelas()
	{
		//Tablea da agua
		//Linhas = Faixas de abatimento(mm)
		//Colunas = faixas de Dmax
		
		//de 25 a 50
		tabelaAgua[0][0] = 207;
		tabelaAgua[0][1] = 199;
		tabelaAgua[0][2] = 190;
		tabelaAgua[0][3] = 179;
		tabelaAgua[0][4] = 166;
		tabelaAgua[0][5] = 154;
		tabelaAgua[0][6] = 130;
		tabelaAgua[0][7] = 113;
		
		//de 75 a 100
		tabelaAgua[1][0] = 228;
		tabelaAgua[1][1] = 216;
		tabelaAgua[1][2] = 205;
		tabelaAgua[1][3] = 193;
		tabelaAgua[1][4] = 181;
		tabelaAgua[1][5] = 169;
		tabelaAgua[1][6] = 145;
		tabelaAgua[1][7] = 124;
		
		//de 150 a 175
		tabelaAgua[2][0] = 243;
		tabelaAgua[2][1] = 228;
		tabelaAgua[2][2] = 216;
		tabelaAgua[2][3] = 202;
		tabelaAgua[2][4] = 190;
		tabelaAgua[2][5] = 178;
		tabelaAgua[2][6] = 160;
		tabelaAgua[2][7] = 0;
		
		
		//Tabela de agregado
		//linhas = dmax
		//colunas = MF
		//dmax = 9.5
		tabelaAgregado[0][0] = 0.5f;
		tabelaAgregado[0][1] = 0.48f;
		tabelaAgregado[0][2] = 0.46f;
		tabelaAgregado[0][3] = 0.44f;
		
		//dmax = 12.5
		tabelaAgregado[1][0] = 0.59f;
		tabelaAgregado[1][1] = 0.57f;
		tabelaAgregado[1][2] = 0.55f;
		tabelaAgregado[1][3] = 0.53f;
		
		//dmax = 19
		tabelaAgregado[2][0] = 0.66f;
		tabelaAgregado[2][1] = 0.64f;
		tabelaAgregado[2][2] = 0.62f;
		tabelaAgregado[2][3] = 0.6f;
		
		//dmax = 25
		tabelaAgregado[3][0] = 0.71f;
		tabelaAgregado[3][1] = 0.69f;
		tabelaAgregado[3][2] = 0.67f;
		tabelaAgregado[3][3] = 0.65f;
		
		//dmax = 37.5
		tabelaAgregado[4][0] = 0.75f;
		tabelaAgregado[4][1] = 0.73f;
		tabelaAgregado[4][2] = 0.71f;
		tabelaAgregado[4][3] = 0.69f;
		
		//dmax = 50
		tabelaAgregado[5][0] = 0.78f;
		tabelaAgregado[5][1] = 0.76f;
		tabelaAgregado[5][2] = 0.74f;
		tabelaAgregado[5][3] = 0.72f;
		
		//dmax = 75
		tabelaAgregado[6][0] = 0.82f;
		tabelaAgregado[6][1] = 0.80f;
		tabelaAgregado[6][2] = 0.78f;
		tabelaAgregado[6][3] = 0.76f;
		
		//dmax = 150
		tabelaAgregado[7][0] = 0.87f;
		tabelaAgregado[7][1] = 0.85f;
		tabelaAgregado[7][2] = 0.83f;
		tabelaAgregado[7][3] = 0.81f;
	}
	
	
	void calculaFcj()
	{
		fcj = fck + 1.64f * 4.00f;
		Log.d("Debug", "Calculo Fcj...");
		Log.d("Debug", "FCJ = " + fcj);
	}
	
	
	boolean calculaConsumoAgua()
	{
		int linha = 0, coluna = 0;
		
		//Pega a linha
		if(abt >= 25 && abt <= 50)
		{
			linha = 0;
		}
		else if(abt >= 75 && abt <= 100)
		{
			linha = 1;
		}
		else if(abt >= 150 && abt <= 175)
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
		else if(dm == 12.5f)
		{
			coluna = 1;
		}
		else if(dm == 19.0f)
		{
			coluna = 2;
		}
		else if(dm == 25.0f)
		{
			coluna = 3;
		}
		else if(dm == 37.5f)
		{
			coluna = 4;
		}
		else if(dm == 50.0f)
		{
			coluna = 5;
		}
		else if(dm == 75.0f)
		{
			coluna = 6;
		}
		else if(dm == 150.0f)
		{
			coluna = 7;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
			
		//Pega o volume da tabela
		ca = tabelaAgua[linha][coluna];
		Log.d("Debug", "Calculo Consumo de agua...");
		Log.d("Debug", "Consumo Agua = " + ca);
		
		return true;
	}
	
	boolean calculaFatorAguaCimento()
	{
		if(fcj > 35 && fcj <= 40)
		{
			fatorAC = tabelaAC[0];
		}
		else if(fcj > 30 && fcj <= 35)
		{
			fatorAC = tabelaAC[1];
		}
		else if(fcj > 25 && fcj <= 30)
		{
			fatorAC = tabelaAC[2];
		}
		else if(fcj > 20 && fcj <= 25)
		{
			fatorAC = tabelaAC[3];
		}
		else if(fcj > 15 && fcj <= 20)
		{
			fatorAC = tabelaAC[4];
		}
		else if(fcj >= 0 && fcj <= 15)
		{
			fatorAC = tabelaAC[5];
		}
		else
			return false;
		
		cc = ca / fatorAC;
		Log.d("Debug", "Calculo Fator cimento / agua...");
		Log.d("Debug", "Ac = " + fatorAC);
		Log.d("Debug", "Consumo Cimento = " + cc);
		
		return true;
	}
	
	boolean calculaConsumoBrita()
	{
		int linha = 0, coluna = 0;
		float v = 0.00f;
		
		//Pega a linha
		if(dm == 9.5f)
		{
			linha = 0;
		}
		else if(dm == 12.5f)
		{
			linha = 1;
		}
		else if(dm == 19.0f)
		{
			linha = 2;
		}
		else if(dm == 25.0f)
		{
			linha = 3;
		}
		else if(dm == 37.5f)
		{
			linha = 4;
		}
		else if(dm == 50.0f)
		{
			linha = 5;
		}
		else if(dm == 75.0f)
		{
			linha = 6;
		}
		else if(dm == 150.0f)
		{
			linha = 7;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		//pega a coluna
		if(mf == 2.40f)
		{
			coluna = 0;
		}
		else if(mf == 2.60f)
		{
			coluna = 1;
		}
		else if(mf == 2.80f)
		{
			coluna = 2;
		}
		else if(mf == 3.00f)
		{
			coluna = 3;
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		v = tabelaAgregado[linha][coluna];
		
		//Consumo da brita
		cb = mu * v * 1000.00000f;
		
		Log.d("Debug", "Calculo Consumo da Brita...");
		Log.d("Debug", "V = " + v + " Consumo Brita = " + cb);
		
		return true;
	}
	
	boolean calculaConsumoAreia()
	{
		float massa = 0.00f;
		//Pega a linha
		if(dm == 9.5f)
		{
			massa = tabelaMassaEsp[0];
		}
		else if(dm == 12.5f)
		{
			massa = tabelaMassaEsp[1];
		}
		else if(dm == 19.0f)
		{
			massa = tabelaMassaEsp[2];
		}
		else if(dm == 25.0f)
		{
			massa = tabelaMassaEsp[3];
		}
		else if(dm == 37.5f)
		{
			massa = tabelaMassaEsp[4];
		}
		else if(dm == 50.0f)
		{
			massa = tabelaMassaEsp[5];
		}
		else if(dm == 75.0f)
		{
			massa = tabelaMassaEsp[6];
		}
		else if(dm == 150.0f)
		{
			massa = tabelaMassaEsp[7];
		}
		//Nao pode ser calculado
		else
		{
			Log.d("Debug", "Saiu aqui,,,,");
			return false;
		}
		
		cAreia = massa - cb - fatorAC - ca;
		
		Log.d("Debug", "Calculo Consumo Areia...");
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
		
		if(!calculaFatorAguaCimento())
			return false;
		
		if(!calculaConsumoBrita())
			return false;
		
		if(!calculaConsumoAreia())
			return false;
		
		Log.d("Debug", "Fim do calculo...");
		
		return true;
	}

}
