package Templates;
import java.util.*;
import java.io.*;

public class Dijkstra implements Runnable {

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

	static int mod = (int) (1e5 + 1);
	static List<Pair> adj[];
	static boolean vis[];
	static long dis[];
	static int par[];
	static long INF=Long.MAX_VALUE;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Dijkstra(), "Main", 1 << 26).start();
	}
	static class Pair implements Comparable<Pair> {
		int x; long y;
		public Pair(int x, long y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Pair o) {// for increasing order sorting
			return Long.compare(this.y, o.y);
		}
		
	}
	static int n,m;
	static void dijkstra(int v) {
		Arrays.fill(par, -1);
		Arrays.fill(dis, INF);
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		dis[v]=0;// distance of source node is zero
		pq.add(new Pair(v,0));
		while(!pq.isEmpty()) {
			int first=pq.peek().x;//current node
			long second=pq.peek().y;//distance
			pq.poll();
			for(Pair child: adj[first]) {
				int f=child.x;//neighbouring node
				long y=child.y;//distance
				if(second+y<dis[f]) {//Relaxation operation
					dis[f]=second+y;
					pq.add(new Pair(f,dis[f]));
					par[f]=first;
				}
			}
		}
		if(dis[n]==INF) {
			System.out.println(-1);
			return;
		}else {
			List<Integer> path=new ArrayList<>();
			for(int cur=n; cur!=-1; cur=par[cur]) {
				path.add(cur);
			}
			Collections.reverse(path);
			path.forEach(e->System.out.print(e+" "));
		}
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = 1;
		while (t-- > 0) {
			 n = fr.nextInt(); m = fr.nextInt();
			adj = new List[n + 1];
			vis = new boolean[n + 1];
			dis = new long[n + 1];
			par=new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt(), w=fr.nextInt();
				adj[u].add(new Pair(v,w));
				adj[v].add(new Pair(u,w));
			}
			
			dijkstra(1);
			
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}

