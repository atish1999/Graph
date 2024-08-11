package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Tarjan_Algo_for_SCC {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[],onStack[];
	static Stack<Integer> s;
	static int in[],low[],scc,timer=1;
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			onStack=new boolean[n + 1];
			s=new Stack<>();
			in =new int[n + 1];
			low =new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
			}
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					dfs(i);
				}
			}
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
// Tarjan Algorithm...........
	static void dfs(int v) {
		vis[v] = onStack[v]=true;
		in[v]=low[v]=timer++;
		s.push(v);
		for (int x : adj[v]) {
			if(vis[x] && onStack[x]) {
				low[v]=Math.min(low[v], in[x]);
			}else if(!vis[x]){
				dfs(x);
				if(onStack[x]) {
					low[v]=Math.min(low[v], low[x]);
				}
			}
		}
		if(in[v]==low[v]) {
			++scc;
			System.out.println("scc no.->"+scc);
			while(true) {
				int x=s.pop();
				onStack[x]=false;
				System.out.print(x+" ");
				if(x==v) break;
			}
			System.out.println();
		}
	}
/*
1
8 12
1 2
2 3
3 1
2 8
3 4
8 4
4 8
7 8
5 4
5 7
7 6
6 5
*/
}
