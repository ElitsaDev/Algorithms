package AlgorithmsFundamentals.ExamPreparation;
//Bottom-up approach dynamic programming
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClusterBorder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] timeAsASingleShip = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] timeForTwoShipsCombo = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] dp = new int[timeAsASingleShip.length + 1];

        dp[1] = timeAsASingleShip[0];

        for (int i = 2; i <= timeAsASingleShip.length; i++) {
          dp[i] = Math.min(dp[i - 1] + timeAsASingleShip[i - 1], dp[i - 2] + timeForTwoShipsCombo[i - 2]);
        }
        System.out.println("Optimal Time: " + dp[timeAsASingleShip.length]);

        List<String> out = new ArrayList<>();
        for (int i = dp.length - 1;  i > 0 ; i--) {
            int timeDiffForLatestTwo = dp[i] - dp[i - 1];
            if(timeDiffForLatestTwo == timeAsASingleShip [i - 1]){
                out.add("Single "+ i);
            }else {
                out.add("Pair of "+ (i - 1) +" and "+ i);
                i--;
            }
        }
        for (int i = out.size() - 1;  i >= 0 ; i--) {
            System.out.println(out.get(i));
        }
    }
}
