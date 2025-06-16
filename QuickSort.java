public class QuickSort {
    private long trocas = 0;
    private long iteracoes = 0; // Representa o número de comparações

    public void sort(int[] vetor) {
        this.trocas = 0;
        this.iteracoes = 0;
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Usando o último elemento como pivô
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            iteracoes++; // Incrementa a cada comparação
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    private void trocar(int[] vetor, int i, int j) {
        if (i != j) { // Só conta como troca se os índices forem diferentes
            trocas++;
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
    }

    // Getters para os contadores
    public long getTrocas() { return trocas; }
    public long getIteracoes() { return iteracoes; }
}