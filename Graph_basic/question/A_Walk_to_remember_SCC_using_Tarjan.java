package Graph_basic.question;
import java.util.*;
import java.io.*;

public class A_Walk_to_remember_SCC_using_Tarjan implements Runnable{
	
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
	    int[] nextIntArray(int size) {
			int[] arr = new int[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextInt();
			return arr;
		}
	    long[] nextLongArray(int size) {
			long[] arr = new long[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextLong();
			return arr;
		}
	    double[] nextDoubleArray(int size) {
			double[] arr = new double[size];
			for (int i = 0; i < size; ++i)
				arr[i] = nextDouble();
			return arr;
		}
	} 
	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[],scc;
	static boolean vis[],onStack[];
	static Stack<Integer> st;
	static int in[],low[],timer=1;
	static Map<Integer,Integer> res;
	public static void main(String[] args) throws java.lang.Exception {
		 new Thread(null, new A_Walk_to_remember_SCC_using_Tarjan(), "Main", 1<<26).start();
	}
// Tarjan Algorithm...........
	public static void dfs(int v) {
		vis[v] = onStack[v]=true;
		in[v]=low[v]=timer++;
		st.push(v);
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
			scc.clear();
			while(true) {
				int x=st.pop();
				onStack[x]=false;
				scc.add(x);
				if(x==v) break;
			}
			if(scc.size()==1) {
				res.put(scc.get(0), 0);
			}else {
				for(int x: scc) res.put(x, 1);
			}
		}
	}
    @Override
	public void run() {
		long start = System.nanoTime(); // Program Start
	    FastReader s=new FastReader();
	    int t=s.nextInt();
	    while(t-->0) {
			int n=s.nextInt(),m=s.nextInt();
			adj = new ArrayList[n + 1];
			vis = new boolean[n + 1];
			onStack=new boolean[n + 1];
			st=new Stack<>();
			in =new int[n + 1];
			low =new int[n + 1];
			scc=new ArrayList<>();
			res=new TreeMap<>();
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u=s.nextInt(),v=s.nextInt();
				adj[u].add(v);
			}
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					dfs(i);
				}
			}
			for(int x: res.keySet()) System.out.print(res.get(x)+" ");
			System.out.println();
	    }
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

}