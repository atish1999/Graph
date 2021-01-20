package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Printing_Shortest_Path_Using_BFS {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			System.out.println("enter your source and destiation");
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()), 
				d = Integer.parseInt(st.nextToken());
			bfs(s,d);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void bfs(int source,int destination) {
		Queue<Integer> q=new LinkedList<>();
		int par[]=new int[adj.length];
		vis[source] = true;
		par[source]=-1;
		q.add(source);
		boolean isFound=false;
		while(!q.isEmpty()) {
			int curr=q.poll();
			if(curr==destination) { // if we arrive at the destination we have 
				isFound=true;  // to stop our journey further
				break;
			}
			for(int x: adj[curr]) {
				if(!vis[x]) {
					vis[x]=true;
					q.add(x);
					par[x]=curr;
				}
			}
		}
		if(!isFound) { // if destination is not found
			System.out.println("Sorry bro, your man is not here");
			return;
		}
		int cur=destination;
		int distance=0;
		StringBuilder path=new StringBuilder();
		while(par[cur]!=-1) {
			path.append(cur+"->");
			cur=par[cur];
			++distance;
		}
		path.append(source);
		System.out.println(distance+"\n"+path.reverse().toString());
		
	}

}
