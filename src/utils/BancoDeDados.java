package utils;

import java.util.ArrayList;
import java.util.List;

import models.Personagens;

public class BancoDeDados {

	public static List<Personagens> BancoDeDadosPlayer = new ArrayList<>();

	public static void salvarPlayer(Personagens personagens) {
		BancoDeDadosPlayer.add(personagens);
	}

	public static Personagens buscarPlayer() {

		Personagens personagens = new Personagens();

		if (!BancoDeDadosPlayer.isEmpty()) {
			for (int i = 0; i < BancoDeDadosPlayer.size(); i++) {
				personagens = BancoDeDadosPlayer.get(i);
				break;
			}
		} else {
			personagens = null;
		}
		return personagens;

	}

}
