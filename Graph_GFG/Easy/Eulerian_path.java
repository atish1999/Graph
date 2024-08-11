package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class Eulerian_path implements Runnable {

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

	static int mod = (int) (1e5 + 1),n;
	static List<Integer> adjl[];
	static boolean vis[];

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Eulerian_path(), "Main", 1 << 26).start();
	}
	/*
	Simply we need to find whether the given graph is semi-eulerian Graph or not , 
	it true print 1 else print 0.
	The condition for semi eulerian graph is that , 
	the count of odd degree vertices are 2.

	 */

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			n=fr.nextInt();
	        adjl=new ArrayList[n];
	        for(int i=0; i<n; i++) adjl[i]=new ArrayList<>();
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                int x=fr.nextInt();
	                if(x==1) {
	                   adjl[i].add(j);
	                }
	            }
	        }
	        int count=0;
	        for(int i=0; i<n; i++){
	            if(((adjl[i].size()&1)==1)) ++count;
	        }
	        System.out.println(count==2?"1":"0");

		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
}
