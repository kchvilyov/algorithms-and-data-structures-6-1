package ru.ads;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixToEdgeList {

    /**
     * Преобразует матрицу смежности в список рёбер.
     * Смежность - это соседство, близость.
     *
     * @param matrix матрица смежности (n x n)
     * @return список рёбер в виде пар (i, j), где i < j
     */
    public static List<int[]> convert(int[][] matrix) {
        List<int[]> edgeList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    edgeList.add(new int[]{i, j});
                }
            }
        }

        return edgeList;
    }
}