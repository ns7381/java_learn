package com.nathan.learn.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Graph {
    static class Vertex {
        private boolean calculated;
        private final String name;
        private int distance;
        private Vertex prev;

        public Vertex(String name) {
            this.calculated = false;
            this.distance = Integer.MAX_VALUE;
            this.prev = null;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Vertex vertex = (Vertex) o;
            return Objects.equals(name, vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Edge {
        private final Vertex startVertex;
        private final Vertex endVertex;
        private final int weight;

        public Edge(Vertex startVertex, Vertex endVertex, int weight) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }
    }

    private final List<Vertex> vertices;

    private final Map<Vertex, List<Edge>> vertexEdges;

    public Graph(List<Vertex> vertices, Map<Vertex, List<Edge>> vertexEdges) {
        this.vertices = vertices;
        this.vertexEdges = vertexEdges;
    }

    public void initialize(Vertex v) {
        v.prev = null;
        v.distance = 0;
    }

    private void calculate(Vertex v) {
        if (v == null) {
            return;
        }
        if (vertexEdges.get(v) == null || vertexEdges.get(v).size() == 0) {
            return;
        }
        List<Vertex> nextVertices = new LinkedList<>();
        for (Edge e : vertexEdges.get(v)) {
            Vertex next = e.endVertex;

            if (!next.calculated) {
                next.calculated = true;
                next.distance = v.distance + e.weight;
                next.prev = v;
                nextVertices.add(next);
            }

            int nowDist = v.distance + e.weight;
            if (nowDist < next.distance) {
                next.distance = nowDist;
                next.prev = v;
            }
        }
        for (Vertex vc : nextVertices) {
            calculate(vc);
        }
    }


    public List<String> shortestPath(Vertex start, Vertex dest) {
        initialize(start);
        calculate(start);
        List<String> shortestPath = new ArrayList<>();
        while ((dest.prev != null) && (!dest.equals(start))) {
            shortestPath.add(0, dest.prev.name);
            dest = dest.prev;
        }
        return shortestPath;
    }

    public List<String> getShortestInvocationChain(Map<String, List<String>> serviceInvocations,
                                                   Map<String, Integer> invocationsTime,
                                                   String start, String end) {
        Map<String, Vertex> vertexMap = invocationsTime.keySet()
                .stream()
                .map(Vertex::new)
                .collect(Collectors.toMap(v -> v.name, v -> v));
        Map<Vertex, List<Edge>> vertexEdges = new HashMap<>();
        serviceInvocations.forEach((from, toList) -> {
            List<Edge> edges = new ArrayList<>();
            Vertex startVertex = vertexMap.get(from);
            toList.forEach(to -> {
                edges.add(new Edge(startVertex, vertexMap.get(to), invocationsTime.get(to)));
            });
            vertexEdges.put(startVertex, edges);
        });
        Graph graph = new Graph(new ArrayList(vertexMap.keySet()), vertexEdges);

        return graph.shortestPath(vertexMap.get(start), vertexMap.get(end));
    }

}




