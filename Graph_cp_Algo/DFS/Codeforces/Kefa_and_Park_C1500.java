package Graph_cp_Algo.DFS.Codeforces;
import java.util.*;
import java.io.*;

public class Kefa_and_Park_C1500 {

	static int mod = (int) (1e9 + 7),cnt=0,m,ans=0;
	static List<Integer> adj[];
	static boolean vis[];
	static int cat[];
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
			cat=new int[n+1];
			cat[0]=0;
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<n+1; i++) cat[i]=Integer.parseInt(st.nextToken());
			for (int i = 0; i < n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			dfs(1,-1,cat[1]);
			System.out.println(ans);
		}
	}

	static void dfs(int v,int p, int k) {
		if(k>m) return;
		if(adj[v].size()==1 && v!=1) {
			++ans;
			return;
		}
		for (int x : adj[v]) {
			if(x!=p) {
				if(cat[x]==1) {
					dfs(x,v,k+1);//if there is consecutive 1's
				}else {
					dfs(x,v,0);//if there is no consecutive 1
				}
			}
		}
	}
}
/*
13 2
0 1 0 0 1 0 1 1 0 0 0 1 0
1 2
1 3
2 4
2 5
2 6
5 7
3 8
3 9
8 10
8 11
10 12
12 13
(ans->5)
 */

