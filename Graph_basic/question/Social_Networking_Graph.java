package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Social_Networking_Graph {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int dis[];
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			int q=Integer.parseInt(br.readLine());
			while(q-->0) {
				st = new StringTokenizer(br.readLine());
				int source = Integer.parseInt(st.nextToken()), 
				d = Integer.parseInt(st.nextToken());
				dis = new int[n + 1];
				vis = new boolean[n + 1];	
				bfs(source);
				int c=0;
				for(int i=0; i<=n; i++) {
					if(dis[i]==d) ++c;
				}
				System.out.println(c);
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void bfs(int v) {
		Queue<Integer> q=new LinkedList<>();
		vis[v] = true;
		dis[v]=0;
		q.add(v);
		while(!q.isEmpty()) {
			int parent=q.poll();
			for(int x: adj[parent]) {
				if(!vis[x]) {
					vis[x]=true;
					q.add(x);
					dis[x]=dis[parent]+1;
				}
			}
		}
	}

}