import java.util.*;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freqB = new HashMap<>();
        for (int num : b) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }
        for (int num : a) {
            if (freqB.containsKey(num) && freqB.get(num) > 0) {
                ans.add(num);
                freqB.put(num, freqB.get(num) - 1);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
