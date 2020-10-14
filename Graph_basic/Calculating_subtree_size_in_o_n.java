package Graph_basic;
import java.util.*;
import java.io.*;

public class Calculating_subtree_size_in_o_n {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int subTree[];
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			subTree=new int[n + 1];
			for (int i = 0; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			Arrays.fill(subTree, 1);
			dfs(1);
			for(int i=1; i<=n; i++) System.out.print(subTree[i]+" ");
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
	static int dfs(int v) {
		vis[v] = true;
		int curr_size=1;// when we are visiting the node
//		current size would be always 1.
		for (int x : adj[v]) {
			if(!vis[x]) {
				curr_size+=dfs(x);
			}
		}
		subTree[v]=curr_size;
		return curr_size;
	}

}
