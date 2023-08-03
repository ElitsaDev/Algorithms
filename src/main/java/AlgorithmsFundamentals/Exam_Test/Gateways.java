package AlgorithmsFundamentals.Exam_Test;
//100/100

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gateways {
    public static boolean[] visited;
    public static int[] previousNodes;
    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(edge[0]).add(edge[1]);
        }

        int source = Integer.parseInt(reader.readLine().trim());
        int destination = Integer.parseInt(reader.readLine().trim());

        visited = new boolean[nodes + 1];
        previousNodes = new int[nodes + 1];

        Arrays.fill(previousNodes,-1);

        bfs(source, destination);

        List<Integer> path = new ArrayList<>();
        path.add(destination);

        int prevNode = previousNodes[destination];

        while (prevNode != -1){
            path.add(prevNode);
            prevNode = previousNodes[prevNode];
        }

        if (path.size() == 1) {
            return;
        }
       // System.out.println("Shortest path length is: " + (path.size() - 1));
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination){
                break;
            }
            for (int child:graph.get(node)) {
                if(!visited[child]){
                    visited[child] = true;
                    previousNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }
}
