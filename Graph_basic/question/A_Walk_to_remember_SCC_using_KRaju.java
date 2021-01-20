package Graph_basic.question;
import java.util.*;
import java.io.*;

public class A_Walk_to_remember_SCC_using_KRaju implements Runnable{
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
 

	static int mod = (int) (1e5 + 1);
	static List<Integer> adj[],tr[],order,scc;
	static boolean vis[];
	static Map<Integer,Integer> res;
	public static void main(String[] args) throws java.lang.Exception {
		  new Thread(null, new A_Walk_to_remember_SCC_using_KRaju(), "Main", 1<<26).start();
	}
	public static void dfs(int node) {
		vis[node]=true;
		for(int child: adj[node]) {
			if(!vis[child]) dfs(child);
		}
		order.add(node);
	}
	public static void dfs1(int node) {
		vis[node]=true;
		for(int child: tr[node]) {
			if(!vis[child]) dfs1(child);
		}
		scc.add(node);
	}
	@Override
	public void run() {
		OutputStream outputStream =System.out;
	    PrintWriter out =new PrintWriter(outputStream);
	    FastReader s=new FastReader();
		int n=s.nextInt(),m=s.nextInt();
		adj=new ArrayList[n];
		tr=new ArrayList[n];
		for(int i=0; i<n; i++) {
			adj[i]=new ArrayList<>();
			tr[i]=new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			int u=s.nextInt(),v=s.nextInt();
			--u;--v;
			adj[u].add(v);
			tr[v].add(u);
		}
		vis=new boolean[n];
		order=new ArrayList<>();
		scc=new ArrayList<>();
		res=new TreeMap<>();
		for(int i=0; i<n; i++) {
			if(!vis[i]) dfs(i);
		}
		Arrays.fill(vis, false);
		Collections.reverse(order);
		for(int i=0; i<order.size(); i++) {
			int x=order.get(i);
			if(!vis[x]) {
				scc.clear();
				dfs1(x);
				if(scc.size()==1) {
					res.put(scc.get(0), 0);
					continue;
				}
				for(int y: scc) res.put(y, 1);
			}
		}
		for(int k: res.keySet()) System.out.print(res.get(k)+" ");
		System.out.println(Long.toString(Long.MAX_VALUE).length());
	}
}