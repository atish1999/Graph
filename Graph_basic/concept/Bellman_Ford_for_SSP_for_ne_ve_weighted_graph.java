package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Bellman_Ford_for_SSP_for_ne_ve_weighted_graph implements Runnable {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static int INF= (int) (1e9);
	static List<Integer> adj[];
	static boolean vis[];
	static int dis[];
	static class Edge implements Comparable<Edge> {
		int first, second, weight;

		Edge(int first, int second, int weight) {
			this.first = first;
			this.second = second;
			this.weight=weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.first - o.first;
		}

	}
	static List<Edge> e;
	static int  n,m,par[],y;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Bellman_Ford_for_SSP_for_ne_ve_weighted_graph(), "Main", 1 << 26).start();
	}
//	Detecting if graph contains negative cycle or not
	static void detect(int v) {
		Arrays.fill(dis, INF);
		Arrays.fill(par, -1);
		dis[v]=0;//distance of source node would be 0
		int x=-1;
		for(int i=1; i<=n; i++) {
			x=-1;
			for(Edge el: e) {
				int a=el.first,b=el.second,cost=el.weight;
				if(i<n) {
					if(dis[a]!=INF && dis[a]+cost<dis[b]) {
						dis[b]=dis[a]+cost;
					}
				}else {
					if(dis[a]!=INF && dis[a]+cost<dis[b]) {
						System.out.println("negative cycle exists");
					}
				}
			}
		}
		if(x==-1) {
			System.out.println("no negative cycle");
		}else {
			y=x;
		}
		
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		n=fr.nextInt();m=fr.nextInt();
		e=new ArrayList<>();
		for(int i=0; i<m ;i++) {
			int u=fr.nextInt(),v=fr.nextInt(),w=fr.nextInt();
			e.add(new Edge(u,v,w));
//			System.out.println(e[i].first+" "+e[i].second+" "+e[i].weight);
		}
		dis=new int[n+1];
		par=new int[n+1];
		detect(1);
		System.out.println(y);
		for(int i=0; i<n; i++) {
			y=par[y];
			System.out.println(y);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
