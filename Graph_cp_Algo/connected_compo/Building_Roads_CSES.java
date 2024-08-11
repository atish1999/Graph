package Graph_cp_Algo.connected_compo;
import java.util.*;
import java.io.*;

public class Building_Roads_CSES {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
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
			List<Integer> l=new ArrayList<>();
			long c=0;
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					++c;
					l.add(i);
					dfs(i);
				}
			}
			System.out.println(c-1);
		    for(int i=0; i<l.size()-1; i++) {
				System.out.println(l.get(i)+" "+l.get(i+1));
			}
		}
	}

	static void dfs(int v) {
		vis[v] = true;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}

}
