package racas;

import java.util.ArrayList;

import models.Lutador;
import models.Personagens;

public class Elfos extends Personagens implements Lutador {

	public Elfos() {
		super("", 2000, 15, 35, 30, 100, 1, new ArrayList<>(), true);
	}

	public Elfos(String nome) {
		super(nome, 2000, 15, 35, 30, 100, 1, new ArrayList<>(), true);

	}

	public void mostraAtributosElfo() {
		System.out.println("--------------------------");
		System.out.println("Atributos da raca elfo: ");
		System.out.println("Vida: " + super.getVida());
		System.out.println("Forca: " + super.getForca());
		System.out.println("Magia: " + super.getMagia());
		System.out.println("Agilidade: " + super.getAgilidade());
		System.out.println("Inteligencia: " + super.getInteligencia());
		System.out.println("Level: " + super.getLevel());
		System.out.println("--------------------------");

	}

	public int ataqueMagicoBasico() {
		int dano = super.getMagia();

		return dano;
	}

	public int ataqueMagicoAgil() {
		int dano = super.getAgilidade() + 10;

		return dano;
	}

	public int magiaAntiga() {
		int dano = 0;

		if (super.getInteligencia() > super.getForca()) {
			dano = super.getMagia() + super.getForca();
		}

		return dano;
	}

	public int passosDoAnciao() {
		int dano = 0;

		if (super.getInteligencia() > super.getMagia()) {
			dano = super.getMagia() + 10;
		}

		return dano;
	}

	public int ataqueBasico() {
		int dano = super.getForca();

		return dano;
	}

	@Override
	public int atacar(int opcao) {
		int ataque = 0;

		switch (opcao) {
		case 0:
			ataque = ataqueMagicoBasico();
			break;

		case 1:
			ataque = ataqueMagicoAgil();
			break;

		case 2:
			ataque = magiaAntiga();
			break;

		case 3:
			ataque = passosDoAnciao();
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
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque magico basico          |");
		System.out.println("|1 - Ataque magico agil            |");
		System.out.println("|2 - Magia antiga                  |");
		System.out.println("|3 - Passos do ancião              |");
		System.out.println("|4 - Ataque basico                 |");
		System.out.println("|----------------------------------|");
		
	}

	@Override
	public void ataquesAventuras() {
		System.out.println("|----------------------------------|");
		System.out.println("|Escolha seu movimento             |");
		System.out.println("|0 - Ataque magico basico          |");
		System.out.println("|1 - Ataque magico agil            |");
		System.out.println("|2 - Magia antiga                  |");
		System.out.println("|3 - Passos do ancião              |");
		System.out.println("|4 - Ataque basico                 |");
		System.out.println("|5 - Abrir inventário              |");
		System.out.println("|----------------------------------|");
		
	}

}
