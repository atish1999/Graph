package Graph_basic;
import java.util.*;
import java.io.*;
//application of a diameter of a tree
public class Longest_path_in_a_tree_SPOJ {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int d=0,y;//y will be the farthest node
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			dfs(1,0);// this is for finding the 1st end point.
			Arrays.fill(vis, false);
			d=-1;
			dfs(y,0);//from here we will be calculating the maximum distance.
			System.out.println(d);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void dfs(int v, int dis) {
		vis[v] = true;
		if(dis>d) {d=dis;y=v;}
		for (int x : adj[v]) {
			if(!vis[x]) {
				dfs(x, dis+1);
			}
		}
	}

}
