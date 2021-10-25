package com.taller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class JavaChallenge {

    private static List<int[]> getAllCombinations(int[] arr) {
        List<int[]> combinations = new ArrayList();

        for (int i = 0; i < arr.length-2; i++)
            for (int j = i+1; j < arr.length-1; j++)
                for (int k = j+1; k < arr.length; k++)
                    for (int l = k+1; l < arr.length; l++)
                        combinations.add(new int[]{ arr[i], arr[j], arr[k], arr[l] });

        return combinations;
    }

    public static List<int[]> findAllQuadruplets(Integer targetSum, int[] array) {
        List<int[]> resultList = new ArrayList();
        if (array.length < 4) {
            return resultList;
        }

        List<int[]> combinations = getAllCombinations(array);
        combinations.stream().forEach(combination -> {
            if (IntStream.of(combination).sum() == targetSum.intValue()) {
                resultList.add(combination);
            }
        });

        return resultList;
    }

    private static void test(String title, Integer targetSum, int[] array) {
        out.println();
        out.println(title);
        out.println("Input: { array: " + Arrays.toString(array) + ", targetSum: " + targetSum + " }");
        List<int[]> allQuadruplets = findAllQuadruplets(targetSum, array);
        out.print("Output: [");
        for (int pos = 0; pos < allQuadruplets.size(); pos++) {
            out.print(" "+ Arrays.toString(allQuadruplets.get(pos)));
            if (pos != allQuadruplets.size()-1) out.print(", ");
        }
        out.println(" ]");
    }

    public static void main(String[] args) {
        out.println("####################");
        out.println("## Java-Challenge ##");
        out.println("####################");

        test("Test Case 1", 16, new int[] { 7, 6, 4, -1, 1, 2 });
        test("Test Case 2", 10, new int[] { 1, 2, 3, 4, 5, 6, 7 });
        test("Test Case 3", 0, new int[] { 5, -5, -2, 2, 3, -3 });
        test("Test Case 4", 4, new int[] { -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        test("Test Case 5", 30, new int[] { -1, 22, 18, 4, 7, 11, 2, -5, -3 });
        test("Test Case 6", 20, new int[] { -10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5 });
        test("Test Case 7", 100, new int[] { 1, 2, 3, 4, 5 });
        test("Test Case 8", 5, new int[] { 1, 2, 3, 4, 5, -5, 6, -6 });

    }

}
