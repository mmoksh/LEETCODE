class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        ArrayList<int[]> regions = new ArrayList<>();
        int s, e, l, r;
        
        int height, maxHeight;
        int globalHeight = 0;
        
        for (int[] position : positions) {
            maxHeight = 0;
            l = position[0];
            r = position[0] + position[1];
            for (int i = 0; i < regions.size(); i++) {
                s = regions.get(i)[0];
                e = regions.get(i)[1];
                height = regions.get(i)[2];

                if (r <= s || l >= e) {
                    continue;
                }
                maxHeight = Math.max(maxHeight, height);
                
            }
            regions.add(new int[]{l, r, maxHeight + r - l});
            globalHeight = Math.max(globalHeight, maxHeight + r - l);
            ret.add(globalHeight);
        }
        return ret;
    }
}
