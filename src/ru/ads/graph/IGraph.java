package ru.ads.graph;

import java.util.Collection;

public interface IGraph {
    Collection<IVertex> getVertices();

    IVertex createVertex(String a);

    void createEdge(IVertex IVertex1, IVertex IVertex2, int bandwidth, int lostPacketsCents);

    Collection<IEdge> getEdges(IVertex IVertex);
}
