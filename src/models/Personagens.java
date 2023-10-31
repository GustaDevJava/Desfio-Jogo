package models;

import java.util.ArrayList;
import java.util.List;

import iventario.Itens;

public class Personagens {

	private String nome;

	private Itens item;

	private int vida;
	private int forca;
	private int magia;
	private int agilidade;
	private int inteligencia;
	private int level = 1;

	private List<Itens> inventarioPlayer;
	
	private boolean primeiraLuta;
	


	public Personagens() {

	}

	public Personagens(String nome, int vida, int forca, int magia, int agilidade, int inteligencia,
			int level, List<Itens> inventarioPlayer, boolean primeiraLuta) {
		super();
		this.nome = nome;
		this.item = item;
		this.vida = vida;
		this.forca = forca;
		this.magia = magia;
		this.agilidade = agilidade;
		this.inteligencia = inteligencia;
		this.level = level;
		this.inventarioPlayer = new ArrayList<>();
		this.primeiraLuta = true;
	}

	public Itens getItem() {
		return item;
	}

	public void setItem(Itens item) {
		this.item = item;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Itens> getInventarioPlayer() {
		return inventarioPlayer;
	}

	public void setInventarioPlayer(List<Itens> inventarioPlayer) {
		this.inventarioPlayer = inventarioPlayer;
	}

	public boolean isPrimeiraLuta() {
		return primeiraLuta;
	}

	public void setPrimeiraLuta(boolean primeiraLuta) {
		this.primeiraLuta = primeiraLuta;
	}

	@Override
	public String toString() {
		return "Personagens [nome=" + nome + ", vida=" + vida + ", forca=" + forca + ", magia=" + magia + ", agilidade="
				+ agilidade + ", inteligencia=" + inteligencia + ", level=" + level + "]";
	}

}
