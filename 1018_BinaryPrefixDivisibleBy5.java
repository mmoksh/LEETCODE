class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        int total = 0;
        for (int num: A) {
            total = total * 2 + num;
            result.add(total % 5 == 0);
            total %= 5;
        }
        return result;
    }
}
