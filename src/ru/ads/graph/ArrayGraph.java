package ru.ads.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Граф на основе массива вершин массива ребер.
 * Теория: Список рёбер может быть представлен как матрица или набора объектов рёбер.
 * Массив рёбер отличается от списка рёбер тем, что хранит вершины не в виде упорядоченного списка,
 * а использует для хранения упорядоченный массив.
 * Поэтому он может быть назван связанным массивом рёбер.
 */
public class ArrayGraph implements IGraph {
    public static final int MAX_VERTICES = 20;
    private static final int MAX_EDGES = 10;
    private final IVertex[] vertices = new IVertex[MAX_VERTICES]; // Изменен тип массива
    private final IEdge[] edges = new IEdge[MAX_EDGES];
    private int vertexCount = 0; // Счетчик добавленных вершин
    private int edgeCount = 0;

    @Override
    public Collection<IVertex> getVertices() {
        List<IVertex> result = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i] != null) {
                result.add(vertices[i]);
            }
        }
        return result;
    }

    @Override
    public IVertex createVertex(String name) {
        if (vertexCount >= vertices.length) {
            throw new IllegalStateException("Maximum number of vertices reached");
        }
        IVertex vertex = new Vertex(name);
        vertices[vertexCount++] = vertex;
        return vertex;
    }

    @Override
    public void createEdge(IVertex vertex1, IVertex vertex2, int bandwidth, int lostPacketsCents) {
        edges[edgeCount++] = new Edge(vertex1, vertex2, bandwidth, lostPacketsCents);
    }

    @Override
    public Collection<IEdge> getEdges(IVertex vertex) {
        return Arrays.stream(edges)
                .filter(edge -> edge != null && (edge.getVertex1().equals(vertex) || edge.getVertex2().equals(vertex)))
                .collect(Collectors.toList());
    }
}
