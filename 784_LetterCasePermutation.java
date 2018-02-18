class Solution {
    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        char[] arr = S.toLowerCase().toCharArray();
        dfs(arr, 0, list);
        return list;
    }
    
    public static void dfs(char[] arr, int i, List<String> list) {
        if (i == arr.length) {
            list.add(String.valueOf(arr));
            System.out.println(String.valueOf(arr));
            return;
        }

        if (arr[i] < 'A') {
            dfs(arr, i + 1, list);
        } else {
            dfs(arr, i + 1, list);
            arr[i] = (char) (arr[i] ^ 32);
            dfs(arr, i + 1, list);
        }
    }
}
