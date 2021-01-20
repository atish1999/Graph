package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class LCA_novice implements Runnable {

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
	static boolean vis[];
	static int level[],par[];
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new LCA_novice(), "Main", 1 << 26).start();
	}

	static void dfs(int v,int p, int d) {
		vis[v] = true;
		level[v]=d;
		par[v]=p;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x, v, d+1);
		}
	}
/*
	LCA is applicable on tree or in DAG(Directed Acyclic Graph)
*/
//	Novice_Approach
	static int LCA(int a, int b) {
//		both time and space complexity is O(n).
		if(level[a]>level[b]) {a^=b;b^=a;a^=b;}
		
		int d=(level[b]-level[a]);
		
		while(d>0) {
			b=par[b];
			--d;
		}
		if(a==b) return a;
		while(par[a]!=par[b]) {
			a=par[a];
			b=par[b];
		}
		return par[a];
//		while(a!=b) {
//			a=par[a];
//			b=par[b];
//		}
//		return a;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			level=new int[n + 1];
			par=new int[n+1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			dfs(1,-1,0);
			int q=fr.nextInt();
			while(q-->0) {
				int u=fr.nextInt(),v=fr.nextInt();
				System.out.println(LCA(u,v));
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
/*
1
8 7
1 2
2 3
3 7
7 8
2 4
4 5
4 6
1
7 6
ans->2
*/

}
