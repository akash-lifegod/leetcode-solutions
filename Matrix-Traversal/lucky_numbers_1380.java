class Solution {
    public List<Integer> luckyNumbers(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        var ls = new ArrayList<Integer>();
        var min = new ArrayList<Integer>();
        var max = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int mini = Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                mini = Math.min(mini, mat[i][j]);
            }
            min.add(mini);
        }

        for(int i=0;i<m;i++){
            int maxi = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                maxi = Math.max(maxi, mat[j][i]);
            }
            max.add(maxi);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min.get(i).equals(max.get(j))) {
                    ls.add(max.get(j));
                }
            }
        }
        
        return ls;
    }

}