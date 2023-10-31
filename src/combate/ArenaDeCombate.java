package combate;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import aventura.Aventura;
import exception.ApenasOsFortesException;
import exception.UltimoRespiroException;
import iventario.Itens;
import models.Lutador;
import models.Personagens;
import racas.Anoes;
import racas.Elfos;
import racas.Humanos;
import utils.BancoDeDados;
import utils.Menus;

public class ArenaDeCombate {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcao;

		Humanos humanos = new Humanos();

		Elfos elfos = new Elfos();

		Anoes anoes = new Anoes();

		Lutador inimigoPersonagens = null;

		int criado = 0;

		do {
			Menus.menuPrincipal();
			opcao = validaNumero(scanner);

			switch (opcao) {
			case 1:
				// HUMANO
				System.out.println("Qual seu nome guerreiro(a)?");
				String nome = scanner.next();

				humanos.mostraAtributosHumano();
				humanos.setNome(nome);

				Itens itens = new Itens();

				itens.setItemDrop("Bastão do troll");
				itens.setRecuperaVida(100);

				humanos.getInventarioPlayer().add(itens);

				System.out.println("Se prepare para o duelo!");

				inimigoPersonagens = geraInimigo();

				BancoDeDados.salvarPlayer(humanos);

				iniciarLuta(scanner, humanos, inimigoPersonagens);
				menuPrincipal(scanner, humanos);
				
				criado = 1;

				break;

			case 2:
				// ELFO
				System.out.println("Qual seu nome guerreiro(a)?");
				nome = scanner.next();

				elfos.mostraAtributosElfo();
				elfos.setNome(nome);

				BancoDeDados.salvarPlayer(elfos);

				System.out.println("Se prepare para o duelo!");

				inimigoPersonagens = geraInimigo();

				iniciarLuta(scanner, elfos, inimigoPersonagens);
				menuPrincipal(scanner, elfos);

				criado = 1;
				break;

			case 3:
				// ANAO
				System.out.println("Qual seu nome guerreiro(a)?");
				nome = scanner.next();

				anoes.mostraAtributosAnao();
				anoes.setNome(nome);

				BancoDeDados.salvarPlayer(anoes);

				System.out.println("Se prepare para o duelo!");

				inimigoPersonagens = geraInimigo();

				iniciarLuta(scanner, anoes, inimigoPersonagens);
				menuPrincipal(scanner, anoes);

				criado = 1;
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (criado != 1);

	}

	public static Lutador geraInimigo() {
		Random random = new Random();

		int inimigo = random.nextInt(3);

		if (inimigo == 0) {
			System.out.println("Seu oponente será um: Humano!");
			System.out.println("---------------------------");
			Humanos inimigoHumanos = new Humanos();
			return inimigoHumanos;

		} else if (inimigo == 1) {
			System.out.println("Seu oponente será um: Elfo!");
			Elfos inimigoElfo = new Elfos();
			System.out.println("---------------------------");
			return inimigoElfo;
		} else {
			System.out.println("Seu oponente será um: Anão!");
			System.out.println("---------------------------");
			Anoes inimigoAnao = new Anoes();
			return inimigoAnao;
		}

	}

	public static void iniciarLuta(Scanner scanner, Lutador heroi, Lutador inimigo) {

		Aventura aventura = new Aventura();

		Random random = new Random();

		int opcao = 0;

		System.out.println("Iniciando a luta!");

		try {

			verificaLevel(heroi, ((Personagens) heroi).isPrimeiraLuta());
			verificaVida(heroi);

			while (((Personagens) heroi).getVida() >= 50 && ((Personagens) inimigo).getVida() > 50) {
				heroi.ataques();

				opcao = validaNumero(scanner);

				switch (opcao) {
				case 0:

					regrasDaLuta(heroi, inimigo, opcao);

					break;

				case 1:

					regrasDaLuta(heroi, inimigo, opcao);

					break;

				case 2:

					regrasDaLuta(heroi, inimigo, opcao);

					break;

				case 3:

					regrasDaLuta(heroi, inimigo, opcao);

					break;

				case 4:

					regrasDaLuta(heroi, inimigo, opcao);

					break;

				default:
					System.out.println("Opção inválida!");
					break;
				}

			}

			if (((Personagens) heroi).getVida() < 50) {
				System.out.println("Você perdeu a luta!");

			} else if (((Personagens) inimigo).getVida() < 50) {
				System.out.println("Você venceu a luta!");
				((Personagens) heroi).setPrimeiraLuta(false);
				
			}

		} catch (ApenasOsFortesException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void verificaLevel(Lutador heroi, boolean primeiraLuta) {

		if (((Personagens) heroi).getLevel() < 10) {
			if (primeiraLuta == false) {
				throw new ApenasOsFortesException();
			}

		}
	}

	public static void verificaVida(Lutador heroi) {

		if (((Personagens) heroi).getVida() <= 50) {
			throw new UltimoRespiroException();
		}
	}

	public static void regrasDaLuta(Lutador heroi, Lutador inimigo, int opcao) {

		Random random = new Random();

		int ataqueInimigo = random.nextInt(4);

		heroi.atacar(opcao);

		Menus.bannerPlayer(((Personagens) heroi).getNome());
		System.out.println("Sua vida: " + ((Personagens) heroi).getVida());
		System.out.println("Você causou " + heroi.atacar(opcao) + " de dano no seu adversário");

		inimigo.receberDano(heroi.atacar(opcao));

		Menus.bannerInimigo();

		System.out.println("Vida do inimigo: " + ((Personagens) inimigo).getVida());
		System.out.println("Força do inimigo: " + ((Personagens) inimigo).getForca());

		if (((Personagens) inimigo).getVida() > 0) {
			inimigo.atacar(ataqueInimigo);
			System.out.println("O adversário te atacou e te causou: " + inimigo.atacar(ataqueInimigo) + " de dano");

			Menus.bannerPlayer(((Personagens) heroi).getNome());

			heroi.receberDano(inimigo.atacar(ataqueInimigo));
			System.out.println("Sua vida restante: " + ((Personagens) heroi).getVida());

		} else {

			Menus.bannerPlayer(((Personagens) heroi).getNome());

			System.out.println("Sua vida Atual: " + ((Personagens) heroi).getVida());
		}

	}

	public static void menuPrincipal(Scanner scanner, Lutador heroi) {

		int opcao;
		Aventura aventura = new Aventura();
		Menus menus = new Menus();

		do {

			menus.subMenuPrincipal();
			opcao = validaNumero(scanner);

			switch (opcao) {
			case 1:
				aventura.iniciarAventura();
				break;
			case 2:
				Lutador inimigo = geraInimigo();
				iniciarLuta(scanner, heroi, inimigo);
				break;
			case 3:
				System.out.println("Saindo do jogo, Tchau guerreiro!");
				break;
			default:
				System.out.println("Opção inválida");
			}

		} while (opcao != 3);

	}

	public static int validaNumero(Scanner scanner) {

		int opcao = 0;

		boolean numeroValido = false;
		while (!numeroValido) {
			try {
				opcao = scanner.nextInt();
				numeroValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Você deve inserir um número válido. Tente novamente: ");
				scanner.nextLine();
			}
		}

		return opcao;
	}

}
