package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> combination = combinationSum(new Integer[]{1, 2, 3, 4, 5}, 10);
        //new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}))
        combination.stream().forEach(integers -> {
            System.out.print("(");
            integers.stream().forEach(integer -> {
                System.out.print(integer.toString() + " ");
            });
            System.out.println(")");
        });
    }

    public static List<List<Integer>> combinationSum(Integer[] candidates, Integer target) {
        Arrays.sort(candidates);
        int sum = 0;
        int index = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> temp = new LinkedList<Integer>();

        backtrack(result, temp, sum, index, target, candidates);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, Integer sum, Integer index, Integer target, Integer[] candidates) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            backtrack(result, temp, sum + candidates[i], i + 1, target, candidates);
            temp.removeLast();
        }

    }
}