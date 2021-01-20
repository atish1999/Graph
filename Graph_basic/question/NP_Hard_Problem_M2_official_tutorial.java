package Graph_basic.question;
import java.util.*;
import java.io.*;
public class NP_Hard_Problem_M2_official_tutorial {

	static List<Integer> []adj,res;
	static int col[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
		adj=new ArrayList[n+1];res=new ArrayList[2];
		for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<2; i++) res[i]=new ArrayList<>();
		col=new int[n+1];
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
		for(int i=0; i<2; i++) {
			System.out.println(res[i].size());
			for(int x: res[i]) System.out.print(x+" ");
			System.out.println();
		}
	}
	static boolean dfs(int v, int c) {
		col[v]=c;
		res[c-1].add(v);
		for(int x: adj[v]) {
			if(col[x]==0 && !dfs(x,3-c)) return false;
			if(col[x]==c) return false;
//			if(col[x]!=(3-c)) return true;
//			because col[x]!=3-c equals col[x]==c means parent and child have same color..
		}
		return true;
	}
}
