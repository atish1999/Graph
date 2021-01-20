package dsu.questions;
import java.util.*;
import java.io.*;

public class Owl_Fight_using_graph implements Runnable {

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
	static List<Integer> scc;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Owl_Fight_using_graph(), "Main", 1 << 26).start();
	}

	static void dfs(int v) {
		vis[v] = true;
		max=Math.max(max, v);
		scc.add(v);
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = 1;
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			scc=new ArrayList<>();
			int cc[]=new int[n + 1];
			for(int i=1;i<=n; i++) {
				if(!vis[i]) {
					scc.clear();
					max=Integer.MIN_VALUE;
					dfs(i);
					for(int x: scc) cc[x]=max;
				}
			}
			int q=fr.nextInt();
			while(q-->0) {
				int a=fr.nextInt(),b=fr.nextInt();
				if(cc[a]==cc[b]) {
					System.out.println("TIE");
				}else {
					System.out.println(cc[a]>cc[b]?a:b);
				}
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
