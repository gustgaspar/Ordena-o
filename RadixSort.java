import java.util.Arrays;

public class RadixSort {
    private long iteracoes = 0;

    public void sort(int[] vetor) {
        this.iteracoes = 0;
        if (vetor.length == 0) return;

        // 1. Encontrar o valor máximo para saber o número de dígitos
        int max = Arrays.stream(vetor).max().getAsInt();

        // 2. Fazer o Counting Sort para cada dígito. exp é 10^i (1, 10, 100...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(vetor, exp);
        }
    }

    private void countingSort(int[] vetor, int exp) {
        int n = vetor.length;
        int[] saida = new int[n];
        int[] contagem = new int[10]; // 0 a 9

        // Inicializa o array de contagem com zeros
        Arrays.fill(contagem, 0);

        // Armazena a contagem de ocorrências em contagem[]
        for (int i = 0; i < n; i++) {
            contagem[(vetor[i] / exp) % 10]++;
            iteracoes++; // Cada visita ao elemento conta como uma iteração
        }

        // Altera contagem[i] para que contenha a posição real do dígito no array de saída
        for (int i = 1; i < 10; i++) {
            contagem[i] += contagem[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            saida[contagem[(vetor[i] / exp) % 10] - 1] = vetor[i];
            contagem[(vetor[i] / exp) % 10]--;
            iteracoes++; // Cada visita para reconstrução também conta
        }

        // Copia o array de saída para o vetor original
        for (int i = 0; i < n; i++) {
            vetor[i] = saida[i];
            iteracoes++;
        }
    }

    // Getters
    public long getTrocas() { return 0; } // Radix não faz trocas
    public long getIteracoes() { return iteracoes; }
}