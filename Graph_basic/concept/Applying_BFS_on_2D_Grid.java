package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Applying_BFS_on_2D_Grid {

	static int mod = (int) (1e9 + 7),n,m;
	static boolean vis[][];
	static int dx[]= {-1,0,1,0},
			   dy[]= {0,-1,0,1};
	static int dis[][];
	static class Pair<X,Y>{
		X x;
		Y y;
		public Pair(X x, Y y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int sx=Integer.parseInt(st.nextToken()),sy=Integer.parseInt(st.nextToken());
			vis=new boolean[n][m];
			dis=new int[n][m];
			bfs(sx,sy);
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print(dis[i][j]+" ");
				}
				System.out.println();
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
	static boolean is_Valid(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m && !vis[x][y];
	}
	static void bfs(int x, int y) {
		Queue<Pair<Integer,Integer>> q=new LinkedList<>();
		q.add(new Pair<Integer,Integer>(x,y));
		vis[x][y]=true;
		dis[x][y]=0;
		while(!q.isEmpty()) {
			int f=q.peek().x,s=q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int x1=f+dx[i], y1=s+dy[i];
				if(is_Valid(x1,y1)) {
					q.add(new Pair<Integer,Integer>(x1,y1));
					dis[x1][y1]=dis[f][s]+1;
					vis[x1][y1]=true;
				}
			}
		}
	}

}
