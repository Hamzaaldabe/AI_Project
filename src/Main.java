import java.util.*;

public class Main {
    public static void main(String[] args){
        Graph<String> g = new Graph<String>();

        g.addEdge("A", "B");
        g.addEdge("A", "E");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        g.addEdge("C", "D");
        g.addEdge("D", "E");
        g.addEdge("A", "G");
        g.addEdge("F", "E");
        g.addEdge("F", "G");

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
                for (Object v : aAdjVertices) {
                    stack.push(v.toString());
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
            for (Object v : aAdjVertices) {
                if (!visited.contains(v.toString())) {
                    visited.add(v.toString());
                    queue.add(v.toString());
                }
            }
        }
        StringBuilder path = new StringBuilder("BFS path from "+root+" to "+goal+": ");
        for (String v: visited)
            path.append(v).append("->");

        return path.append(goal).toString();
    }
}


