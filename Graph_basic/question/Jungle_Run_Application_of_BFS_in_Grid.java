package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Jungle_Run_Application_of_BFS_in_Grid {

	static int mod = (int) (1e9 + 7),n,m;
	static boolean vis[][];
	static char in[][];
	static int dis[][];
	static int dx[]= {-1,0,1,0},
			   dy[]= {0,-1,0,1};
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
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			in=new char[n][n];
			vis=new boolean[n][n];
			dis=new int[n][n];
			int sx=0,sy=0,ex=0,ey=0;
			for(int i=0; i<n; i++) {	
				String s=br.readLine();
				for(int j=0; j<n; j++) {
					in[i][j]=s.charAt(j*2);
					if(in[i][j]=='S') {sx=i;sy=j;}
					if(in[i][j]=='E') {ex=i;ey=j;}
				}
			}
			bfs(sx,sy);
			System.out.println(dis[ex][ey]);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
	static boolean is_Valid(int x, int y) {
		return x>=0 && x<n && y>=0 && y<n && !vis[x][y] && (in[x][y]=='P' || in[x][y]=='S' || in[x][y]=='E');
	}
	static void bfs(int x, int y) {
		Queue<Pair<Integer,Integer>> q=new LinkedList<>();
		q.add(new Pair<Integer,Integer>(x,y));
		dis[x][y]=0;
		vis[x][y]=true;
		while(!q.isEmpty()) {
			int f=q.peek().x,s=q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int x1=f+dx[i],y1=s+dy[i];
				if(is_Valid(x1,y1)) {
					q.add(new Pair<Integer,Integer>(x1,y1));
					vis[x1][y1]=true;
					dis[x1][y1]=dis[f][s]+1;
				}
			}
		}
	}

}
