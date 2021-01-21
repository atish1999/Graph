package Templates;
import java.util.*;
import java.io.*;

public class Dfs implements Runnable {

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

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Dfs(), "Main", 1 << 26).start();
	}

	static void dfs(int v) {
		vis[v] = true;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		PrintWriter out=new PrintWriter(System.out, true);
		boolean testcase = true;
		int t = testcase ? fr.nextInt() : 1;
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

		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}

