package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Chef_and_Round_Run_Kraju_Codechef {

	static int mod = (int) (1e6 + 1);
	static List<Integer> adj[],tr[],scc,order;
	static boolean vis[];

	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		adj = new ArrayList[mod];
		tr =new ArrayList[mod];
		for (int i = 0; i < mod; i++) {
			adj[i] = new ArrayList<>();
			tr[i]= new ArrayList<>();
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				adj[i].clear();
				tr[i].clear();
			}
			vis = new boolean[n + 1];
			scc=new ArrayList<>();
			order=new ArrayList<>();
			int a[]=new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				a[i]=Integer.parseInt(st.nextToken());
				int u=i,v=(i+a[i]+1)%n;
				adj[u].add(v);
				tr[v].add(u);
			}
			for(int i=0; i<n; i++) {
				if(!vis[i]) dfs(i);
			}
			Arrays.fill(vis, false);
			long res=0;
			for(int i=order.size()-1; i>=0; i--) {
				if(!vis[order.get(i)]) {
					scc.clear();
					dfs1(order.get(i));
					if(scc.size()==1 && (scc.get(0) !=(int)adj[(int)scc.get(0)].get(0))) 
						continue;
					
					res+=scc.size();
				}
			}
			System.out.println(res);
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

	static void dfs(int v) {
		vis[v] = true;
		for (int x : adj[v]) {
			if(!vis[x]) dfs(x);
		}
		order.add(v);
	}
	static void dfs1(int v) {
		vis[v]=true;
		for(int x: tr[v]) {
			if(!vis[x]) dfs1(x);
		}
		scc.add(v);
	}

}
