package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Submerge_Islands_SPOJ {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static Set<Integer> ap;
    static int in[],low[],timer;
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		    if(m==0 && n==0) break;
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			ap=new HashSet<>();
			in=new int[n + 1];low=new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			dfs(1,-1);
			System.out.println(ap.size());
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

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
