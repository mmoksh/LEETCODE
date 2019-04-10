class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length < 2) {
            List<Integer> list = new ArrayList<>();
            if (k == 1) list.add(arr[0]);
            return list;
        }
        int index = Arrays.binarySearch(arr, x);
        int i, j;
        if (index < 0) {
            i = -index - 1;
            if (i > 0 && x - arr[i - 1] <= arr[i] - x) i--;
        } else {
            i = index;
        }
        j = i;
        
        while (j - i + 1 < k) {
            if (i == 0) j++;
            else if (j == arr.length - 1) i--;
            else if (x - arr[i - 1] <= arr[j + 1] - x) i--;
            else j++;
        }
        List<Integer> list = new ArrayList<>();
        while (i <= j) {
            list.add(arr[i++]);
        }
        return list;
    }
}
