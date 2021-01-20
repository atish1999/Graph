package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Kosaraju_Algorithm_for_SCC {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[],tr[],order,scc;
	static boolean vis[];

	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			tr = new ArrayList[n + 1];
			order=new ArrayList<>();
			scc=new ArrayList<>();
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
				tr[i]=new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()),
					v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				tr[v].add(u);
			}
			for(int i=1; i<=n; i++) {
				if(!vis[i]) dfs(i);
			}
			System.out.println(order);
			Arrays.fill(vis, false);
			int strongly_cc=0;
			for(int i=order.size()-1; i>=0; i--) {
				int x=order.get(i);
				if(!vis[x]) {
					++strongly_cc;
					dfs1(x);
					System.out.println("dfs call will be from node "+x);
					System.out.println(scc);
					scc.clear();
				}
			}
			System.out.println("total number of strongly connected components\n->"+strongly_cc);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void dfs(int v) {// this dfs will be applied on original graph
		vis[v] = true;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
		order.add(v);
	}
	static void dfs1(int v) {//this dfs will be applied on transposed graph
		vis[v]=true;
		for(int x: tr[v]) {
			if(!vis[x]) dfs1(x);
		}
		scc.add(v);
	}
}