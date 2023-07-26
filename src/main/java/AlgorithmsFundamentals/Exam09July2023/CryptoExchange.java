package AlgorithmsFundamentals.Exam09July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CryptoExchange {

    public static Map<String, List<String>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        graph = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String line = reader.readLine();

            if (line.trim().equals("")) {
                continue;
            }

            String[] tradePair = line.split(" - ");
            String firstNode = tradePair[0];
            String secondNode = tradePair[1];

            if (!graph.containsKey(firstNode)) {
                graph.put(firstNode, new ArrayList<>());
            }
            if (!graph.containsKey(secondNode)) {
                graph.put(secondNode, new ArrayList<>());
            }

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }
        String [] requestTrade = reader.readLine().split(" -> ");

        String source = requestTrade[0];
        String destination = requestTrade[1];

        int numberOfSwaps = findTrade(source, destination);
        System.out.println(numberOfSwaps);
    }
    private static int findTrade(String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> assetToTrades = new HashMap<>();
        queue.offer(source);
        assetToTrades.put(source, 0);

        while (!queue.isEmpty()) {
            String currentAsset = queue.poll();
            int currentTrades = assetToTrades.get(currentAsset);

            if (currentAsset.equals(destination)) {
                return currentTrades;
            }

            for (String nextAsset : graph.get(currentAsset)) {
                if (!assetToTrades.containsKey(nextAsset)) {
                    queue.offer(nextAsset);
                    assetToTrades.put(nextAsset, currentTrades + 1);
                }
            }
        }
        return -1;
    }
}
