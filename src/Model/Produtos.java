package Model;

import java.math.BigDecimal;

public class Produtos {
	private String nome;
	private static int ID = 0;
	private int qtd;
	private float preco;
	
	public Produtos(String nome, int qtd, float preco) {
		BigDecimal bd = new BigDecimal(Float.toString(preco));
	    bd = bd.setScale(2, BigDecimal.ROUND_DOWN); 
		ID++;
		this.nome = nome;
		this.qtd = qtd;
		this.preco = bd.floatValue();
		  
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
