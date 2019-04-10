class Solution {
    public int[] constructArray(int n, int k) {
        k -= 1;
        int num = 1;
        int[] arr = new int[n];
        int max = n;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num++;
            if (k > 1) {
                arr[++i] = max--;
                k -= 2;
            }
        }
        
        if (k == 1) {
            int temp = arr[arr.length - 1];
            arr[arr.length - 1] = arr[arr.length - 2];
            arr[arr.length - 2] = temp;
        }
        
        return arr;
    }
}
