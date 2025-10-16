package ru.ads;

import ru.ads.graph.AdjacencyMatrixGraph;
import ru.ads.graph.ArrayGraph;
import ru.ads.graph.IGraph;
import ru.ads.graph.IVertex;
import ru.ads.graph.NodeGraph;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Node Graph");
        IGraph nodeGraph = new NodeGraph();
        fillGraph(nodeGraph);

        System.out.println("Array Graph");
        IGraph arrayGraph = new ArrayGraph();
        fillGraph(arrayGraph);

        System.out.println("Adjacency Matrix Graph");
        IGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph();
        fillGraph(adjacencyMatrixGraph);
    }

    private static void fillGraph(IGraph IGraph) {
        IVertex IVertexA = IGraph.createVertex("A");
        IVertex IVertexB = IGraph.createVertex("B");
        IVertex IVertexC = IGraph.createVertex("C");
        IVertex IVertexD = IGraph.createVertex("D");
        IVertex IVertexE = IGraph.createVertex("E");
        IVertex IVertexF = IGraph.createVertex("F");
        IGraph.createEdge(IVertexA, IVertexB, 1500, 90);
        IGraph.createEdge(IVertexA, IVertexC, 2000, 10);
        IGraph.createEdge(IVertexA, IVertexD, 1000, 50);
        IGraph.createEdge(IVertexB, IVertexF, 1500, 60);
        IGraph.createEdge(IVertexC, IVertexF, 500, 20);
        IGraph.createEdge(IVertexC, IVertexE, 900, 5);
        IGraph.createEdge(IVertexD, IVertexE, 2500, 1);
        IGraph.createEdge(IVertexE, IVertexF, 300, 85);
        IGraph.getVertices().iterator().forEachRemaining(vertex -> System.out.println(vertex.toString() + " " + Arrays.toString(IGraph.getEdges(vertex).toArray())));
    }
}