package Graph_cp_Algo.DFS.Codeforces;

/*
								"जय श्री कृष्णा"
*/
import java.util.*;
import java.io.*;

public class CyclicComponentsE implements Runnable {

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

		int[] nextIntArray(int size) {
			int[] arr = new int[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextInt();
			return arr;
		}

		long[] nextLongArray(int size) {
			long[] arr = new long[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextLong();
			return arr;
		}

		double[] nextDoubleArray(int size) {
			double[] arr = new double[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextDouble();
			return arr;
		}
	}

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int deg[];
	static final FastReader fr = new FastReader();
	static final PrintWriter out = new PrintWriter(System.out, true);

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new CyclicComponentsE(), "Main", 1 << 26).start();
	}

	static int node = 0, cnt = 0;

	boolean bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		HashSet<Integer> h = new HashSet<>();
		q.add(v);
		while (!q.isEmpty()) {
			int p = q.poll();
			h.add(deg[p]);
			for (int x : adj[p]) {
				if (!vis[x]) {
					q.add(x);
					vis[x] = true;
				}
			}
		}
		return h.size() == 1 && h.contains(2);
	}

	void solve() {
		int n = fr.nextInt(), m = fr.nextInt();
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
		long res = 0;
		for (int i = 1; i <= n; i++) {
			if (!vis[i] && bfs(i))
				++res;

		}
		out.print(res + "\n");

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
