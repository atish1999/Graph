package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Bertown_Roads_Application_of_Bridges {

	static private int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	static int in[],low[],timer,count;
	static StringBuilder sb;
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			low = new int[n + 1];
			in = new int[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), 
				v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			sb=new StringBuilder();
			dfs(1,-1);
			if(count!=0) { //if there is at least one bridge we can't orient
				System.out.println(0);
			}else {
				System.out.println(sb.toString());
			}
		}
	}

	static void dfs(int v,int p) {
		vis[v] = true;
		in[v]=low[v]=timer++;
		for (int x : adj[v]) {
			if(x==p) continue;
			if(vis[x]) {
//				edge->backward
				low[v]=Math.min(low[v], in[x]);
				if(in[v]>in[x]) sb.append(v+" "+x+"\n");
			}else {
//				edge->forward
				sb.append(v+" "+x+"\n");
				dfs(x,v);
				if(low[x]>in[v]) {
					++count;//bridges found
					return;
				}
				low[v]=Math.min(low[v],low[x]);
			}
		}
	}

}
