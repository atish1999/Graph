package Graph_basic;
import java.io.*;
import java.util.*;
public class Adjacency_Matrix {

	public static void main(String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int nodes=Integer.parseInt(s.nextToken()),edges=Integer.parseInt(s.nextToken());
		int adj[][]=new int[nodes+1][nodes+1];int deg[]=new int[nodes+1];
		for(int i=0; i<edges; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
			adj[u][v]=1;
			adj[v][u]=1;
			++deg[u];++deg[v];
		}
		
	}

}
