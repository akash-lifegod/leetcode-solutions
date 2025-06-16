import java.awt.Point;
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        var a = new ArrayList<Point>();
        var b = new ArrayList<Point>();

        for(int i=0;i<n*n;i++){
            if(img1[i/n][i%n]==1){
                a.add(new Point(i/n, i%n));
            }
            if(img2[i/n][i%n]==1){
                b.add(new Point(i/n, i%n));
            }
        }

        var map = new HashMap<Point, Integer>();
        for(var p1 : a){
            for(var p2 : b){
                var vec = new Point(p1.x - p2.x, p1.y - p2.y);
                map.put(vec, map.getOrDefault(vec, 0)+1);
            }
        }

        if(map.values().isEmpty()) return 0;
        else return Collections.max(map.values());
    }
}