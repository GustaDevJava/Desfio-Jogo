package utils;

public class Menus {

	public static void menuPrincipal() {
		System.out.println("|----------------------------------|");
		System.out.println("|Bem-vindo guerreiro(a)            |");
		System.out.println("|Escolha a raça do seu personagem  |");
		System.out.println("|1 - Humano                        |");
		System.out.println("|2 - Elfo                          |");
		System.out.println("|3 - Anão                          |");
		System.out.println("|----------------------------------|");
	}

	public static void subMenuPrincipal() {
		System.out.println("|--------------------------------------|");
		System.out.println("| Guerreiro(a) escolha algo para fazer |");
		System.out.println("|                                      |");
		System.out.println("|1 - Sair para uma aventura            |");
		System.out.println("|2 - Lutar na arena de combate         |");
		System.out.println("|3 - Sair do jogo                      |");
		System.out.println("|--------------------------------------|");
	}

	public static void bannerInimigo() {
		System.out.println("=============================");
		System.out.println("          INIMIGO            ");
		System.out.println("=============================");
	}
	
	public static void bannerMonstro() {
		System.out.println("=============================");
		System.out.println("          MONSTRO            ");
		System.out.println("=============================");
	}

	public static void bannerPlayer(String nome) {
		System.out.println("=============================");
		System.out.println("           " + nome + "         ");
		System.out.println("=============================");
	}

}
