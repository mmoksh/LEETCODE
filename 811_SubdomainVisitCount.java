class Solution {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        int count, index;
        String [] arr;
        String domain;
        for (String cpdomain : cpdomains) {
            arr = cpdomain.split(" ");
            count = Integer.parseInt(arr[0]);
            domain = arr[1];
            while (true) {
                map.put(domain, map.getOrDefault(domain, 0) + count);
                index = domain.indexOf('.');
                if (index > 0) {
                    domain = domain.substring(index + 1);
                } else {
                    break;
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (String string : map.keySet()) {
            ret.add(map.get(string) + " " + string);
        }
        return ret;
    }
}
