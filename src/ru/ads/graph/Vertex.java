package ru.ads.graph;

public record Vertex(String name) implements IVertex {

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
