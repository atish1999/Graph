package dsu.questions;
import java.util.*;
import java.io.*;

public class Teachers_dilemma implements Runnable {

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
		new Thread(null, new Teachers_dilemma(), "Main", 1 << 26).start();
	}

	static int parent(int a) {// it will be returning parent of a
//		using path compression(iterative way)
		List<Integer> al=new ArrayList<>();
		while(par[a]>0) {
			al.add(a);
			a=par[a];
		}
		for(int i: al) par[i]=a;
		return a;
	}
	static int find(int a) {// it will be returning parent of a
//		using path compression(recursive way)
		if(par[a]<0) return a;
		return par[a]=find(par[a]);
	}
	static void union(int a, int b) {// it will be merging two sets A and B
		par[a]+=par[b];
		par[b]=a;
//		System.out.println(par[a]+" "+par[b]);
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			par = new int[n + 1];
			Arrays.fill(par, -1);
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				int a=parent(u),b=parent(v);
				if(a!=b) {
					union(a,b);
				}
				
			}
			long ans=1;
			for(int i=1; i<=n; i++) {
//				System.out.print(par[i]+" ");
				if(par[i]<0) {
					ans*=Math.abs(par[i]);
					ans%=mod;
				}
			}
			System.out.println(ans);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

}
