package AlgorithmsFundamentals.RecursionAndBacktracking;

public class BruteForce {
    public static void main(String[] args) {
        int compexity = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    for (int l = 1; l <= 10; l++) {
                        for (int m = 1; m <= 10; m++) {
                            compexity = i*j*k*l*m;
                        }
                    }
                }
            }
        }
        System.out.println(compexity); //10^5

    }
}
