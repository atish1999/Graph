package Graph_basic.question;
import java.util.*;
import java.io.*;
public class BUGLIFE_A_Bugs_Life_SPOJ_BPT {

	static List<Integer> adj[];
	static boolean vis[];
	static int color[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		outer:
		for(int i=1; i<=t; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
		    int n=Integer.parseInt(s.nextToken()),e=Integer.parseInt(s.nextToken());
		    adj=new ArrayList[n+1];vis=new boolean[n+1];color=new int[n+1];
		    for(int j=1; j<=n; j++) adj[j]=new ArrayList<>();
		    for(int j=0; j<e; j++) {
		    	s = new StringTokenizer(br.readLine());
		    	int u=Integer.parseInt(s.nextToken()),v=Integer.parseInt(s.nextToken());
		    	adj[u].add(v);
		    	adj[v].add(u);
		    }
		    for(int j=1; j<=n; j++) {
		    	if(!vis[j]) {
		    		if(!dfs(j,1)) {
		    			System.out.println("Scenario #"+i+":\n"+"Suspicious bugs found!");
		    			continue outer;
		    		}
		    	}
		    }
		    System.out.println("Scenario #"+i+":\n"+"No suspicious bugs found!");
		}
	}
	static boolean dfs(int v, int c) {
		vis[v]=true;
		color[v]=c;
		for(int child: adj[v]) {
			if(!vis[child] && (!dfs(child,c^1))) {
				 return false;
			}else {
				if(color[v]==color[child]) return false;
			}
		}
		return true;
	}

}
