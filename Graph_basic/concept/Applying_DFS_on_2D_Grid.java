package Graph_basic.concept;
import java.util.*;
import java.io.*;
// this is just basic implementation
public class Applying_DFS_on_2D_Grid {
//  cells will be considered as node
//	here we are considering sharing sides of cells as edges.
	static int mod = (int) (1e9 + 7),n,m;
	static boolean vis[][];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,-1,-0,1};
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			vis = new boolean[n][m];
			System.out.println("Choose starting co-ordinates: ");
			st = new StringTokenizer(br.readLine());
			int sx=Integer.parseInt(st.nextToken()),sy=Integer.parseInt(st.nextToken());;
			dfs(sx,sy);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
// this function tells us whether we can visit the particular vis[x][y] cell or not..
	static boolean is_Valid(int x, int y) {
		
//		if(x<0 || x>(n-1) || y<0 || y>(m-1)) return false;
//		if(vis[x][y]) return false;
//		return true;
		return x>=0 && x<n && y>=0 && y<n && !vis[x][y];
	}
	static void dfs(int x, int y) {
		vis[x][y]=true;
		System.out.println((x+1)+" "+(y+1));
//		these co-ordinates are according to matrix
//		if(is_Valid(x+1,y)) { // down
//			dfs(x+1,y);
//		}
//		if(is_Valid(x-1,y)) { // up
//			dfs(x-1,y);
//		}
//		if(is_Valid(x,y+1)) { // right
//			dfs(x,y+1);
//		}
//		if(is_Valid(x,y-1)) { // left
//			dfs(x,y-1);
//		}
//  so basically we are visiting each cell and tries to figure out whether we
//	we are able to visit or not
		for(int i=0; i<4; i++) {
			int x1=x+dx[i],y1=y+dy[i];
			if(is_Valid(x1,y1)) dfs(x1,y1);
		}
	}

}