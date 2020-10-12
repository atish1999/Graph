package Graph_basic;
import java.util.*;
import java.io.*;

public class Templates {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];

	public static void main(String[] args) throws java.lang.Exception {
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
	}

	static void dfs(int v) {
		vis[v] = true;
		for (int x : adj[v]) {
			
		}
	}

}

