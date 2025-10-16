package ru.ads.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Граф, заданный матрицей смежности.
 * Смежность - это соседство, близость.
 */
public class AdjacencyMatrixGraph implements IGraph {
    public static final int MAX_VERTICES = 20;
    private final IVertex[] vertices = new IVertex[MAX_VERTICES]; // Изменен тип массива
    private final IEdge[][] edgesMatrix = new IEdge[MAX_VERTICES][MAX_VERTICES];
    private int vertexCount = 0; // Счетчик добавленных вершин

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
        int index1 = findVertexIndex(vertex1);
        int index2 = findVertexIndex(vertex2);

        if (index1 == -1 || index2 == -1) {
            throw new IllegalArgumentException("One or both vertices are not in the graph");
        }

        edgesMatrix[index1][index2] = new Edge(vertex1, vertex2, bandwidth, lostPacketsCents);
    }

    private int findVertexIndex(IVertex vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Collection<IEdge> getEdges(IVertex vertex) {
        List<IEdge> result = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                IEdge edge = edgesMatrix[i][j];
                if (edge != null && (edge.getVertex1().equals(vertex) || edge.getVertex2().equals(vertex))) {
                    result.add(edge);
                }
            }
        }
        return result;
    }
}
