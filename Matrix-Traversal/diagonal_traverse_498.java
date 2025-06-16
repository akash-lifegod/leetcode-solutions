class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n*m];

        int i = 0, j=0;
        int dir = 1;
        int idx = 0;

        while(i<n && j<m){
            if(dir == 1){
                dir = 0;
                while(i>=0 && j<m){
                    arr[idx++] = mat[i][j];
                    i--;
                    j++;
                }
                i++;
                j--;
                
                if(j == m-1) i+=1;
                else j+=1;
            } else {
                dir = 1;
                while(j>=0 && i<n){
                    arr[idx++] = mat[i][j];
                    i++;
                    j--;
                }
                j++;
                i--;

                if(i==n-1) j+=1;
                else i += 1;
            }
        }
        return arr;
    }
}