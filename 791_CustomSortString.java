class Solution {
    public static String customSortString(String S, String T) {
        int[] indices = new int[26];
        Arrays.fill(indices, 1000);
        for (int i = 0; i < S.length(); i++) {
            indices[S.charAt(i) - 'a'] = i;
        }
        char[] arr = T.toCharArray();
        Character[] arr2 = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2, (Character a, Character b) -> {
            return indices[a - 'a'] - indices[b - 'a'];
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }
        
        return String.valueOf(arr);
    }
}
