package racas;

import java.util.ArrayList;

import models.Lutador;
import models.Personagens;

public class Humanos extends Personagens implements Lutador {

	public Humanos() {
		super("", 4000, 40, 20, 50, 100, 1, new ArrayList<>(), true);
	}

	public Humanos(String nome) {
		super(nome, 4000, 40, 20, 50, 100, 11, new ArrayList<>(), true);

	}

	public void mostraAtributosHumano() {
		System.out.println("--------------------------");
		System.out.println("Atributos da raca humano: ");
		System.out.println("Vida: " + super.getVida());
		System.out.println("Forca: " + super.getForca());
		System.out.println("Magia: " + super.getMagia());
		System.out.println("Agilidade: " + super.getAgilidade());
		System.out.println("Inteligencia: " + super.getInteligencia());
		System.out.println("Level: " + super.getLevel());
		System.out.println("--------------------------");

	}

	public int ataqueAgil() {
		int dano = super.getForca();
		return dano + 2000;
	}

	public int ataqueFurtivo() {

		int dano = 0;

		if (super.getInteligencia() > super.getForca()) {
			dano = super.getAgilidade();
		}

		return dano;
	}

	public int ataquePunhoMagico() {

		int dano = 0;

		if (super.getInteligencia() > super.getForca()) {
			dano = super.getMagia() + super.getForca();
		}

		return dano;
	}

	public int ataqueVitalMagico() {

		int dano = 0;

		if (super.getInteligencia() > super.getAgilidade()) {
			dano = super.getMagia() + 15;
		}

		return dano;
	}

	public int ataqueMagico() {
		int dano = super.getMagia();
		return dano;
	}

	@Override
	public int atacar(int opcao) {
		int ataque = 0;

		switch (opcao) {
		case 0:
			ataque = ataqueAgil();
			break;

		case 1:
			ataque = ataqueFurtivo();
			break;

		case 2:
			ataque = ataquePunhoMagico();
			break;

		case 3:
			ataque = ataqueVitalMagico();
			break;

		case 4:
			ataque = ataqueMagico();
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
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque agil                   |");
		System.out.println("|1 - Ataque furtivo                |");
		System.out.println("|2 - Ataque punho magico           |");
		System.out.println("|3 - Ataque vital magico           |");
		System.out.println("|4 - Ataque magico                 |");
		System.out.println("|----------------------------------|");
		

	}

	@Override
	public void ataquesAventuras() {
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque agil                   |");
		System.out.println("|1 - Ataque furtivo                |");
		System.out.println("|2 - Ataque punho magico           |");
		System.out.println("|3 - Ataque vital magico           |");
		System.out.println("|4 - Ataque magico                 |");
		System.out.println("|5 - Abrir inventário              |");
		System.out.println("|----------------------------------|");
		
	}

}
