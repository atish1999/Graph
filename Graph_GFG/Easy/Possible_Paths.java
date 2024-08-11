package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class Possible_Paths implements Runnable {

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
	static List<Integer> adj[];
	static boolean vis[];
	static int u,v,k;
	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Possible_Paths(), "Main", 1 << 26).start();
	}
	/*
	Given a directed graph and two vertices ‘u’ and ‘v’ in it,
	count all the possible walks from ‘u’ to ‘v’ with exactly k edges on the walk.
	 */
	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.y - o.y;
		}

	}
	static void bfs(int src) {
		Queue<Pair> q=new PriorityQueue<>();
		q.add(new Pair(src, 0));
		int count=0;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int node=p.x;
			int depth=p.y;
//			System.out.println(node+" "+depth);
			if(node== v && (depth==k)) {
				++count;
			}
			if(depth>k) 
				break;
			
			for(int x: adj[node]) {
				q.add(new Pair(x, depth+1));
			}
		}
		System.out.println(count);
//		for(Iterator<Pair> it=q.iterator(); it.hasNext();) {
//			System.out.println(it.next().x+" "+it.next().y);
//		}
	}
	

	@Override
	public void run() {
		long start = System.currentTimeMillis(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			adj = new ArrayList[n];
			for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int x=fr.nextInt();
					if(x==1) adj[i].add(j);
				}
			}
//			for(int i=0; i<n; i++) {
//				System.out.println(i+"->"+adj[i]);
//			}
			u=fr.nextInt();v=fr.nextInt();k=fr.nextInt();
			bfs(u);
		}
		long end = System.currentTimeMillis(); // Program End
//		System.err.println("Time taken: " + (end - start)  + " ms");
	}
}

