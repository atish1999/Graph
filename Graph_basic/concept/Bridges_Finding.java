package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Bridges_Finding {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int in[],low[];
	static int timer;
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			in=new int[n + 1];
			low=new int[n + 1];
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

	static void dfs(int v,int p) {
		vis[v] = true;
		in[v]=low[v]=timer++;
		for (int x : adj[v]) {
			if(x==p) continue;
			if(vis[x]) {
//			v to x there will be a back edge
				low[v]=Math.min(low[v],in[x]);
			}else {
//			v to x there will be a forward edge
				dfs(x,v);
				if(low[x]>in[v]) 
					System.out.println(v+" to "+x+" there is a bridge!");
				low[v]=Math.min(low[v],low[x]);
			}
		}
	}

}
