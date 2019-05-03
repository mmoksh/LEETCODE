class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int num: A) total += num;
        if (total % 3 != 0) return false;
        int third = total / 3;
        int sum = 0;
        int parts = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == third) {
                sum = 0;
                parts++;
            }
        }
        return parts == 3;
    }
}
