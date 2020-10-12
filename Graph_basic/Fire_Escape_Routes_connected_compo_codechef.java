package Graph_basic;
import java.util.*;
import java.io.*;

public class Fire_Escape_Routes_connected_compo_codechef {

	static int mod = (int) (1e9 + 7),max=0;
	static List<Integer> adj[]; 
	static boolean vis[];
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
			adj=new ArrayList[n+1];vis=new boolean[n+1];
			for(int i=1; i<=n; i++)adj[i]=new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken()),
				v=Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			int compo=0;
			long noWays=1;
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					++compo;
					max=0;
					dfs(i);
//					using basic product rule
					noWays=(noWays*max)%mod;
				}
			}
			System.out.println(compo+" "+noWays);
		}
	}
	static void dfs(int v) {
		++max;//max represents the number of nodes..
		vis[v]=true;
		for (int x: adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}
}
