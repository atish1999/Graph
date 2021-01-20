package Graph_basic.question;
import java.util.*;
import java.io.*;

public class counting_rooms_cses_Connected_compo_in_2D_Grid {
// this problem is based on connected components in 2D Grid
	static int mod = (int) (1e9 + 7),n,m;
	static boolean vis[][];
	static char input_ar[][];
	static int dx[]= {0,1,0,-1},
		       dy[]= {1,0,-1,0};
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			vis=new boolean[n][m];
			input_ar=new char[n][m];
			for(int i=0; i<n; i++) {
				String s=br.readLine();
				for(int j=0; j<m; j++) {
					input_ar[i][j]=s.charAt(j);
				}
			}
			int cc=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!vis[i][j] && input_ar[i][j]=='.') {
						++cc;
						dfs(i,j);
					}
				}
			}
			System.out.println(cc);
			
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static boolean is_Valid(int x, int y) {
//		if(x<0 || x>(n-1) || y<0 || y>(n-1)) return false;
//		if(vis[x][y] || input_ar[x][y]==0) return false;
//		return true;
		return x>=0 && x<n && y>=0 && y<m && !vis[x][y] && input_ar[x][y]=='.';
	}
	static void dfs(int x, int y) {
		vis[x][y]=true;
//		int dx[]= {0,1,0,-1},
//			dy[]= {1,0,-1,0};
		for(int i=0; i<4; i++) {
			int x1=x+dx[i],y1=y+dy[i];
			if(is_Valid(x1,y1)) dfs(x1,y1);
		}
	}
}
