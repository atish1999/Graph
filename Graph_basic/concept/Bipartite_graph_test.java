package Graph_basic.concept;
import java.util.*;
import java.io.*;
public class Bipartite_graph_test {

	static boolean vis[]=new boolean[10];
	static int colour[]=new int[10];
	@SuppressWarnings("unchecked")
	static ArrayList<Integer> adj[]=new ArrayList[10];
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	static boolean dfs(int v, int color) {
		vis[v]=true;
		colour[v]=color;
		for(int x: adj[v]) {
			if(!vis[x]) {
//		when child is not visited then we should apply dfs..		
				if (!dfs(x, color^1)) return false;
			}else {
//		when child is visited only then we should compare their color		
				if(colour[v]==colour[x]) return false;
			}
		}
		return true;
	}

}
