package Graph_basic.question;
import java.util.*;
import java.io.*;

public class TOPOSORT_SPOJ {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static int[] in_Degree;
	static List<Integer> res;
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			in_Degree=new int[n + 1];
			res=new ArrayList<>();
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				++in_Degree[v];
			}
			if(!kahn(n)) {// means topological_sort not possible
				System.out.println("Sandro fails.");
			}else {
				for(int e: res) System.out.print(e+" ");
				System.out.println();
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static boolean kahn(int n) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(in_Degree[i]==0) pq.add(i);
		}
		while(!pq.isEmpty()) {
			int curr=pq.poll();
			res.add(curr);
			for(int x: adj[curr]) {
				--in_Degree[x];
				if(in_Degree[x]==0) pq.add(x);
			}
		}
		return res.size()==n;
	}

}
