package Graph_cp_Algo.DFS.Codeforces;
import java.util.*;
import java.io.*;

public class Linova_and_Kingdom_A_div_1 implements Runnable {

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

	static int mod = (int) (1e5 + 1),n,k;
	static List<Integer> adj[];
	static boolean vis[];
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Linova_and_Kingdom_A_div_1(), "Main", 1 << 26).start();
	}
	static int dfs(int v,int d) {// d is for claculating depth or level
		vis[v] = true;
		int c=1;// c is for calculating subtree size of node v
		for (int x : adj[v]) {
			if(!vis[x]) {
				c+=dfs(x,d+1);
			}
		}
		pq.add((d-(c-1)));
		return c;
	}

	static void sol() {
		pq=new PriorityQueue<>(Collections.reverseOrder());
		dfs(1,0);
		long sum=0;
		for(int i=0; i<k; i++) {
			sum+=pq.poll();
		}
		System.out.println(sum);
	}
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		boolean testcase=false;
		FastReader fr = new FastReader();
		int t = testcase?fr.nextInt():1;
		while (t-- > 0) {
		    n = fr.nextInt(); k= fr.nextInt();
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < (n-1); i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			sol();
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
