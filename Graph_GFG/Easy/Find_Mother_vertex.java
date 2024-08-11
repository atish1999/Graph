package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class Find_Mother_vertex implements Runnable {

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

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Find_Mother_vertex(), "Main", 1 << 26).start();
	}
	/*

 "If there exist mother vertex (or vertices), 
 then one of the mother vertices is the last finished vertex in DFS. 
 (Or a mother vertex has the maximum finish time in DFS traversal).
	 */
	static int findMother(ArrayList<ArrayList<Integer>> g, int n)
    {
        boolean vis[]=new boolean[n + 1]; 
        int mv=0;
        for(int i=0 ;i<n; i++){
            if(!vis[i]) {
                dfs(g,i,vis);
                mv=i;
            }
        }
        Arrays.fill(vis, false);
        dfs(g,mv,vis);
        for(int i=0; i<n; i++){
            if(!vis[i]){
                mv=-1;
                break;
            }
        }
        return mv;
    }
    static void dfs(ArrayList<ArrayList<Integer>> g, int node, boolean vis[]){
        vis[node]=true;
        for(Integer x: g.get(node)){
            if(!vis[x]){
                dfs(g,x,vis);
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
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = fr.nextInt(), v = fr.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}

		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
