# 📊 Análise de Desempenho: Quick Sort vs. Radix Sort

Este projeto tem como objetivo analisar e comparar o desempenho dos algoritmos de ordenação **Quick Sort** e **Radix Sort**. A avaliação foi baseada em três métricas principais: tempo de execução, número de trocas e número de iterações para diferentes volumes de dados.

**Integrantes do Grupo:**
* Gustavo Gaspar de Campos

---

## ⚙️ Metodologia

A análise foi conduzida utilizando vetores de inteiros preenchidos aleatoriamente com os seguintes tamanhos: **1.000, 10.000, 100.000, 500.000 e 1.000.000**.

Para garantir a consistência e a justiça na comparação, cada algoritmo foi executado **5 vezes** para cada tamanho de vetor, utilizando as mesmas sementes (`seeds`) para a geração de dados em cada rodada. Os resultados apresentados nas tabelas e gráficos representam a **média aritmética** dessas 5 execuções.

As métricas foram definidas da seguinte forma:
* **Tempo de Execução (ms)**: Tempo real (wall-clock) para a ordenação completa do vetor, medido em milissegundos.
* **Número de Trocas**:
  * **Quick Sort**: Contagem de operações de troca de posição entre dois elementos.
  * **Radix Sort**: **Não aplicável (N/A)**, pois sua metodologia de ordenação por "baldes" (bucket sort) não realiza trocas diretas.
* **Número de Iterações**:
  * **Quick Sort**: Número total de **comparações** entre elementos, sendo esta a operação central do algoritmo.
  * **Radix Sort**: Número total de **visitas** aos elementos durante as fases de contagem e reconstrução do vetor, para cada dígito significativo.

---

## 📈 Resultados Consolidados

Os dados obtidos nos testes foram compilados na tabela abaixo para facilitar a comparação direta entre os algoritmos.

### Tabela 1: Comparativo de Desempenho - Quick Sort vs. Radix Sort

| Tamanho | Métrica                      | Quick Sort         | Radix Sort         |
| :------ | :--------------------------- | :----------------- | :----------------- |
| **1.000** | **Tempo (ms)** | **0.88** | 1.98               |
|         | Trocas                       | 4.816              | 0 (N/A)            |
|         | Iterações                    | 11.229             | 12.000             |
| **10.000** | **Tempo (ms)** | **0.68** | 2.76               |
|         | Trocas                       | 73.598             | 0 (N/A)            |
|         | Iterações                    | 155.753            | 150.000            |
| **100.000** | **Tempo (ms)** | **9.89** | 11.96              |
|         | Trocas                       | 933.173            | 0 (N/A)            |
|         | Iterações                    | 1.972.854          | 1.800.000          |
| **500.000** | **Tempo (ms)** | 81.64              | **78.33** |
|         | Trocas                       | 5.332.007          | 0 (N/A)            |
|         | Iterações                    | 11.591.109         | 10.500.000         |
| **1.000.000** | **Tempo (ms)** | 120.24             | **113.81** |
|         | Trocas                       | 11.624.990         | 0 (N/A)            |
|         | Iterações                    | 24.457.923         | 21.000.000         |

---

## 📊 Gráficos e Análise Visual

Os gráficos abaixo ilustram visualmente os dados da tabela, facilitando a identificação de tendências e a comparação de desempenho.

*(**Instrução:** Execute o código Python fornecido na seção seguinte para gerar estes gráficos. Depois, faça o upload dos arquivos .png para seu repositório e substitua os nomes de arquivo abaixo).*

### Gráfico 1: Tempo de Execução vs. Tamanho do Vetor
![Tempo de Execução](grafico_tempo.png)

### Gráfico 2: Número de Trocas vs. Tamanho do Vetor
![Número de Trocas](grafico_trocas.png)

### Gráfico 3: Número de Iterações vs. Tamanho do Vetor
![Número de Iterações](grafico_iteracoes.png)

---

## 📝 Análise e Conclusão

A análise dos dados e dos gráficos revela insights importantes sobre a natureza de cada algoritmo.

### 1. Análise de Tempo de Execução
Para vetores pequenos (até 100.000 elementos), o **Quick Sort se mostrou surpreendentemente mais rápido**. Isso pode ser atribuído à eficiência da sua implementação e ao baixo custo de suas operações em caches de processadores modernos para conjuntos de dados menores.

No entanto, um **ponto de inflexão** claro ocorre entre 100.000 e 500.000 elementos. A partir daí, o **Radix Sort se torna mais eficiente**. O gráfico de tempo de execução mostra a curva do Quick Sort se tornando mais acentuada (crescimento log-linear, $O(n \log n)$), enquanto a do Radix Sort cresce de forma mais controlada e linear ($O(d \cdot n)$). Para 1 milhão de elementos, o Radix Sort já apresenta uma vantagem de tempo considerável.

### 2. Análise de Trocas e Iterações
A métrica de **trocas** expõe uma diferença fundamental: o Quick Sort é um algoritmo *in-place* que depende de trocas constantes, cujo número cresce significativamente com o tamanho do vetor. O Radix Sort, por não ser baseado em comparações, tem **zero trocas**, o que o torna ideal para cenários onde mover dados é uma operação cara.

Quanto às **iterações**, os números do Radix Sort (visitas) e do Quick Sort (comparações) são próximos para vetores menores. Contudo, para vetores maiores, o número de comparações do Quick Sort cresce mais rapidamente que o número de visitas do Radix Sort, o que explica diretamente a diferença de desempenho observada no tempo de execução.

### Conclusão Final

O **Quick Sort** é um algoritmo de propósito geral extremamente eficiente para conjuntos de **dados pequenos a médios**, como visto nos testes de até 100.000 elementos.

No entanto, para a ordenação de **grandes volumes de dados inteiros**, o **Radix Sort demonstra ser superior**. Sua complexidade de tempo linear e a ausência de trocas diretas o tornam mais escalável e performático à medida que o tamanho do vetor aumenta.

Portanto, para o escopo deste trabalho, o **Radix Sort foi o algoritmo mais eficiente para os maiores conjuntos de dados testados**.

---
**Link para o Vídeo:**
