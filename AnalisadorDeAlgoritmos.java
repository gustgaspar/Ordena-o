import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AnalisadorDeAlgoritmos {

    public static void main(String[] args) {
        // Define os tamanhos dos vetores a serem testados
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int numRodadas = 5;

        System.out.println("Iniciando análise de algoritmos de ordenação...");
        System.out.println("==============================================");

        // Loop para cada tamanho de vetor
        for (int tamanho : tamanhos) {
            System.out.println("\nAnalisando para vetores de tamanho: " + tamanho);
            System.out.println("----------------------------------------------");

            long tempoTotalQuick = 0;
            long trocasTotalQuick = 0;
            long iteracoesTotalQuick = 0;

            long tempoTotalRadix = 0;
            long trocasTotalRadix = 0; // Radix não faz trocas, mas mantemos para consistência
            long iteracoesTotalRadix = 0;

            // Executa as N rodadas para calcular a média
            for (int i = 0; i < numRodadas; i++) {
                int seed = i; // Usar uma seed diferente para cada rodada, mas a mesma para ambos os algoritmos

                // --- Teste do Quick Sort ---
                int[] vetorQuick = gerarVetorAleatorio(tamanho, seed);
                QuickSort quickSort = new QuickSort();

                long inicioQuick = System.nanoTime();
                quickSort.sort(vetorQuick);
                long fimQuick = System.nanoTime();

                tempoTotalQuick += (fimQuick - inicioQuick);
                trocasTotalQuick += quickSort.getTrocas();
                iteracoesTotalQuick += quickSort.getIteracoes();

                // --- Teste do Radix Sort ---
                int[] vetorRadix = gerarVetorAleatorio(tamanho, seed); // O mesmo vetor!
                RadixSort radixSort = new RadixSort();

                long inicioRadix = System.nanoTime();
                radixSort.sort(vetorRadix);
                long fimRadix = System.nanoTime();

                tempoTotalRadix += (fimRadix - inicioRadix);
                trocasTotalRadix += radixSort.getTrocas();
                iteracoesTotalRadix += radixSort.getIteracoes();
            }

            // Calcula e imprime as médias
            System.out.println("Resultados para Quick Sort (Média de " + numRodadas + " rodadas):");
            System.out.printf("  Tempo de Execução: %.2f ms\n", (double) (tempoTotalQuick / numRodadas) / 1_000_000.0);
            System.out.println("  Número de Trocas: " + (trocasTotalQuick / numRodadas));
            System.out.println("  Número de Iterações (Comparações): " + (iteracoesTotalQuick / numRodadas));

            System.out.println("\nResultados para Radix Sort (Média de " + numRodadas + " rodadas):");
            System.out.printf("  Tempo de Execução: %.2f ms\n", (double) (tempoTotalRadix / numRodadas) / 1_000_000.0);
            System.out.println("  Número de Trocas: " + (trocasTotalRadix / numRodadas) + " (N/A)");
            System.out.println("  Número de Iterações (Visitas a elementos): " + (iteracoesTotalRadix / numRodadas));
        }
    }


    public static int[] gerarVetorAleatorio(int tamanho, int seed) {
        int[] vetor = new int[tamanho];
        Random random = new Random(seed);
        for (int i = 0; i < tamanho; i++) {
            // Gera números entre 0 e tamanho * 10 para ter variedade
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }
}