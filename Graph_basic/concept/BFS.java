package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class BFS {

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
			bfs(1);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void bfs(int s) {// s=source node
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		vis[s]=true;
		while(!q.isEmpty()) {
			int c=q.poll();
			System.out.print(c+" ");
			for(int x: adj[c]) {
				if(!vis[x]) {
					q.add(x);
					vis[x]=true;
				}
			}
		}
	}

}
