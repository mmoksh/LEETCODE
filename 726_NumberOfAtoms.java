class Solution {
    public String countOfAtoms(String str) {
        HashMap<String, Integer> map = countAtoms(str);
        String[] arr = new String[map.size()];
        map.keySet().toArray(arr);
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int count;
        for (String s : arr) {
            sb.append(s);
            count = map.get(s);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public HashMap<String, Integer> countAtoms(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                HashMap<String, Integer> temp = new HashMap<>();
                int paranthesisCount = 1;
                int j = i + 1;
                for (; j < str.length(); j++) {
                    if (str.charAt(j) == '(') {
                        paranthesisCount++;
                    } else if (str.charAt(j) == ')') {
                        paranthesisCount--;
                        if (paranthesisCount == 0) {
                            temp = countAtoms(str.substring(i + 1, j));
                            break;
                        }
                    }
                }
                int count = 0;
                for (i = j + 1; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
                    count = count * 10 + str.charAt(i) - '0';
                }
                i--;
                if (count == 0) {
                    count++;
                }
                for (String s : temp.keySet()) {
                    map.put(s, map.getOrDefault(s, 0) + temp.get(s) * count);
                }
            } else {
                String atom = String.valueOf(str.charAt(i));
                for (i++; i < str.length() && Character.isLowerCase(str.charAt(i)); i++) {
                    atom += str.charAt(i);
                }
                int count = 0;
                for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
                    count = count * 10 + str.charAt(i) - '0';
                }
                if (count == 0) {
                    count++;
                }
                map.put(atom, map.getOrDefault(atom, 0) + count);
                i--;
            }
        }
        return map;
    }
}
