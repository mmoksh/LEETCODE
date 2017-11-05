class Solution {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<HashSet<String>> emails = new ArrayList<>();
        HashSet<String> foundEmails = new HashSet<>();
        
        String name;
        String tempEmail;
        
        for (List<String> account : accounts) {
            name = account.get(0);
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                tempEmail = account.get(i);
                hashSet.add(tempEmail);
                if (foundEmails.contains(tempEmail)) {
                    for (int j = 0; j < emails.size(); j++) {
                        if (emails.get(j).contains(tempEmail)) {
                            hashSet.addAll(emails.get(j));
                            emails.remove(j);
                            names.remove(j);
                            break;
                        }
                    }
                } else {
                    foundEmails.add(tempEmail);
                }
            }
            names.add(name);
            emails.add(hashSet);
        }
        
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            ret.add(new ArrayList<>());
            ret.get(i).add(names.get(i));
            String[] arr = new String[emails.get(i).size()];
            emails.get(i).toArray(arr);
            Arrays.sort(arr);
            ret.get(i).addAll(Arrays.asList(arr));
        }
        return ret;
    }
}
