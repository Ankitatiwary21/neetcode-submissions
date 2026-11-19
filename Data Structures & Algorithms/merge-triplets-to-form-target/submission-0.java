class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] good = new boolean[3];

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (t[i] == target[i]) {
                    good[i] = true;
                }
            }
        }

        return good[0] && good[1] && good[2];
    }
}