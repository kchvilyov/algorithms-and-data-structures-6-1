package ru.ads.graph;

public class Edge implements IEdge {
    private final IVertex vertex1;
    private final IVertex vertex2;
    private final Integer bandwidth;
    private final Integer lostPacketsCents; // потеря пакетов в процентах * 100 (чтобы избежать проблем с точностью)

    public Edge(IVertex vertex1, IVertex vertex2, int bandwidth, Integer lostPacketsCents) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.bandwidth = bandwidth;
        this.lostPacketsCents = lostPacketsCents;
    }

    @Override
    public IVertex getVertex1() {
        return vertex1;
    }

    @Override
    public IVertex getVertex2() {
        return vertex2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", bandwidth=" + bandwidth +
                ", lostPacketsCents=" + lostPacketsCents +
                '}';
    }
}
