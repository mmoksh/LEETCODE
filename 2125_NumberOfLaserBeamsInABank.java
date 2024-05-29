class Solution {
    public int numberOfBeams(String[] bank) {
        int base = 0, count;
        int total = 0;
        for (String row: bank) {
            count = countOnes(row);
            if (count == 0) {
                continue;
            }
            total += count * base;
            base = count;
        }
        return total;
    }

    public int countOnes(String bank) {
        int count = 0;
        for (int i = 0; i < bank.length(); i++) {
            count += bank.charAt(i) - '0';
        }
        return count;
    }
}
