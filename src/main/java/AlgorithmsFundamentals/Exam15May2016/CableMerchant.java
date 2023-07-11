package AlgorithmsFundamentals.Exam15May2016;
/* todo
On the first input line you are given the sequence K – the prices
for each length of cable
Length	1	2	3	4	5	6	7
Price	3	8	13	15	18	20	22

On the second line you are given
the number C – the price for a single connector
 */



import java.util.*;
import java.util.stream.Collectors;

/*
input:
3 8 13 15 18 20 22
1
output:
3 8 13 15 19 24 26
 */
public class CableMerchant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] prices = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int connectorPrice = Integer.parseInt(scanner.nextLine());

        List<Integer> bestPrices = new ArrayList<>();
        bestPrices.add(0);

        for (int i = 0; i < prices.length; i++) {
            int max = prices[i];

            for (int j = 1; j < i; j++) {
                max = Math.max(max, bestPrices.get(j) + bestPrices.get(i - j) - 2 * connectorPrice);
            }
            bestPrices.add(max);
        }
        bestPrices.remove(0);
        System.out.print(String.join(" ", bestPrices.toString()));
    }
}
