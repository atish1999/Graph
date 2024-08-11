package Graph_basic.concept;

import java.util.*;
import java.io.*;

public class Print_all_possible_Paths implements Runnable {

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

	static int mod = (int) (1e5 + 1), n, m, s, d, c;
	static List<Integer> adj[];
	static boolean vis[];
	static List<Integer> path;

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Print_all_possible_Paths(), "Main", 1 << 26).start();
	}

//	dfs approach
	static void dfs(int v) {
		vis[v] = true;
		if (v == d) {
			++c;
			System.out.println(path);
		} else {
			for (int x : adj[v]) {
				if (!vis[x]) {
					path.add(x);// choose the current node
					dfs(x);// exploring the node
					// this is equivalent pop_back() function of c++ vector
					path.remove(path.size() - 1);// backtracking step
				}
			}
		}
		vis[v] = false;
	}

//	bfs approach
	static boolean is_Present(int vertex, List<Integer> route) {
		return route.contains(vertex);
	}

	static void bfs(int src) {
		Queue<List<Integer>> q = new LinkedList<>();
		List<Integer> route = new ArrayList<>();
		route.add(src);
		q.add(route);
		while (!q.isEmpty()) {
			route = q.poll();
			System.out.println(route);
			int last = route.get(route.size() - 1);
			if (last == d) {
				++c;
				System.out.println(route + "->ok");
			}
			for (int x : adj[last]) {
				if (!is_Present(x, route)) {// or (!route.contains(x))
					List<Integer> newPath = new ArrayList<>(route);
//					System.out.println(newPath);
					newPath.add(x);
					q.add(newPath);
				}
			}
		}
	}

	static void print_adj() {
		for (int i = 0; i < n; i++) {
			System.out.println(i + "->" + adj[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			n = fr.nextInt();
			m = fr.nextInt();
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 0; i <= n; i++)
				adj[i] = new ArrayList<>();
			int in[] = fr.nextIntArray(2 * m);
			for (int i = 0; i < 2 * m - 1; i += 2) {
				adj[in[i]].add(in[i + 1]);
			}
			print_adj();
			s = fr.nextInt();
			d = fr.nextInt();
			c = 0;
			path = new ArrayList<>();
			path.add(s);
//			dfs(s);
//			System.out.println();
			bfs(s);
			System.out.println(c);

		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
