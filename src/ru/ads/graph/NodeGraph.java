package ru.ads.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Граф на основе набора вершин и списка(сбора) ребер.
 * Теория: Список рёбер может быть представлен как матрица или набора объектов рёбер.
 * Сбор рёбер отличается от списка рёбер тем, что хранит вершины не в виде упорядоченного списка,
 * а использует для хранения коллекцию(сбор),
 * для которой возможен только перебор без возможности обращения по порядковому указателю(определителю).
 * В этом классе воплощение сбора рёбер - это связанный список объектов рёбер.
 * Поэтому он может быть назван связанным списком рёбер.
 */
public class NodeGraph implements IGraph {
    private final Set<IVertex> vertices = new HashSet<>();
    private final Collection<IEdge> IEdges = new LinkedList<>();
    @Override
    public Collection<IVertex> getVertices() {
        return vertices.stream().toList();
    }

    @Override
    public IVertex createVertex(String name) {
        Vertex vertex = new Vertex(name);
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public void createEdge(IVertex IVertex1, IVertex IVertex2, int bandwidth, int lostPacketsCents) {
        IEdges.add(new Edge(IVertex1, IVertex2, bandwidth, lostPacketsCents));
    }

    @Override
    public Collection<IEdge> getEdges(IVertex IVertex) {
        return IEdges.stream().filter(IEdge -> IEdge.getVertex1().equals(IVertex) || IEdge.getVertex2().equals(IVertex)).toList();
    }
}
