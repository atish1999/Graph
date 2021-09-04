package Graph;
/*
								"जय श्री कृष्णा"
*/
import java.util.*;
import java.io.*;

public class Journey_C implements Runnable {

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
	static int deg[];
	static final FastReader fr = new FastReader();
	static final PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Journey_C(), "Main", 1 << 26).start();
	}
	static double ans=0;
	double dfs(int v, int p, int depth, double prob) {
		vis[v]=true;
		double ans=0;
		long div=adj[v].size();
		if(p!=-1) --div;
		for(int x: adj[v]) {
			if(!vis[x]) {
				ans+=dfs(x, v, depth+1, prob/div);
			}
		}
		if(deg[v]==1 && p!=-1) ans+=(1d)*depth*prob;
		return ans;
	}
	void solve() {
		int n = fr.nextInt(), m = n-1;
		adj = new ArrayList[n + 1];
		vis = new boolean[n + 1];
		deg = new int[n + 1];
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int u = fr.nextInt(), v = fr.nextInt();
			adj[u].add(v);
			adj[v].add(u);
			++deg[u];
			++deg[v];
		}
		
		out.printf("%.7f", dfs(1,-1,0,1));
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		boolean testcase = false;
		int t = testcase ? fr.nextInt() : 1;
		while (t-- > 0) {
			solve();
			out.print("\n");
			out.flush();
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
