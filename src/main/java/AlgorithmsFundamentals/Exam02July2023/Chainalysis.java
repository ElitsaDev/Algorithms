package AlgorithmsFundamentals.Exam02July2023;
// 80/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chainalysis {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<String[]> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] transactionInfo = reader.readLine().split(" ");
            transactions.add(transactionInfo);
        }

        int result = countGroups(transactions);
        System.out.println(result);
    }

    private static int countGroups(List<String[]> transactions) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String[] transaction : transactions) {
            String sender = transaction[0];
            String receiver = transaction[1];

            graph.putIfAbsent(sender, new ArrayList<>());
            graph.putIfAbsent(receiver, new ArrayList<>());

            graph.get(sender).add(receiver);

        }

        Set<String> visited = new HashSet<>();
        int groupCount = 0;

        for (String address : graph.keySet()) {
            if (!visited.contains(address)) {
                Stack<String> stack = new Stack<>();
                stack.push(address);

                while (!stack.isEmpty()) {
                    String currentAddress = stack.pop();

                    if (!visited.contains(currentAddress)) {
                        visited.add(currentAddress);
                        stack.addAll(graph.get(currentAddress));
                    }
                }

                groupCount++;
            }
        }

        return groupCount;
    }
}
