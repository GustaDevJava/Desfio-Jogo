package racas;

import java.util.ArrayList;

import models.Lutador;
import models.Personagens;

public class Anoes extends Personagens implements Lutador {

	public Anoes() {
		super("", 1800, 10, 20, 15, 50, 1, new ArrayList<>(), true);
	}

	public Anoes(String nome) {
		super(nome, 1800, 10, 20, 15, 50, 1, new ArrayList<>(), true);

	}

	public void mostraAtributosAnao() {
		System.out.println("--------------------------");
		System.out.println("Atributos da raca anão: ");
		System.out.println("Vida: " + super.getVida());
		System.out.println("Forca: " + super.getForca());
		System.out.println("Magia: " + super.getMagia());
		System.out.println("Agilidade: " + super.getAgilidade());
		System.out.println("Inteligencia: " + super.getInteligencia());
		System.out.println("Level: " + super.getLevel());
		System.out.println("--------------------------");

	}

	public int ataqueMaosAgeis() {
		int dano = super.getForca() + super.getAgilidade();
		return dano;
	}

	public int ataqueRasteiro() {
		int dano = super.getAgilidade();
		return dano;
	}

	public int ataqueMagicoBasico() {
		int dano = 0;

		if (super.getInteligencia() > super.getMagia()) {
			dano = super.getMagia() + super.getForca();
		}

		return dano;
	}

	public int ataqueDireto() {
		int dano = 0;

		if (super.getInteligencia() > super.getAgilidade()) {
			dano = super.getForca() + super.getForca();
		}

		return dano;
	}

	public int ataqueMagiaTerrea() {
		int dano = 0;

		if (super.getMagia() > super.getAgilidade()) {
			dano = super.getMagia() + super.getForca();
		}

		return dano;
	}

	@Override
	public void receberDano(int dano) {
		int vida = getVida();

		vida -= dano;

		setVida(vida);
	}

	@Override
	public int atacar(int opcao) {
		int ataque = 0;

		switch (opcao) {
		case 0:
			ataque = ataqueMaosAgeis();
			break;

		case 1:
			ataque = ataqueRasteiro();
			break;

		case 2:
			ataque = ataqueMagicoBasico();
			break;

		case 3:
			ataque = ataqueDireto();
			break;

		case 4:
			ataque = ataqueMagiaTerrea();
			break;

		default:
			break;
		}

		return ataque;
	}

	@Override
	public void ataques() {
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque mãos ageis             |");
		System.out.println("|1 - Ataque rasteiro               |");
		System.out.println("|2 - Ataque magico basico          |");
		System.out.println("|3 - Ataque direto                 |");
		System.out.println("|4 - Ataque magia terrea           |");
		System.out.println("|----------------------------------|");
		

	}

	@Override
	public void ataquesAventuras() {
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque mãos ageis             |");
		System.out.println("|1 - Ataque rasteiro               |");
		System.out.println("|2 - Ataque magico basico          |");
		System.out.println("|3 - Ataque direto                 |");
		System.out.println("|4 - Ataque magia terrea           |");
		System.out.println("|4 - Abrir inventário              |");
		System.out.println("|----------------------------------|");
		
	}

}
