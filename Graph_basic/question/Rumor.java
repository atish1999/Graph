package Graph_basic.question;
import java.util.*;
import java.io.*;
public class Rumor {

//	the problem is to calculate the sum of minimum values in every connected component.
	static List<Integer> adj[];
	static boolean vis[];
	static int gold[],min=Integer.MAX_VALUE;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
		adj=new ArrayList[n+1];vis=new boolean[n+1];
		for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
		gold=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) gold[i]=Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		long ans=0;
		for(int i=1; i<=n; i++) {
			if(!vis[i]) {
				min=Integer.MAX_VALUE;
				ans+=dfs(i);
			}
		}
		System.out.println(ans);
	}
	static int  dfs(int v) {
		vis[v]=true;
		min=Math.min(min, gold[v]);
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x);
		}
		return min;
	}

}
