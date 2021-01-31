class Solution {
    public static int countBalls(int lowLimit, int highLimit) {
        int[] hist = new int[100];
        int temp, sum;
        for (int i = lowLimit; i <= highLimit; i++) {
            temp = i;
            sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            hist[sum]++;
        }
        int maxI = 0;
        for (int i = 1; i < hist.length; i++) {
            if (hist[i] > hist[maxI]) maxI = i;
        }
        return hist[maxI];
    }
}
