package Graph_basic.concept;
import java.util.*;
import java.io.*;
public class Cycle_detection {

//	cycle detection is applicable on that graph in which there is no self cyle of a
//	single node as well as there should not be multiple edges between 2 nodes. i.e.there 
//	should be exactly 1 edge between 2 nodes.
	
	static List<Integer> adj[];
	static boolean vis[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
		adj=new ArrayList[n+1];vis=new boolean[n+1];
		for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i=1; i<=n; i++) {
			System.out.println(i+"->"+adj[i]);
		}
/*
		   #case-1
			5 6
			1 2
			2 3
			1 5
			3 4
			4 2
			4 5
			ans-2

*/
	}
//	idea is to check for back edge(if present then the graph has cycle otherwise not)
//	back-edge:{
//		In the adjacency list of a node v if there is a node x which is visited earlier
//		but x is not the parent node of v i.e. v is connected with its ancestor x
//		via backedge.In this case we can say that the graph has a cycle....
//	}
	static boolean dfs(int v, int p) {//v is the node and p is the parent node of v
		vis[v]=true;
//		System.out.print(v+"->");
		for(int x: adj[v]) {
			if(!vis[x]) {
				if(dfs(x, v)) return true;
			}else {
				if(x!=p) return true;// v is connected with its ancestor x via backedge
			}
		}
		return false;
	}

}
/*
# TEST CASE-1				# TEST CASE-2				# TEST CASE-3
6 6							6 6							7 6
1 2							1 4							1 2
1 4							4 5							2 3
2 3							4 6							3 4
4 5							5 6							4 5
4 6							2 3							5 6
5 6							1 2							6 7
ANS							ANS							ANS
1->2->3->4->5->6->true		1->4->5->6->true			1->2->3->4->5->6->7->false
							
*/
