import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		while (true) {
			System.out.println(
					"Digite quantos elementos voc� quer entre 10, 100, 1.000, 10.000, 100.000 e 1.000.000(digite outro n�mero para sair):");
			int elementos = leitor.nextInt();
			while (elementos != 10 || elementos != 100 || elementos != 1000 || elementos != 10000 || elementos != 100000
					|| elementos != 1000000) {
				System.out.println(
						"Qual algoritmo voc� deseja usar para ordenar:\n1-InsertionSort\n2-SelectionSort\n3-BubbleSort\n4-MergeSort\n5-QuickSort\n6-Sair"
								+ "\nDigite o n�mero que corresponde ao algoritmo:");
				int algoritmo = leitor.nextInt();
				if (algoritmo == 6) {
					break;
				}
				int tipo = 0;
				while (tipo != 5) {
					System.out.println(
							"Qual tipo de ordena��o voc� quer usar:\n1-Ordenados\n2-Inversamente ordenados\n3-Quase ordenados\n4-Ordem Aleat�ria\n5-Sair\n"
									+ "Digite o n�mero que corresponde ao tipo de ordena��o:");
					tipo = leitor.nextInt();
					if (tipo == 5) {
						break;
					}
					InicializadorDeLista iniciador = new InicializadorDeLista(elementos);
					List<Integer> vetor = iniciador.getListaOrdenada();
					if (tipo == 2) {
						vetor = iniciador.getListaInversamenteOrdenada();
					} else if (tipo == 3) {
						vetor = iniciador.getListaQuaseOrdenada();
					} else if (tipo == 4) {
						vetor = iniciador.getListaAleatoria();
					}
					AlgoritmoDeOrdenacao[] algoritmos = { new InsertionSort(), new SelectionSort(), new BubbleSort(),
							new MergeSort(), new QuickSort() };
					algoritmos[algoritmo - 1].sort(vetor);
					long inicioDoTeste = AlgoritmoDeOrdenacao.getInicioDoTeste();
					long finalDoTeste = AlgoritmoDeOrdenacao.getFinalDoTeste();
					System.out.println("====================================================\nExecu��o"
							+ " elementos aleatorios " + (finalDoTeste - inicioDoTeste)
							+ " Milisegundos\nQuatidade de teste de chaves " + SelectionSort.getTesteDeChaves()
							+ "\nQuantidade de chaves trocadas " + SelectionSort.getTrocaDeChaves()
							+ "\n====================================================\n");
				}
			}
		}
	}
}
