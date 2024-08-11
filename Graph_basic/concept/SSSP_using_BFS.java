package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class SSSP_using_BFS {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int dis[];
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			dis = new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			bfs(1);
			System.out.println(dis[n]);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void bfs(int v) {
		Queue<Integer> q=new LinkedList<>();
		vis[v]=true;
		q.add(v);
		dis[v]=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int x: adj[cur]) {
				if(!vis[x]) {
					q.add(x);
					dis[x]=dis[cur]+1;
					vis[x]=true;
				}
			}
		}
	}
/*
1
7 8
1 2
2 4
1 3
2 3
3 5
5 6
5 7
6 7
ans
1 1 0 2 1 2 2 

 */
}