package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Cosmic_Temple_distance_codechef {
// calculate sum of all distances from a node to remaining (n-1) nodes.
	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int dis[];
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =1;
		while (t-- > 0) {
			int n=Integer.parseInt(br.readLine());
			adj=new ArrayList[n+1];
			for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
			vis=new boolean[n];dis=new int[n];
			for(int i=0; i<n-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken()),
				v=Integer.parseInt(st.nextToken());
				addEdge(u,v);
			}
			long sum;
			for(int i=0; i<n; i++) {
				Arrays.fill(vis, false);
				Arrays.fill(dis, 0);
				dfs(i,0);
				sum=0;
				for(int j=0; j<n; j++) {
					sum+=dis[j];
				}
				System.out.print(sum+" ");
			}
		}
	}
	static void addEdge(int v, int u) {
		adj[u].add(v);adj[v].add(u);
	}
	static void dfs(int v, int d) {
		vis[v]=true;
		dis[v]=d;
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x, dis[v]+1);
		}
	}
}