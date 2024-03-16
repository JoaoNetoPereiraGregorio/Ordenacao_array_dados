package Prova;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Intercala.Nota;

public class AnaliseArquivo {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Item> items = new ArrayList<>();
		Map<String, ArrayList<Item>> raceMap = new HashMap<>();
		Map<String, ArrayList<Item>> nivelMap = new HashMap<>();
		Map<String, ArrayList<Item>> lunchMap = new HashMap<>();
		Scanner scanner = new Scanner(new File("C:\\Users\\joaon\\Downloads\\StudentsPerformance.csv"));// Adicione o
																										// seu caminho
																										// para o
																										// arquivo

		scanner.nextLine();
		while (scanner.hasNext()) {

			Item item = new Item(scanner.nextLine().split(","));
			items.add(item);
			addMapRace(raceMap, item);
			addMapNivel(nivelMap, item);
			addMapLunch(lunchMap, item);
			addMapCurso(lunchMap, item);

		}
		while (true) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(
					"Escolha uma opção:\n\n1- Ordenar por mathScore e ver maior e menor .\n\n2- Ordenar por readScore e ver maior e menor"
							+ "\n\n3- Ordenar por  writeScore e ver maior e menor\n\n4-Listar grupo.\n\n5-Listar nível de escolaridade dos pais."
							+ "\n\n6- Listar por Lunch.\n\n7- Listar por curso de preparação\n\n8- Sair"));

			switch (escolha) {
			case 1: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				quickMath(items, 0, 999);
				imprime(items);
				JOptionPane.showMessageDialog(null, "Menor nota de Matematica:" + items.get(0).getMathScore()
						+ "\n\n\nMaior nota de Matematica:" + items.get(items.size() - 1).getMathScore());

				break;

			}

			case 2: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				quickRead(items, 0, 999);
				imprime(items);
				JOptionPane.showMessageDialog(null, "Menor nota de Leitura:" + items.get(0).getReadScore()
						+ "\n\n\nMaior nota de Leitura:" + items.get(items.size() - 1).getReadScore());

				break;
			}

			case 3: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				quickWrite(items, 0, 999);
				imprime(items);
				JOptionPane.showMessageDialog(null, "Menor nota de Escrita:" + items.get(0).getWriteScore()
						+ "\n\n\nMaior nota de Escrita:" + items.get(items.size() - 1).getWriteScore());
				break;
			}

			case 4: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				int escolhaNomeGrupo = Integer.parseInt(JOptionPane.showInputDialog(
						"Escolha um grupo:\n\n" + "1- Grupo A\n2- Grupo B\n3- Grupo C\n4- Grupo D\n5- Grupo E"));
				String nomeGrupo = null;
				switch (escolhaNomeGrupo) {
				case 1: {
					nomeGrupo = "A";
					break;
				}
				case 2: {
					nomeGrupo = "B";
					break;
				}
				case 3: {
					nomeGrupo = "C";
					break;
				}
				case 4: {
					nomeGrupo = "D";
					break;
				}
				case 5: {
					nomeGrupo = "E";
					break;
				}

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
					break;
				}

				listarGrupo(raceMap, "group " + nomeGrupo);
				break;
			}

			case 5: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				String nivel = null;
				int escolhaNivel = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o Nível de escolaridade dos pais que deseja Visualizar:\n\n"
								+ "1- some college\n2- associate's degree\n3- some high school\n4- bachelor's degree"
								+ "\n5- high school\n6- master's degree"));

				switch (escolhaNivel) {
				case 1: {
					nivel = "some college";
					break;
				}

				case 2: {
					nivel = "associate's degree";
					break;
				}

				case 3: {
					nivel = "some high school";
					break;
				}

				case 4: {
					nivel = "bachelor's degree";
					break;
				}

				case 5: {
					nivel = "high school";
					break;
				}

				case 6: {
					nivel = "master's degree";
					break;
				}

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
					break;

				}

				listarNivelEducacao(nivelMap, nivel);
				break;
			}

			case 6: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				String lunch = null;
				int escolhaLunch = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o Lunch que deseja Visualizar:\n\n" + "1- standard\n2- free/reduced"));

				switch (escolhaLunch) {
				case 1: {
					lunch = "standard";
					break;
				}

				case 2: {
					lunch = "free/reduced";
					break;
				}

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
					break;
				}
				lunch(lunchMap, lunch);
				break;
			}

			case 7: {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				String curso = null;

				int escolhaCurso = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o curso:\n\n1- none\n2- completed"));

				switch (escolhaCurso) {
				case 1: {
					curso = "none";
					break;
				}

				case 2: {
					curso = "completed";
					break;
				}

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
					break;
				}
				cursoPreparacao(lunchMap, curso);
				break;
			}

			case 8: {
				System.exit(0);
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "Opcão Invalida");
				break;
			}
		}
	}

	public static void addMapRace(Map<String, ArrayList<Item>> raceMap, Item item) {
		raceMap.computeIfAbsent(item.getRace(), k -> new ArrayList<>()).add(item);
	}

	public static void addMapNivel(Map<String, ArrayList<Item>> nivelMap, Item item) {
		nivelMap.computeIfAbsent(item.getParentalLevelEducation(), k -> new ArrayList<>()).add(item);
	}

	public static void addMapLunch(Map<String, ArrayList<Item>> lunchMap, Item item) {
		lunchMap.computeIfAbsent(item.getLunch(), k -> new ArrayList<>()).add(item);
	}

	public static void addMapCurso(Map<String, ArrayList<Item>> cursoMap, Item item) {
		cursoMap.computeIfAbsent(item.getTestPreparation(), k -> new ArrayList<>()).add(item);
	}

	public static void imprime(ArrayList<Item> items) {
		int cont = 0;
		for (Item item : items) {
			cont++;
			System.out.println(item + "  contador  " + cont);

		}

	}

	public static int particionaMath(ArrayList<Item> items, int inicio, int termino) {
		int menoresAteAgora = (inicio);
		Item pivo = items.get(termino);

		for (int analisandoAgora = inicio; analisandoAgora <= termino; analisandoAgora++) {
			if (items.get(analisandoAgora).getMathScore() < pivo.getMathScore()) {
				troca(items, analisandoAgora, menoresAteAgora);
				menoresAteAgora++;
			}

			if (analisandoAgora == termino) {
				troca(items, termino, menoresAteAgora);

			}

		}
		return menoresAteAgora;
	}

	public static void quickMath(ArrayList<Item> items, int inicio, int termino) {

		if (inicio < termino) {
			int pivo = particionaMath(items, inicio, termino);

			quickMath(items, inicio, pivo - 1);
			quickMath(items, pivo + 1, termino);
		}
	}

	public static int particionaRead(ArrayList<Item> items, int inicio, int termino) {
		int menoresAteAgora = (inicio);
		Item pivo = items.get(termino);

		for (int analisandoAgora = inicio; analisandoAgora <= termino; analisandoAgora++) {
			if (items.get(analisandoAgora).getReadScore() < pivo.getReadScore()) {
				troca(items, analisandoAgora, menoresAteAgora);
				menoresAteAgora++;
			}

			if (analisandoAgora == termino) {
				troca(items, termino, menoresAteAgora);

			}

		}
		return menoresAteAgora;
	}

	public static void quickRead(ArrayList<Item> items, int inicio, int termino) {

		if (inicio < termino) {
			int pivo = particionaRead(items, inicio, termino);

			quickRead(items, inicio, pivo - 1);
			quickRead(items, pivo + 1, termino);
		}
	}

	public static int particionaWrite(ArrayList<Item> items, int inicio, int termino) {
		int menoresAteAgora = (inicio);
		Item pivo = items.get(termino);

		for (int analisandoAgora = inicio; analisandoAgora <= termino; analisandoAgora++) {
			if (items.get(analisandoAgora).getWriteScore() < pivo.getWriteScore()) {
				troca(items, analisandoAgora, menoresAteAgora);
				menoresAteAgora++;
			}

			if (analisandoAgora == termino) {
				troca(items, termino, menoresAteAgora);

			}

		}
		return menoresAteAgora;
	}

	public static void quickWrite(ArrayList<Item> items, int inicio, int termino) {

		if (inicio < termino) {
			int pivo = particionaWrite(items, inicio, termino);

			quickWrite(items, inicio, pivo - 1);
			quickWrite(items, pivo + 1, termino);
		}
	}

	public static void troca(ArrayList<Item> items, int a, int b) {
		Item aux;

		aux = items.get(a);
		items.set(a, items.get(b));
		items.set(b, aux);

	}

	public static void listarGrupo(Map<String, ArrayList<Item>> raceMap, String nomeGrupo) {

		List<Item> itemsGroup = raceMap.get(nomeGrupo);
		for (Item item : itemsGroup) {
			System.out.println(item.toString());
		}

	}

	public static void listarNivelEducacao(Map<String, ArrayList<Item>> nivelMap, String nivel) {
		List<Item> itemsGroup = nivelMap.get(nivel);
		for (Item item : itemsGroup) {
			System.out.println(item.toString());
		}
	}

	public static void lunch(Map<String, ArrayList<Item>> lunchMap, String lunch) {
		List<Item> itemsGroup = lunchMap.get(lunch);
		for (Item item : itemsGroup) {
			System.out.println(item.toString());
		}
	}

	public static void cursoPreparacao(Map<String, ArrayList<Item>> cursoMap, String curso) {
		List<Item> itemsGroup = cursoMap.get(curso);
		for (Item item : itemsGroup) {
			System.out.println(item.toString());
		}
	}

}
