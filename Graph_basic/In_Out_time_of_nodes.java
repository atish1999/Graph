package Graph_basic;
import java.util.*;
import java.io.*;

public class In_Out_time_of_nodes {
/*
Q. Given 2 nodes.Find whether one node lies in the subtree of other 
   or not.
 (->)if (yes){
 		in[child]>in[root] && out[child]<out[root]
 		because child will be visited later than root and also child will
 		be returned earlier than root..
 	}else{
 		in[child]>in[root] && out[child]>out[root]
 	}

 */
	static int mod = (int) (1e9 + 7),time=1;
	static List<Integer> adj[];
	static boolean vis[];
	static int[] in,out;
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		}
	}
//	function to calculate in and out time of nodes.
	static void dfs(int v) {
		vis[v]=true;
		in[v]=time++;//time, when v is visited.
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x);
		}
		out[v]=time++;//time, when we are returning from v.
	}
}
