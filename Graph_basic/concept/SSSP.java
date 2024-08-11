package Graph_basic.concept;
import java.util.*;
import java.io.*;
public class SSSP { // SINGLE SOURCE SHORTEST PATH
	
//	It is applicable only on trees.not applicable on the graph which has cycles
//	we are calcultaing distance w.r.t. root node. or single source
	static List<Integer> adj[];
	static int[] dis;
	static boolean[] vis;
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(s.nextToken()),m=Integer.parseInt(s.nextToken());
		adj=new ArrayList[n+1];
		for(int i=1; i<n+1; i++) adj[i]=new ArrayList<>();
		vis=new boolean[n+1];dis=new int[n+1];
		for(int i=0; i<m; i++) {
			s = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(1,0);// we are applying dfs on root node.
		for(int i=1; i<=n; i++) {
			System.out.println("distance of node "+i+" w.r.t to root node or (node-1) is "+dis[i]);
		}
	}
	static void dfs(int v, int d) {
		vis[v]=true;
		dis[v]=d;
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x, dis[v]+1);
		}
	}
}
