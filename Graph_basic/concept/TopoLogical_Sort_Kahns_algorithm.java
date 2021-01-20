package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class TopoLogical_Sort_Kahns_algorithm {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static ArrayList<Integer> res,res1;
	static int in_Degree[];
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()),m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			res=new ArrayList<>();
			res1=new ArrayList<>();
			in_Degree=new int[n+1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				++in_Degree[v];
			}
			topological_sort(n);
//			kahn(n);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

//	applying using bfs
	static void kahn(int n) {//number of nodes
		Queue<Integer> q=new LinkedList<>();
		for(int i=1; i<=n; i++) if(in_Degree[i]==0) q.add(i);
		while(!q.isEmpty()) {
			int curr=q.poll();
			res.add(curr);
			for (int x : adj[curr]) {
				--in_Degree[x];
				if(in_Degree[x]==0) q.add(x);
			}
		}
		System.out.println("elemnts after topo_sort");
		for(int i: res) System.out.print(i+" ");
		System.out.println();
//		topological sort will be possible only when {res.size()==n}
	}
// applying using dfs
//	condition is graph should not contain any cycle
	static void dfs(int v) {
		vis[v]=true;
		for(int x: adj[v]) {
			if(!vis[x]) dfs(x);
			
		}
		res1.add(v);
	}
	static void topological_sort(int n) {
		for(int i=1;  i<=n; i++) {
			if(!vis[i]) dfs(i);
		}
		Collections.reverse(res1);// we have to reverse the order
		for(int x: res1) System.out.print(x+" ");
		System.out.println();
	}
//	In case of topological sort sorting order can be random.but dependencies should
//	have the specific order.if there is a cycle present in the graph then topo sort 
//	will not be possible.(i.e. res.size()==n will be the condition)
	/*
	 5 5
	 1 2
	 1 3
	 2 4
	 3 4
	 3 5
	 answer-(1 3 5 2 4) or (1 2 3 4 5)
	 both the above answers are correct 
	*/
}
