package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class LCA_optimized implements Runnable {

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

	static int mod = (int) (1e5 + 1),n,m,maxN;
	static List<Integer> adj[];
	static int lca[][],level[];
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new LCA_optimized(), "Main", 1 << 26).start();
	}

	static void dfs(int node, int parent,int d) {
		lca[node][0]=parent;
		level[node]=d;
		for (int child : adj[node]) {
			if(child!=parent) dfs(child,node,d+1);
		}
	}
	static void lca_util() {
		dfs(1,-1,0);
		for(int j=1; j<=maxN; j++) {
			for(int i=1; i<=n; i++) {
				if(lca[i][j-1]!=-1) {//means 2^(j-1)th parent exists
					int par=lca[i][j-1];
					lca[i][j]=lca[par][j-1];
				}
			}
		}
	}
	static int  lCA(int a, int b) {
		if(level[a]>level[b]) {a^=b; b^=a; a^=b;}
		int d=level[b]-level[a];
		while(d>0) {
			int i= (int)(Math.log(d) / Math.log(2));
			b=lca[b][i];
			d-=(1<<i);
		}
		if(a==b) return a;
		for(int i=maxN; i>=0; i--) {
			if(lca[a][i]!=-1 && (lca[a][i]!=lca[b][i])) {
				a=lca[a][i];
				b=lca[b][i];
			}
		}
		return lca[a][0];
	}
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			n = fr.nextInt(); m = fr.nextInt();
			adj = new ArrayList[n + 1];
			level=new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			maxN=(int)(Math.log(n)/Math.log(2));
			System.out.println(maxN);
			lca=new int[n + 1][maxN + 1];
			for(int i=1; i<=n; i++) Arrays.fill(lca[i], -1);
			lca_util();
			for(int i=1; i<=n; i++) {
				System.out.print(i+"->");
				for(int j=0; j<=maxN; j++) {
					System.out.print(lca[i][j]+" ");
				}
				System.out.println();
			}
			for(int i=1; i<=n; i++) System.out.print(level[i]+" ");
			System.out.println();
			int q=fr.nextInt();
			while(q-->0) {
				int u=fr.nextInt(),v=fr.nextInt();
				System.out.println(lCA(u,v));
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
