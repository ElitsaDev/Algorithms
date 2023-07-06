package AlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithms;

import java.util.*;
/*
input: 15 3 134 17 0 9 8 11
output: 0 3 8 9 11 15 17 134
* */
public class BucketSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
    private static void sort(int[] arr) {
        bucketSort(arr);
    }
    private static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 0) {
            return;
        }

        int maxVal = Arrays.stream(arr).max().orElse(0);
        int numBuckets = (maxVal / 10) + 1;
        List<Queue<Integer>> buckets = createBuckets(numBuckets);

        distributeElements(arr, buckets);
        sortBuckets(buckets);
        concatenateBuckets(arr, buckets);
    }

    private static List<Queue<Integer>> createBuckets(int numBuckets) {
        List<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayDeque<>());
        }
        return buckets;
    }
    private static void distributeElements(int[] arr, List<Queue<Integer>> buckets) {
        for (int num : arr) {
            int bucketIndex = num / 10;
            buckets.get(bucketIndex).add(num);
        }
    }
    private static void sortBuckets(List<Queue<Integer>> buckets) {
        for (Queue<Integer> bucket : buckets) {
            List<Integer> tempList = new ArrayList<>(bucket);
            tempList.sort(null);
            bucket.clear();
            bucket.addAll(tempList);
        }
    }
    private static void concatenateBuckets(int[] arr, List<Queue<Integer>> buckets) {
        int index = 0;
        for (Queue<Integer> bucket : buckets) {
            while (!bucket.isEmpty()) {
                arr[index++] = bucket.poll();
            }
        }
    }
}




