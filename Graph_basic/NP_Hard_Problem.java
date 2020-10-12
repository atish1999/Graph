package Graph_basic;
import java.util.*;
import java.io.*;
public class NP_Hard_Problem {
	
	static List<Integer> adj[];
	static boolean vis[];
	static int col[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
		adj=new ArrayList[n+1];vis=new boolean[n+1];col=new int[n+1];
		for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i=1; i<=n; i++) {
			if(col[i]==0 && adj[i].size()!=0) {
				if(!dfs(i,2)) {
					System.out.println(-1);
					return;
				}
			}
		}
		for(int e: col) System.out.print(e+" ");
		System.out.println();
		int w=0,p=0;
		StringBuilder a=new StringBuilder(" "),b=new StringBuilder(" ");
		for(int i=1; i<=n; i++) {
			if(col[i]==1) {
				++w;
				a.append(i+" ");
			}else if(col[i]==2) {
				++p;
				b.append(i+" ");
			}
			
		}
		System.out.println(w);
		System.out.println(a.toString().trim());
		System.out.println(p);
		System.out.println(b.toString().trim());
		
	}
	static boolean dfs(int v, int c) {
		vis[v]=true;
		col[v]=c;
		for(int x: adj[v]) {
			if(!vis[x]) {
				if(!dfs(x, 3-c)) return false;
			}else {
				if(col[v]==col[x]) return false;
			}
		}	
		return true;
	}
	
}
