package monstros;

import iventario.Itens;
import models.Lutador;
import models.Personagens;

public class Trolls extends Personagens implements Lutador {
	
	private Itens item;

	public Trolls() {
		super("", 4600, 75, 30, 50, 80, 3, null, true);
	}

	public Trolls(String nome) {
		super(nome, 4600, 75, 30, 30, 80, 3, null, true);

	}
	
	

	public Trolls(Itens item) {
		super("", 4600, 80, 30, 50, 80, 3, null, true);
		this.item = item;
	}

	public Itens getItem() {
		return item;
	}

	public void setItem(Itens item) {
		this.item = item;
	}

	public int ataqueForte() {
		int dano = super.getForca();
		return dano;
	}

	public int ataqueBruto() {

		int dano = 0;

		if (super.getInteligencia() >= super.getForca()) {
			dano = super.getForca() + 10;
		}

		return dano;
	}

	public int ataqueInvestida() {

		int dano = 0;

		if (super.getAgilidade() < super.getForca()) {
			dano = super.getAgilidade() + 10;
		}

		return dano;
	}

	public int ataqueEstremecedor() {

		int dano = 0;

		if (super.getForca() > super.getMagia()) {
			dano = super.getMagia() + 5;
		}

		return dano;
	}

	public int ataqueBasico() {
		int dano = super.getForca() - 10;
		return dano;
	}

	@Override
	public int atacar(int opcao) {
		int ataque = 0;

		switch (opcao) {
		case 0:
			ataque = ataqueForte();
			break;

		case 1:
			ataque = ataqueBruto();
			break;

		case 2:
			ataque = ataqueInvestida();
			break;

		case 3:
			ataque = ataqueEstremecedor();
			break;

		case 4:
			ataque = ataqueBasico();
			break;

		default:
			break;
		}

		return ataque;
	}

	@Override
	public void receberDano(int dano) {
		int vida = getVida();

		vida -= dano;

		setVida(vida);

	}

	@Override
	public void ataques() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataquesAventuras() {
		// TODO Auto-generated method stub
		
	}

}
