import java.util.*;

public class Main {
    public static void main(String[] args){
        Graph g = new Graph();

        g.addEdge("A", "B", 10);
        g.addEdge("A", "E", 15);
        g.addEdge("B", "C", 10);
        g.addEdge("B", "D", 10);
        g.addEdge("B", "E", 10);
        g.addEdge("C", "D", 10);
        g.addEdge("D", "E", 10);
        g.addEdge("A", "G", 10);
        g.addEdge("F", "E", 10);
        g.addEdge("F", "G", 10);

        System.out.println("Graph:\n" + g);

        String root = "A";
        String goal = "F";

        System.out.println(depthFirstSearch(g, root, goal));
        System.out.println(breadthFirstSearch(g, root, goal));

    }

    public static String depthFirstSearch(Graph graph, String root, String goal) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                List<String> aAdjVertices = graph.getAdjVertices(vertex);
                if(aAdjVertices.contains(goal))
                    break;
                Collections.sort(aAdjVertices);
                Collections.reverse(aAdjVertices);
                for (String v : aAdjVertices) {
                    stack.push(v);
                }
            }
        }
        StringBuilder path = new StringBuilder("DFS path from "+root+" to "+goal+": ");
        for (String v: visited)
            path.append(v).append("->");

        return path.append(goal).toString();
    }

    public static String breadthFirstSearch(Graph graph, String root, String goal) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            List<String> aAdjVertices = graph.getAdjVertices(vertex);
            if(aAdjVertices.contains(goal))
                break;
            Collections.sort(aAdjVertices);
            for (String v : aAdjVertices) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        StringBuilder path = new StringBuilder("BFS path from "+root+" to "+goal+": ");
        for (String v: visited)
            path.append(v).append("->");

        return path.append(goal).toString();
    }

    public static String aStar(Graph graph, String root, String goal) {
        Set<String> visited = new LinkedHashSet<String>();
        PriorityQueue<String> queue = new PriorityQueue<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            List<String> aAdjVertices = graph.getAdjVertices(vertex);

            for (String v : aAdjVertices) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        StringBuilder path = new StringBuilder("BFS path from "+root+" to "+goal+": ");
        for (String v: visited)
            path.append(v).append("->");

        return path.append(goal).toString();
    }
}


