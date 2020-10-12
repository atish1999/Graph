package Graph_basic;
import java.util.*;
import java.io.*;
public class PT07Y_Is_it_a_tree_spoj {

	static List<Integer> adj[];
	static boolean vis[];
	public static void main(String[] args) throws java.lang.Exception
	{
//		we will be applying the concept of undirected graph
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(s.nextToken()),e=Integer.parseInt(s.nextToken());
	    adj=new ArrayList[n+1];vis=new boolean[n+1];
	    for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
	    for(int i=0; i<e; i++) {
	    	s = new StringTokenizer(br.readLine());
		    int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
		    adj[u].add(v);
		    adj[v].add(u);//making undirected graph
	    }
	    int compo=0;
	    for(int i=1; i<=n; i++) {
	    	if(!vis[i]) {++compo;dfs(i);}
	    }
//	    if(connected component)!=1 or total no. of edges not equal to (n-1) then that would not be tree
	    System.out.println(compo!=1 || e!=(n-1)?"NO":"YES");
	}
	static void dfs(int v) {
		vis[v]=true;
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x);
		}
	}
//	here we are solving with the help of directed graph.
	static void solve1()throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(s.nextToken()),e=Integer.parseInt(s.nextToken());
	    adj=new ArrayList[n+1];vis=new boolean[n+1];
	    for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
	    for(int i=0; i<e; i++) {
	    	s = new StringTokenizer(br.readLine());
		    int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
		    adj[u].add(v);//making directed graph with
	    }
//	    applying dfs on root node
	    if(!dfs1(1)) {
	    	System.out.println("NO");
	    	return;
	    }
	    boolean ok=true;
	    for(int i=1; i<=n; i++) {
	    	if(!vis[i] ) {ok=false;break;}
	    }
	    System.out.println(ok?"YES":"NO");
	}
	static boolean dfs1(int v) {
		vis[v]=true;
//		System.out.print(v+" ");
		for(int x: adj[v]) {
			if(!vis[x] && dfs1(x)) continue;//because we have made a directed graph..
			else return false;
		}
		return true;
	}

}
