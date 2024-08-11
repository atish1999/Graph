package Graph_basic.concept;
import java.util.*;
import java.io.*;
public class Adjacency_List {

	public static void main(String[] args)  throws java.lang.Exception
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
		// adj[i].size is the degree of the ith node.(and it is equal to the value of deg[i])
//		for(int i=0; i<nodes+1; i++) System.out.println(i+"->"+adj[i].size());
		for(int i=0; i<nodes+1; i++) System.out.println(i+"->"+adj[i]);
	}

}
