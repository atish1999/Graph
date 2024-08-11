package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class Flood_fill_Algorithm implements Runnable {

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
	/*
	Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K),
	 your task is to replace color of the given pixel 
	 and all adjacent(excluding diagonally adjacent) same colored pixels 
	 with the given color K.

	Example:
	
	{{1, 1, 1, 1, 1, 1, 1, 1},
	{1, 1, 1, 1, 1, 1, 0, 0},
	{1, 0, 0, 1, 1, 0, 1, 1},
	{1, 2, 2, 2, 2, 0, 1, 0},
	{1, 1, 1, 2, 2, 0, 1, 0},
	{1, 1, 1, 2, 2, 2, 2, 0},
	{1, 1, 1, 1, 1, 2, 1, 1},
	{1, 1, 1, 1, 1, 2, 2, 1},
	 };

	 x=4, y=4, color=3 
	
	{{1, 1, 1, 1, 1, 1, 1, 1},
	{1, 1, 1, 1, 1, 1, 0, 0},
	{1, 0, 0, 1, 1, 0, 1, 1}, 
	{1, 3, 3, 3, 3, 0, 1, 0},
	{1, 1, 1, 3, 3, 0, 1, 0},
	{1, 1, 1, 3, 3, 3, 3, 0},
	{1, 1, 1, 1, 1, 3, 1, 1},
	{1, 1, 1, 1, 1, 3, 3, 1}, };
	 
	 */

	static int mod = (int) (1e5 + 1);
	static boolean vis[][];
	static int n,m,matrix[][],sx,sy,k,universal;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Flood_fill_Algorithm(), "Main", 1 << 26).start();
	}
	static boolean can_place(int x, int y) {
		return x>=0 && y>=0 && x<n && y<m && !vis[x][y] && matrix[x][y]==universal;
	}
	static int dx[]= {-1,0,1,0},dy[]= {0,-1,0,1};
	
	static void dfs(int x, int y) {
		vis[x][y]=true;
		matrix[x][y]=k;
		for(int i=0; i<4; i++) {
			if(can_place(x+dx[i],y+dy[i])) dfs(x+dx[i],y+dy[i]);
		}
	}
	static void print() {
		for(int x[]: matrix) {
			for(int e: x) System.out.print(e+" ");
		}
		System.out.println();
	}
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			n = fr.nextInt(); m = fr.nextInt();
			vis = new boolean[n][m];
			matrix=new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					matrix[i][j]=fr.nextInt();
				}
			}
			sx=fr.nextInt();sy=fr.nextInt();k=fr.nextInt();
			universal=matrix[sx][sy];
			dfs(sx,sy);
			print();
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
