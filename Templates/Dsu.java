package Templates;
import java.util.*;
import java.io.*;

public class Dsu implements Runnable {

	/*
		In dsu we generally denote a particular set with its parents.ie. an element of the
		set will be an unique identifier of that particular set.
	*/
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
	static int par[],Rank[];

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Dsu(), "Main", 1 << 26).start();
	}

	static int parent(int a) {// it will be returning parent of a
		if(par[a]<0) return a;
		return par[a]=parent(par[a]);
	}

	static void union(int a, int b) {// by using union by rank
//		Here a and b are Parent of (a) and parent of (b)
		if(Rank[a]>Rank[b]) {
			//a would be the parent
			par[b]=a;
			Rank[a]+=Rank[b];// and rank of a will be updated
//			i.e. rank of new parent will be updated
		}else {
			// b would be the parent
			par[a]=b;
			Rank[b]+=Rank[a];// and rank of b will be updated
//			i.e. rank of new parent will be updated
		}
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		boolean testcase = true;
		int t = testcase ? fr.nextInt() : 1;
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			par = new int[n + 1];
			Rank=new int[n + 1];
			Arrays.fill(par, -1);
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				if(par[u]!=par[v]) union(par[u],par[v]);
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

}

