package Graph_basic;
import java.util.*;
import java.io.*;

public class Diameter_of_a_Tree_concept {
// diameter = maximum distance between 2 nodes or maximum no. of edges between 2 nodes
// this 2 nodes will be the 2 end points of the tree .i.e. leaves of the tree
	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int d=0,y;//here d will be the diameter and y will be the end point of nodes
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
//		we are applying dfs here to find the one of the 2 end points.
			dfs(1,0);
			d=-1;
			Arrays.fill(vis, false);
//		here we are applying dfs on the found end point
			dfs(y,0);
//		d will be the diameter because y will be the one of the end point 
//		and we are trying to find another end point from this end point so
//		distance will be the largest.i.e. diameter
			System.out.println(d);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
//this dfs function will be giving  the farthest node from any  random node of the tree
//where dfs will be called
	static void dfs(int v,int dis) {
		vis[v] = true;
		if(dis>d) {d=dis;y=v;}//we are finding the max distance as well as the farthest
		for (int x : adj[v]) {//nodes
			if(!vis[x]) {
				dfs(x,dis+1);
			}
		}
	}

}
