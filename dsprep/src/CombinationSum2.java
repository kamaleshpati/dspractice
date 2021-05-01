import java.util.*;

public class CombinationSum2 {
    public ArrayList combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates, target, current, set, 0, 0);

        return new ArrayList(set);
    }

    private void helper(int[] candidates, int target, List<Integer> current, Set<List<Integer>> set, int index, int sum) {
        if (sum > target) return;

        if (sum == target) {
            set.add(new ArrayList<Integer>(current));

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            helper(candidates, target, current, set, i + 1, sum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}
