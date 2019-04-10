class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int i = 0, j = flowerbed.length - 1;
        while (i < flowerbed.length && flowerbed[i] == 0) i++;
        if (i == flowerbed.length) {
            return n <= (i + 1) / 2;
        }
        n -= i / 2;
        if (n <= 0) return true;
        while (j > i && flowerbed[j] == 0) j--;
        n -= (flowerbed.length - j - 1) / 2;
        if (n <= 0) return true;
        int counter = 0;
        for (; i <= j; i++) {
            if (flowerbed[i] == 0) {
                counter++;
            } else {
                n -= (counter - 1) / 2;
                if (n <= 0) return true;
                counter = 0;
            }
        }
        n -= (counter - 1) / 2;
        if (n <= 0) return true;
        return false;
    }
}
