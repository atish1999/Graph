package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Fox_and_two_dots_Cycle_detection_B1500 {

	static int mod = (int) (1e9 + 7);
	static List<Integer> adj[];
	static boolean vis[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
			adj=new ArrayList[n*m+1];vis=new boolean[n*m+1];
			for(int i=1; i<(n*m)+1; i++) adj[i]=new ArrayList<>();
			char a[][]=new char[n][m];
			int x[][]=new int[n][m],c=0;
			for(int i=0; i<n; i++) {
				String s=br.readLine();
				for(int j=0; j<m; j++) {
					++c;
					x[i][j]=c;
					a[i][j]=s.charAt(j);
				}
			}
			//row wise
			for(int i=0; i<n; i++) {
				for(int j=0; j<m-1; j++) {
					if(a[i][j]==a[i][j+1]) {
						adj[x[i][j]].add(x[i][j+1]);
						adj[x[i][j+1]].add(x[i][j]);
					}
				}
			}
			//column wise
			for(int j=0; j<m; j++) {
				for(int i=0; i<n-1; i++) {
					if(a[i][j]==a[i+1][j]) {
						adj[x[i][j]].add(x[i+1][j]);
						adj[x[i+1][j]].add(x[i][j]);
					}
				}
			}
//we are making graphs row wise and column wise thats why if there will be a 
//cycle then cycle size would be at least 4 automatically,we don't have to
//think much.....(because we are not making graphs diagonally)..
			for(int i=1; i<=(n*m); i++) {
				if(!vis[i] && dfs(i,-1)) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No"); 
		}
	}
	//dfs function to detect cycle;
	static boolean dfs(int v, int p) {
		vis[v]=true;
//		System.out.println(v+" "+p);
		for(int x: adj[v]) {
			if(!vis[x]) {
				if(dfs(x,v)) return true;
			}else {
				if(x!=p) {
					return true;
				}
			}
		}
		return false;
	}
}
