package AlgorithmsFundamentals.GraphTheoryTraversalAndShortestPaths;

import java.util.*;

public class DFS {
    //използва се рекурсията при DFS
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {

        graph.putIfAbsent(1, new ArrayList<>());
        graph.putIfAbsent(6, new ArrayList<>());
        graph.putIfAbsent(7, new ArrayList<>());
        graph.putIfAbsent(12, new ArrayList<>());
        graph.putIfAbsent(14, new ArrayList<>());
        graph.putIfAbsent(19, new ArrayList<>());
        graph.putIfAbsent(21, new ArrayList<>());
        graph.putIfAbsent(23, new ArrayList<>());
        graph.putIfAbsent(31, new ArrayList<>());

        graph.put(1, List.of(19, 21, 14));
        graph.put(7, List.of(1));
        graph.put(14, List.of(23, 6));
        graph.put(19, List.of(7, 12, 31, 21));
        graph.put(21, List.of(14));
        graph.put(23, List.of(21));
        graph.put(31, List.of(21));


//обхождаме всички върхове, защото може да имаме
// несвързани части в графа и иначе ще ги пропуснем
        for (var node : graph.keySet()) {
            dfs(node);
        }
    }

    private static void dfs(Integer node) {
        if (visited.contains(node)) {
            //ако вече сме посетили този връх, го пропускаме
            return;
        }

        visited.add(node);//ако не ме били в този връх,
        // маркираме си го за посетен
        for (var child : graph.get(node)) {
            //и правим рекурсивно за децата му dfs
            dfs(child);
        }
        System.out.print(node + " "); //второ дъно, печатаме най-дълбоко потъналия елемент
    }
}
