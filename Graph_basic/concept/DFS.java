package Graph_basic.concept;
import java.util.*;
import java.io.*;
public class DFS {

	static int n=Integer.MAX_VALUE,e,c=0;
	@SuppressWarnings("unchecked")
	static List<Integer> adj[]=new ArrayList[9];
	public static void main(String[] args)  throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
	    n=Integer.parseInt(s.nextToken());e=Integer.parseInt(s.nextToken());
		for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<e; i++) {
			s = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		boolean[] vis=new boolean[9];
/*		this is for complete graph traversal means all the nodes should be visited
		i.e. if there is any node with degree 0(i.e. an unreachable node)
		that should be also visited..
		DFS(1) means it will visit only those nodes which are connected to 1.
*/		
		for(int i=1; i<vis.length; i++) {
			if(!vis[i]) dfs(i,vis);
		}
		
	}

	static void dfs(int v,boolean[]vis) {
		vis[v]=true;
		System.out.print(v+"->");
		for(Integer x: adj[v]) {
			if(!vis[x]) dfs(x, vis);
		}
/*		for(int i=0; i<adj[v].size(); i++) {
			int child=adj[v].get(i);
			if(!vis[child]) DFS(child);
			else continue;
		}
 */
		
	}
}
