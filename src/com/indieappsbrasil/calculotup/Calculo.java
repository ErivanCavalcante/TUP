package com.indieappsbrasil.calculotup;

public abstract class Calculo 
{
	//Variaveis comuns
	float fck = 0;
	float abt = 0.0000f;
	float dm = 0;
	float mf = 0;
	//Massa unitaria
	float mu = 0.0000f;
	
	//Calculadas
	float fcj = 0;
	float fatorAC = 0;
	
	//Consumo de agua
	float ca = 0.000000f;
	//Consumo de brita
	float cb = 0.000000f;
	//Consumo cimento
	float cc = 0.000000f;
	//Consumo de areia
	float cAreia = 0.000000f;
	
	
	public float getFck() {
		return fck;
	}



	public void setFck(float fck) {
		this.fck = fck;
	}



	public float getAbt() {
		return abt;
	}



	public void setAbt(float abt) {
		this.abt = abt;
	}



	public float getDm() {
		return dm;
	}



	public void setDm(float dm) {
		this.dm = dm;
	}



	public float getMf() {
		return mf;
	}



	public void setMf(float mf) {
		this.mf = mf;
	}



	public float getMu() {
		return mu;
	}



	public void setMu(float mu) {
		this.mu = mu;
	}



	public float getFcj() {
		return fcj;
	}



	public void setFcj(float fcj) {
		this.fcj = fcj;
	}



	public float getFatorAC() {
		return fatorAC;
	}



	public void setFatorAC(float fatorAC) {
		this.fatorAC = fatorAC;
	}



	public float getCa() {
		return ca;
	}



	public void setCa(float ca) {
		this.ca = ca;
	}



	public float getCb() {
		return cb;
	}



	public void setCb(float cb) {
		this.cb = cb;
	}



	public float getCc() {
		return cc;
	}



	public void setCc(float cc) {
		this.cc = cc;
	}



	public float getcAreia() {
		return cAreia;
	}



	public void setcAreia(float cAreia) {
		this.cAreia = cAreia;
	}


	//Retorna uma string pronta pra ir a tela
	public abstract boolean calcular(); 
}
