package ru.ads;

import java.util.Arrays;
import java.util.List;

public class EdgeListTest {

    public static void main(String[] args) {
        testBasicCase();
        testEmptyGraph();
        testFullGraph();
    }

    private static void testBasicCase() {
        /* Входные данные:
        матрица смежности =
        таблица соседства,
        где индексы строк и столбцов соответствуют вершинам графа,
        0 значит, что вершина не связана с другой вершиной,
        1 значит, что вершина связана с другими вершинами
         */
        int[][] matrix = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };

        /* Ожидаемый результат:
        список рёбер, где
        каждому ребру соответствует пара вершин, с которыми оно соединено
         */
        List<int[]> expected = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2}
        );

        List<int[]> result = AdjacencyMatrixToEdgeList.convert(matrix);
        assert compareLists(result, expected) : "Тест basic case провален.";
        System.out.println("✅ Тест basic case пройден.");
    }

    private static void testEmptyGraph() {
        int[][] matrix = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        List<int[]> result = AdjacencyMatrixToEdgeList.convert(matrix);
        assert result.isEmpty() : "Тест empty graph провален.";
        System.out.println("✅ Тест empty graph пройден.");
    }

    private static void testFullGraph() {
        int[][] matrix = {
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}
        };

        List<int[]> expected = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, 2},
            new int[]{1, 2}
        );

        List<int[]> result = AdjacencyMatrixToEdgeList.convert(matrix);
        assert compareLists(result, expected) : "Тест full graph провален.";
        System.out.println("✅ Тест full graph пройден.");
    }

    private static boolean compareLists(List<int[]> list1, List<int[]> list2) {
        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (!Arrays.equals(list1.get(i), list2.get(i))) {
                return false;
            }
        }

        return true;
    }
}