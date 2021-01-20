package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Articulation_Points {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int low[],in[],timer;
	static Set<Integer> ap;//here we will store articulation points
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
// here we have to check for root node.
	static void dfs(int v,int p) {
		vis[v] = true;
		in[v]=low[v]=timer++;
		int children=0;
		for (int x : adj[v]) {
			if(x==p) continue;
			if(vis[x]) {
				low[v]=Math.min(low[v], in[x]);
			}else {
				dfs(x,v);
				if(in[v]<=low[x] && p!=-1) ap.add(v);
				++children;
				low[v]=Math.min(low[v], low[x]);
			}
		}
		if(p==-1 && children>1) ap.add(v);
	}

}
