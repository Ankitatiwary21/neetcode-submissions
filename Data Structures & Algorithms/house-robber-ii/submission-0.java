class Solution {

    // Solves House Robber I for the range l to r
    int solve(int[] nums, int l, int r) {
        int prevPrev = 0;
        int prev = 0;

        for (int i = l; i <= r; i++) {
            int skip = prev;
            int take = nums[i] + prevPrev;

            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int takeFirstHouse = solve(nums, 0, n - 2);
        int skipFirstHouse = solve(nums, 1, n - 1);

        return Math.max(takeFirstHouse, skipFirstHouse);
    }
}