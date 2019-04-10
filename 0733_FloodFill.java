class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ret = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                ret[i][j] = image[i][j];
            }
        }

        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(ret, sr, sc, newColor, image[sr][sc], visited);
        return ret;
    }
    
    public void dfs(int[][] modifiedImage, int i, int j, int newColor, int startingColor, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= modifiedImage.length || j >= modifiedImage[i].length ||
                visited[i][j] || modifiedImage[i][j] != startingColor) {
            return;
        }
        modifiedImage[i][j] = newColor;
        visited[i][j] = true;
        dfs(modifiedImage, i + 1, j, newColor, startingColor, visited);
        dfs(modifiedImage, i - 1, j, newColor, startingColor, visited);
        dfs(modifiedImage, i, j + 1, newColor, startingColor, visited);
        dfs(modifiedImage, i, j - 1, newColor, startingColor, visited);
    }
}
