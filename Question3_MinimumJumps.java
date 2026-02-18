class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 0 || arr[0] == 0) return -1;
        if (n == 1) return 0;

        int jumps = 0;
        int maxReach = arr[0];
        int step = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps + 1;

            maxReach = Math.max(maxReach, i + arr[i]);
            step--;

            if (step == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                step = maxReach - i;
            }
        }

        return -1;
    }
}
