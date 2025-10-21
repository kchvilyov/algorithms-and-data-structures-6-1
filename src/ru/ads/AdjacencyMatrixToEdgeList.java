package ru.ads;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixToEdgeList {

    /**
     * Преобразует матрицу смежности в список рёбер.
     * Смежность - это соседство, близость.
     *
     * @param adjacencyMatrix матрица смежности (n x n)
     *         = таблица соседства, таблица связи через рёбра.
     *         Рёбра для понимания смежности можно назвать
     *              связующими межами(промежутками, промежностями) между вершинами графа.
     *         где индексы строк и столбцов соответствуют вершинам графа.
     *         0 значит, что вершина не связана(соседствует, смежна через ребро) с другой вершиной,
     *         1 значит, что вершина связана(соседствует, смежна через ребро) с другими вершинами
     * @return список рёбер в виде пар (firstVerticalIndex, secondVerticalIndex),
     *              где firstVerticalIndex < secondVerticalIndex это номера вершин,
     *              причём первый определитель меньше второго, чтобы исключить повтор.
     *         Каждому ребру соответствует пара вершин, с которыми ребро соединено.
     */
    public static List<int[]> convert(int[][] adjacencyMatrix) {
        List<int[]> edgesList = new ArrayList<>();

        //Определитель первой вершины
        for (int firstVerticalIndex = 0; firstVerticalIndex < adjacencyMatrix.length; firstVerticalIndex++) {
            //Определитель второй вершины, больше определителя первой вершины
            for (int secondVerticalIndex = firstVerticalIndex + 1; secondVerticalIndex < adjacencyMatrix[firstVerticalIndex].length; secondVerticalIndex++) {
                if (adjacencyMatrix[firstVerticalIndex][secondVerticalIndex] == 1) {
                    edgesList.add(new int[]{firstVerticalIndex, secondVerticalIndex});
                }
            }
        }

        return edgesList;
    }
}