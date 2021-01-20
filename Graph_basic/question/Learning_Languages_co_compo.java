package Graph_basic.question;
import java.util.*;
import java.io.*;
public class Learning_Languages_co_compo {
//  this question basically deals that how many minimum edges are needed to connect all  
//	the connected components
	static int n=101,m=101;
	static List<Integer> adj[]=new ArrayList[n+m];
	public static void main(String[] args) throws java.lang.Exception
	{
			long startTime = System.nanoTime();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s = new StringTokenizer(br.readLine());
			n=Integer.parseInt(s.nextToken());m=Integer.parseInt(s.nextToken());
			for(int i=1; i<=(n+m); i++) adj[i]=new ArrayList<>();
			boolean vis[]=new boolean[n+m+1];
			int y=0;
			for(int i=1; i<=n; i++) {
				 s = new StringTokenizer(br.readLine());
				 int de=Integer.parseInt(s.nextToken());y+=de;
				 while(de-->0) {
					 int u=Integer.parseInt(s.nextToken());
					 adj[i].add(u+n);
					 adj[u+n].add(i);
				 }
			}
			if(y==0) System.out.println(n);
			else {
				int c=0;
				for(int i=1; i<=n; i++) {
					if(!vis[i]) {
						++c;
						dfs(i, vis);
					}
				}		
//		to connect c number of connected components we need (c-1) edges.
				System.out.println(c-1);
			}
			long endTime = System.nanoTime();
//	        System.out.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
//	        System.exit(0);

	}
	static void dfs(int v, boolean []b) {
		b[v]=true;
		for(int x: adj[v]) {
			if(!b[x]) dfs(x, b);
		}
	}
}
