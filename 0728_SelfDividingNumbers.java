class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkSelfDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }
    
    public boolean checkSelfDividing(int num) {
        int temp = num;
        int digit;
        
        while (temp > 0) {
            digit = temp % 10;
            temp /= 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
        }
        return true;
    }
}
