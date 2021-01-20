package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Feasible_reaction {

	static int mod = (int) (1e6 + 1);
	static List<Integer> adj[];
	static boolean vis[];
	static int cur__cc;
	static int cc[];
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			for(int i=1; i<=n; i++) {
				adj[i] = new ArrayList<>();
			}
			vis = new boolean[n + 1];
			cc =new int[n + 1];
			List<Pair<Integer,Integer>> ne=new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				String op=st.nextToken();
				int v = Integer.parseInt(st.nextToken());
				if(op.equals("=")){
					adj[u].add(v);
					adj[v].add(u);
				}else {
					ne.add(new Pair<Integer, Integer>(u,v));
				}
			}
			cur__cc=0;
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					++cur__cc;
					dfs(i);
				}
			}
			boolean ok=true;
			for(int i=0; i<ne.size(); i++) {
				int first=ne.get(i).x;
				int second=ne.get(i).y;
//			if both first and second belong to same connected component
//			them there will be contradiction i.e. answer will not be possible
//			because they can't lay under same connected components
				if(cc[first]==cc[second]) {
					ok=false;
					break;
				}
			}
			System.out.println(ok?"YES":"NO");
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void dfs(int v) {
		vis[v] = true;
		cc[v]=cur__cc;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}
	static class Pair<X,Y>{
		X x;
		Y y;
		public Pair(X x, Y y){
			this.x=x;
			this.y=y;
		}
		
	}

}
