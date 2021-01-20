package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class Transitive_closure_of_a_Graph implements Runnable {

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
	///it just means is there any posiblity to reach the vertex j from i 
//	-->make 1 in the matrix
	///TC --> O(n*n) - DfS in loop
	static int mod = (int) (1e5 + 1),n,m;
	static List<Integer> adj[];
	static int matrix[][];
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Transitive_closure_of_a_Graph(), "Main", 1 << 26).start();
	}

	static void dfs(int v,int s, int[][] matrix) {
		matrix[v][s]=1;
		for (int x : adj[s]) {
			if(matrix[v][x]==0 )
				dfs(v,x,matrix);
			
		}
	}
	static void print(int matrix[][],int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)  System.out.print(matrix[i][j]+" ");
		}
		System.out.println();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			 n = fr.nextInt();
			 matrix=new int[n][n];
			 adj=new ArrayList[n + 1];
			 for(int i=0; i<=n; i++) adj[i]=new ArrayList<>();
			 for(int i=0; i<n; i++) {
				 for(int j=0; j<n; j++) {
					 int x=fr.nextInt();
					 if(x==1) adj[i].add(j);
				 }
			 }
			 for(int i=0; i<n; i++) {
				 dfs(i,i,matrix);
			 }
			 print(matrix,n);
			 
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}

