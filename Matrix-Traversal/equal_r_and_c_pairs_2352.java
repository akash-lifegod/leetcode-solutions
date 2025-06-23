class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans =0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            int vv= rowhash(grid[i]);
            map.put(vv, map.getOrDefault(vv, 0)+1);
        }

        for (int i=0; i<n; i++) {
            int vv= colhash(grid, i);
            ans+= map.getOrDefault(vv,0);
        }
        return ans;
    }

     public int rowhash(int[] row){
        int dow=0;
        for (int i=0; i< row.length; i++){
            dow = row[i] + dow *5;
        }
        return dow;
    }

    public int colhash(int [][]grid, int col){
        int dow=0;
        for (int i=0; i<grid.length; i++){
            dow = grid[i][col] +dow *5;
        }
        return dow;
    }
}