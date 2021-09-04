package Graph;
import java.util.*;
import java.io.*;

public class Maze_A_div1 implements Runnable {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static int mod = (int) (1e5 + 1);
	static List<Integer> adj[];
	static boolean vis[][];
	static int n,m,k;
	static  char in[][];
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Maze_A_div1(), "Main", 1 << 26).start();
	}
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,-1,0,1};
	static boolean can_place(int r, int c) {
		return r>=0 && c>=0 && r<n && c<m && !vis[r][c] && in[r][c]=='.';
	}
	static int c=0;
	static void dfs(int x, int y) {
		vis[x][y]=true;
		for(int i=0; i<4; i++) {
			int x1=x+dx[i],y1=y+dy[i];
			if(can_place(x1,y1)) {
				dfs(x1,y1);
			}
		}
		if(k>0) {
			in[x][y]='X';
			--k;
		}
		if(k==0) return;
	}

	static void print() {
		for(char a[]: in) {
			System.out.println(a);
//			for(char d: a) System.out.print(d);
//			System.out.println();
		}
	}
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		boolean testcase=false;
		int t = testcase?fr.nextInt():1;
		while (t-- > 0) {
			n = fr.nextInt();m = fr.nextInt();k=fr.nextInt();
			vis = new boolean[n][m];
			in =new char[n][m];
			
			for(int i=0; i<n; i++) {
				in[i]=fr.nextLine().toCharArray();
			}

			for(int i=0; i<n && k>0; i++) {
				 for(int j=0; j<m && k>0; j++) {
					 if(!vis[i][j] && in[i][j]=='.') dfs(i,j);
				 }
			}
			print();
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
/*
4 4 2
....
.#..
..##
..##
this is the counter case because we can not put our wall on the top left corner 
of the maze because it will block the path
ans->
....
.#..
.X##
.X##
*/
