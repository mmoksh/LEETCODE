class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        char [] arr = String.valueOf(N).toCharArray();
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            arr[arr.length - 1] = '9';
            arr[arr.length - 2]--;
        }
        int temp;
        for (int i = arr.length - 2; i >= 0; i--) {
            temp = i;
            if (temp < arr.length - 1 && arr[temp] > arr[temp + 1]) {
                arr[temp]--;
                do {
                    arr[++temp] = '9';
                } while (temp < arr.length - 1 && arr[temp] > arr[temp + 1]);
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}
