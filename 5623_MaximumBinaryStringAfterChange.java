class Solution {
    public String maximumBinaryString(String binary) {
        char[] arr = binary.toCharArray();
        int firstIndex = -1;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') continue;
            if (firstIndex == -1) {
                firstIndex = i;
            }
            counter++;
            arr[i] = '1';
        }
        if (counter < 2)
            return binary;
        
        arr[firstIndex + counter - 1] = '0';
        return String.valueOf(arr);
    }
}
