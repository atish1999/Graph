package Graph_basic;
import java.util.*;
import java.io.*;
public class Bishu_and_his_gf_sssp_hack_earth {

	static List<Integer> adj[];
	static int dis[];
	static boolean vis[];
	public static void main(String[] args)  throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		adj=new ArrayList[n+1];vis=new boolean[n+1];dis=new int[n+1];
		for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
//		we have applied  dfs here on root node....i.e. 1
		dfs(1,0);
		int q=Integer.parseInt(br.readLine());
		int ans=Integer.MAX_VALUE,min=Integer.MAX_VALUE;
		while(q-->0) {
			int x=Integer.parseInt(br.readLine());
			if(dis[x]<min) {
				min=dis[x];
				ans=x;
			}else if(dis[x]==min) {
				ans=Math.min(ans, x);
			}
		}
		System.out.println(ans);

	}
	static void dfs(int v, int d) {
		vis[v]=true;
		dis[v]=d;
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x, dis[v]+1);
		}
	}
}
/*
tese case-1
15
10 15
13 14
8 9
5 8
6 11
5 10
7 13
12 7
2 5
6 3
4 7
1 3
2 1
1 4
6
8
9
10
15
14
12
ans-8
*/
