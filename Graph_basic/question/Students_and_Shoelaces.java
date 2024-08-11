package Graph_basic.question;
import java.util.*;
import java.io.*;
public class Students_and_Shoelaces {

	public static void main(String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int nodes=Integer.parseInt(s.nextToken()),edges=Integer.parseInt(s.nextToken());
		@SuppressWarnings("unchecked")
		ArrayList<Integer> adj[]=new ArrayList[nodes+1];int deg[]=new int[nodes+1];
		for(int i=0; i<nodes+1; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<edges; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
			++deg[u];++deg[v];
		}
		LinkedList<Integer> q=new LinkedList<>();
		for(int i=0; i<=nodes; i++) if(deg[i]==1) {q.add(i);--deg[i];}
		int ans=0;
		while(!q.isEmpty()) {
			++ans;
			for(int x:q) {
				for(int y: adj[x]) --deg[y];
			}
			q.clear();
			for(int i=1; i<nodes+1; i++) {
				if(deg[i]==1) {q.add(i);--deg[i];}
			}
		}
		System.out.println(ans);
	}
	
}
