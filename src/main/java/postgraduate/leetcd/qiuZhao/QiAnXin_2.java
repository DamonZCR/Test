package postgraduate.leetcd.qiuZhao;

import java.util.*;

/**奇安信-20220915
 * 在一个100*100的方格中，给一组坐标，找到通过走格线上，路过所有坐标的最小步数，
 * 刚开始从远点出发；
 *
 * 通过率　：　０
 */
public class QiAnXin_2 {
    public static void main(String[] args) {

    }
    public int minCostConnetPoints(int[][] points){
        int n = points.length;
        DisjoinSetUnion dsu = new DisjoinSetUnion(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points,i,j),i,j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge edge1, Edge edge2){
                return edge1.len - edge2.len;
            }
        });
        int ret = 0;
        int num = 1;
        for (Edge edge : edges) {
            int len = edge.len , x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)){
                ret += len;
                num++;
                if (num == n){
                    break;
                }
            }
        }
        return ret;
    }
    public int dist(int[][] points, int x,int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
class DisjoinSetUnion{
    int[] f;
    int[] rank;
    int n;

    public DisjoinSetUnion(int n) {
        this.n = n;
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }
    }
    public int find(int x){
        return f[x] == x ? x : (f[x] = find(f[x]));
    }
    public  boolean unionSet(int x, int y){
        int fx = find(x), fy = find(y);
        if (fx == fy){
            return false;
        }
        if (rank[fx] < rank[fy]){
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
}
class Edge{
    int len, x, y;
    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}