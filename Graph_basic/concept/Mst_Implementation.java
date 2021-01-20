package Graph_basic.concept;
import java.util.*;
import java.io.*;

public class Mst_Implementation implements Runnable{
//	Kruskal Algorithm.......
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
	static class Edge implements Comparable<Edge>{
		int x,y,z;
		@Override
		public int compareTo(Edge o) {
			return this.z-o.z;
		}
	}
	static int par[],Rank[];
	public static void main(String[] args) throws java.lang.Exception {
		  new Thread(null, new Mst_Implementation(), "Main", 1<<26).start();
	}
	static int find(int a) {// by using path compression
		if(par[a]<0) return a;
	    return par[a]=find(par[a]);
	}
	static void union(int a, int b) {// by using union by rank
//		Here a and b are Parent of (a) and parent of (b)
		if(Rank[a]>Rank[b]) {
			//a would be the parent
			par[b]=a;
			Rank[a]+=Rank[b];// and rank of a will be updated
//			i.e. rank of new parent will be updated
		}else {
			// b would be the parent
			par[a]=b;
			Rank[b]+=Rank[a];// and rank of b will be updated
//			i.e. rank of new parent will be updated
		}
	}
	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
	    FastReader s=new FastReader();
		int n=s.nextInt(),m=s.nextInt();
		Edge a[]=new Edge[m];
		par=new int[n+1];
		Rank=new int[n+1];
		for(int i=0; i<m; i++) {
			a[i]=new Edge();
			a[i].x=s.nextInt();a[i].y=s.nextInt();a[i].z=s.nextInt();
		}
		Arrays.sort(a);
		Arrays.fill(par, -1);
		Arrays.fill(Rank, 1);
//		approach is to sort all the edges increasing order
//		.after that we will be picking up 
//		any two nodes lets say u and v ,if we can reach from u to v or vice versa
//		we will be ignoring that u and v otherwise we will add that edge into sum
//		and we will be making edges between u and v
		long sum=0;
		for(int i=0; i<m; i++) {
			int pa=find(a[i].x),pb=find(a[i].y);
			if(pa!=pb) {
				sum+=a[i].z;
				union(pa,pb);
			}
		}
		System.out.println(sum);
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
	
 
}


