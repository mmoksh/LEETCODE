class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        ArrayList<int[]> regions = new ArrayList<>();
        int s, e, l, r;
        
        int height, maxHeight;
        int globalHeight = 0;
        
        for (int j = 0; j < positions.length; j++) {
            maxHeight = 0;
            l = positions[j][0];
            r = positions[j][0] + positions[j][1];
            for (int i = 0; i < regions.size(); i++) {
                s = regions.get(i)[0];
                e = regions.get(i)[1];
                height = regions.get(i)[2];

                if (r <= s || l >= e) {
                    continue;
                } else if (l <= s && r < e) {
                    regions.get(i)[0] = r;
                    maxHeight = Math.max(maxHeight, height);
                } else if (l > s && r >= e) {
                    regions.get(i)[1] = l;
                    maxHeight = Math.max(maxHeight, height);
                } else if (l <= s && r >= e) {
                    maxHeight = Math.max(maxHeight, height);
                    regions.remove(i--);
                } else {
                    maxHeight = Math.max(maxHeight, height);
                    regions.add(new int[]{r, e, height});
                    regions.get(i)[1] = l;
                }
            }
            regions.add(new int[]{l, r, maxHeight + r - l});
            globalHeight = Math.max(globalHeight, maxHeight + r - l);
            ret.add(globalHeight);
        }
        return ret;
    }
}
