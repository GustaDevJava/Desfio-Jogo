package aventura;

import java.util.Random;
import java.util.Scanner;

import combate.ArenaDeCombate;
import exception.ItemForaDoLimiteException;
import iventario.Itens;
import models.Lutador;
import models.Personagens;
import monstros.Bruxa;
import monstros.Golem;
import monstros.Trolls;
import utils.BancoDeDados;
import utils.Menus;

public class Aventura {

	public static void iniciarAventura() {

		Personagens personagens = new Personagens();

		personagens = BancoDeDados.buscarPlayer();

		Lutador inimigoPersonagens = null;

		Scanner scanner = new Scanner(System.in);
		int opcao;

		Menus.subMenuPrincipal();

		opcao = scanner.nextInt();

		System.out.println("Iniciou jornada");

		for (int i = 0; i <= 5; i++) {
			System.out.println(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Menus.bannerMonstro();
		inimigoPersonagens = geraMonstro();
		iniciarLuta(personagens, inimigoPersonagens);

	}

	public static void iniciarLuta(Personagens heroi, Lutador inimigo) {

		Random random = new Random();

		int opcao = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Iniciando a batalha! Boa sorte.");

		while (((Personagens) heroi).getVida() >= 50 && ((Personagens) inimigo).getVida() > 50) {
			((Lutador) heroi).ataquesAventuras();

			opcao = scanner.nextInt();
			switch (opcao) {
			case 0:

				regrasDaBatalhaMonstro((Lutador) heroi, inimigo, opcao);

				break;

			case 1:

				regrasDaBatalhaMonstro((Lutador) heroi, inimigo, opcao);

				break;

			case 2:

				regrasDaBatalhaMonstro((Lutador) heroi, inimigo, opcao);

				break;

			case 3:

				regrasDaBatalhaMonstro((Lutador) heroi, inimigo, opcao);

				break;

			case 4:

				regrasDaBatalhaMonstro((Lutador) heroi, inimigo, opcao);

				break;

			case 5:

				if (!heroi.getInventarioPlayer().isEmpty()) {

					int opcaoInventario;
					int vidaPlayer = heroi.getVida();
					int index = 0;

					for (int i = 0; i < heroi.getInventarioPlayer().size(); i++) {

						System.out.println("id: " + i);
						System.out.println("nome: " + heroi.getInventarioPlayer().get(i).getItemDrop());
						System.out.println(
								"efeito: recupera " + heroi.getInventarioPlayer().get(i).getRecuperaVida() + " de vida.");

						index = i;

					}

					System.out.println("Escolha qual item quer usar passando o ID do item.");
					opcaoInventario = scanner.nextInt();
					try {
						verificaTamanhoLista(opcaoInventario, index);
						vidaPlayer += heroi.getInventarioPlayer().get(opcaoInventario).getRecuperaVida();
						heroi.getInventarioPlayer().remove(opcaoInventario);

						heroi.setVida(vidaPlayer);
					} catch (ItemForaDoLimiteException e) {
						System.out.println(e);
					}

				} else {
					System.out.println("Inventario vazio");
				}

				break;

			default:
				break;
			}

		}

		if (((Personagens) heroi).getVida() < 50) {
			System.out.println("Você perdeu a luta!");

		} else if (((Personagens) inimigo).getVida() < 50) {
			System.out.println("Você venceu a luta!");

			if (((Personagens) inimigo).getItem() != null) {

				System.out.println("O Inimigo dropou um item : " + ((Personagens) inimigo).getItem().getItemDrop());

				heroi.setLevel(heroi.getLevel() + 1);
				System.out.println("LEVEL UP:" + heroi.getLevel());

			} else {
				System.out.println("Inventario vazio");
			}

			((Personagens) heroi).getInventarioPlayer().add(((Personagens) inimigo).getItem());

		}

	}

	public static Lutador geraMonstro() {

		Itens itens = new Itens();

		Random random = new Random();

		int inimigo = random.nextInt(3);

		if (inimigo == 0) {
			System.out.println("Você entrou numa fria. BATALHE COM O TROLL!");
			System.out.println("------------------------------------------");

			itens.setItemDrop("Bastão do troll");
			itens.setRecuperaVida(100);
			Trolls inimigoTrolls = new Trolls(itens);

			return inimigoTrolls;

		} else if (inimigo == 1) {
			System.out.println("Você entrou numa fria. BATALHE COM A BRUXA-MÃE!");
			System.out.println("------------------------------------------");
			Bruxa inimigoBruxa = new Bruxa();

			itens.setItemDrop("Poção de cura.");
			itens.setRecuperaVida(200);
			inimigoBruxa = new Bruxa(itens);

			return inimigoBruxa;

		} else {
			System.out.println("Você entrou numa fria. BATALHE COM O GOLEM!!");
			System.out.println("------------------------------------------");
			Golem inimigoGolem = new Golem();

			itens.setItemDrop("Coração de pedra.");
			itens.setRecuperaVida(100);
			inimigoGolem = new Golem(itens);

			return inimigoGolem;

		}

	}

	public static void verificaTamanhoLista(int opcao, int index) {

		if (opcao > index || opcao < index) {

			throw new ItemForaDoLimiteException();

		}

	}

	public static void regrasDaBatalhaMonstro(Lutador heroi, Lutador monstro, int opcao) {

		Random random = new Random();

		int ataqueInimigo = random.nextInt(4);

		heroi.atacar(opcao);

		Menus.bannerPlayer(((Personagens) heroi).getNome());
		System.out.println("Sua vida: " + ((Personagens) heroi).getVida());
		System.out.println("Você causou " + heroi.atacar(opcao) + " de dano no seu adversário");

		monstro.receberDano(heroi.atacar(opcao));

		Menus.bannerInimigo();

		System.out.println("Vida do inimigo: " + ((Personagens) monstro).getVida());
		System.out.println("Força do inimigo: " + ((Personagens) monstro).getForca());

		monstro.atacar(ataqueInimigo);
		System.out.println("O adversário te atacou e te causou: " + monstro.atacar(ataqueInimigo) + " de dano");

		Menus.bannerPlayer(((Personagens) heroi).getNome());

		heroi.receberDano(monstro.atacar(ataqueInimigo));
		System.out.println("Sua vida restante: " + ((Personagens) heroi).getVida());

	}

}
