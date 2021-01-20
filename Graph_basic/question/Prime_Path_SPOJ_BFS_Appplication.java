package Graph_basic.question;
import java.util.*;
import java.io.*;
public class Prime_Path_SPOJ_BFS_Appplication {
	
	static List<Integer> adj[];
	static boolean vis[],prime[];
	static int dis[];
	static boolean isPrime(int n) {
		if(n<=1) return false;
		if(n<=3) return true;
		if(n%2==0 || n%3==0) return false;
		for(int i=5; i*i<=n; i+=6) {
			if(n%i==0 || n%(i+2)==0) return false;
		}
		return true;
	}
	static boolean differ(int a, int b) {
		String x=""+a,y=""+b;
		int count=0;
		for(int i=0; i<4; i++) {
			if(x.charAt(i)!=y.charAt(i)) ++count;
		}
		return count==1?true:false;
	}
	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		dis=new int[10000];
		adj=new ArrayList[10000];
		for(int i=1000; i<=9999; i++) adj[i]=new ArrayList<>();
		for(int i=1000; i<=9999; i++) {
			if(isPrime(i)) {
				for(int j=i+1; j<=9999; j++) {
					if(isPrime(j) && differ(i,j)) {
						adj[i].add(j);
						adj[j].add(i);
					}
				}
			}
		}
		while(t-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()),
				b=Integer.parseInt(st.nextToken());
			vis=new boolean[10000];
			Arrays.fill(dis, -1);
			bfs(a);
			System.out.println(dis[b]==-1?"Impossible":dis[b]);
		}
	}
	static void bfs(int s) {//s for source
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		vis[s]=true;
		dis[s]=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int x: adj[cur]) {
				if(!vis[x]) {
					vis[x]=true;
					dis[x]=dis[cur]+1;
					q.add(x);
				}
			}
		}
	}

}

