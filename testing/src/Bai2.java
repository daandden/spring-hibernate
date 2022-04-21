import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai2 {

    // input one line at a time
    public static void main(String[] args) {
        String result = "";
        Scanner scanner = new Scanner(System.in);
        int judgeNum = scanner.nextInt();
        scanner.nextLine();
        int[][] candidates = new int[4][1000000];
        Arrays.stream(candidates).forEach(arr -> Arrays.fill(arr, 0));
        int count = 0;
        while (count != judgeNum) {
            String line = scanner.nextLine();
            List<Integer> nums = Arrays.stream(line.trim().split(" "))
                                       .map(Integer::parseInt)
                                       .collect(Collectors.toList());

            int score = 3;
            for (int i = 1; i < nums.size(); i++) {
                candidates[0][nums.get(i)] += score;
                candidates[4 - score][nums.get(i)]++;
                score--;
            }
            count++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1000000; i++) {
            if (max < candidates[0][i]) {
                max = candidates[0][i];
            }
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            if (max == candidates[0][i]) {
                indexes.add(i);
            }
        }

        if (indexes.size() == 1) {
            result = String.valueOf(indexes.get(0));
        } else {
            int firstRankCount = indexes.stream()
                                        .reduce(Integer.MIN_VALUE, (maxVal, index) -> maxVal < candidates[1][index] ? candidates[1][index] : maxVal);
            List<Integer> firstRankIndexes = indexes.stream()
                                                    .filter(index -> candidates[1][index] == firstRankCount)
                                                    .collect(Collectors.toList());
            if (firstRankIndexes.size() == 1) {
                result = String.valueOf(firstRankIndexes.get(0));
            } else {
                int secondRankCount = firstRankIndexes.stream()
                                                      .reduce(Integer.MIN_VALUE, (maxVal, index) -> maxVal < candidates[2][index] ? candidates[2][index] : maxVal);
                List<Integer> secondRankIndexes = firstRankIndexes.stream()
                                                                  .filter(index -> candidates[2][index] == secondRankCount)
                                                                  .collect(Collectors.toList());
                if (secondRankIndexes.size() == 1) {
                    result = String.valueOf(secondRankIndexes.get(0));
                } else {
                    result = secondRankIndexes.stream().map(String::valueOf).collect(Collectors.joining(" "));
                }
            }
        }

        System.out.println(result);
    }
}
