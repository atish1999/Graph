package Graph_basic.concept;
/*
							"जय श्री कृष्णा"
 */
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
	static int dis[],INF=(int)(1e9);
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Dijkstra(), "Main", 1 << 26).start();
	}
	static class Pair implements Comparable<Pair> {
		int x,y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Pair o) {
			return this.y-o.y;
		}
		
	}
	
	static void dijkstra(int v) {
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		dis[v]=0;// distance of source node is zero
		pq.add(new Pair(v,0));
		while(!pq.isEmpty()) {
			int first=pq.peek().x,second=pq.peek().y;
			pq.poll();
			for(Pair child: adj[first]) {
				int f=child.x;
				int y=child.y;
				if(second+y<dis[f]) {//or we can write dis[first]+y<dis[f])
					
					dis[f]=second+y;
					pq.add(new Pair(f,dis[f]));
				}
			}
		}
		
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt(), m = fr.nextInt();
			adj = new List[n + 1];
			vis = new boolean[n + 1];
			dis = new int[n + 1];
			Arrays.fill(dis, INF);
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt(), w=fr.nextInt();
				adj[u].add(new Pair(v,w));
				adj[v].add(new Pair(u,w));
			}
			dijkstra(1);
			for(int i=1; i<=n; i++) {
				System.out.print(dis[i]+" ");
			}
			System.out.println();
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
/*
6 9
1 2 4
1 6 2
2 3 5
2 6 1
6 3 8
6 5 10
3 4 6
3 5 3
5 4 5
Ans:
0 3 8 14 11 2 
*/
