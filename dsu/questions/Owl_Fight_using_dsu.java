package dsu.questions;
import java.util.*;
import java.io.*;

public class Owl_Fight_using_dsu implements Runnable {

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
	static int par[];

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Owl_Fight_using_dsu(), "Main", 1 << 26).start();
	}

	static int parent(int a) {// it will be returning parent of a
		if(par[a]<0) return a;
		return par[a]=parent(par[a]);
	}

	static void union(int a, int b) {// it will be merging two sets A and B
		par[a]=Math.min(par[a], par[b]);
		par[b]=a;
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = 1;
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			par = new int[n + 1];
			for(int i=1; i<=n; i++) {
				par[i]=-i;
			}
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				u=parent(u);
				v=parent(v);
				if(u!=v) union(u,v);
			}
			int q=fr.nextInt();
			while(q-->0) {
				int u=fr.nextInt(),v=fr.nextInt();
				int par_a=parent(u),par_b=parent(v);
				if(par_a==par_b) {
					System.out.println("TIE");
				}else {
//	jo jada negative hoga uska magnitude jada hoga
					System.out.println(par[par_a]>par[par_b]?v:u);
				}
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

}

