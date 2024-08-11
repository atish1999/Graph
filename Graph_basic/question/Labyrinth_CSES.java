package Graph_basic.question;
import java.util.*;
import java.io.*;

public class Labyrinth_CSES {

	static int mod = (int) (1e9 + 7),n,m,ex,ey,sx,sy;
	static boolean vis[][];
	static char in[][];
	static int dx[]= {-1,0,1,0},
			   dy[]= {0,-1,0,1};
	static class Pair<X,Y>{
		X x; Y y;
		public Pair(X x, Y y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws java.lang.Exception {
		long start = System.nanoTime(); // Program Start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			in=new char[n][m];
			vis=new boolean[n][m];
			for(int i=0; i<n; i++) {	
				String s=br.readLine();
				for(int j=0; j<m; j++) {
					in[i][j]=s.charAt(j);
					if(in[i][j]=='A') {sx=i;sy=j;}
					if(in[i][j]=='B') {ex=i;ey=j;}
				}
			}
			bfs(sx,sy);
			
		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}
	static boolean is_Valid(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m && !vis[x][y] && (in[x][y]=='.' || in[x][y]=='A' || in[x][y]=='B');
	}
	static void bfs(int x, int y) {
		Queue<Pair<Integer,Integer>> q=new LinkedList<>();
		q.add(new Pair(x,y));
		vis[x][y]=true;
		boolean is_Found=false;
		Pair<Pair<Integer,Integer>,Character> par[][]=new Pair[n][m];
		par[x][y]=new Pair<Pair<Integer,Integer>,Character>(new Pair<Integer,Integer>(-1,-1),'O');
		while(!q.isEmpty()) {
			int f=q.peek().x,s=q.peek().y;
			q.poll();
			if(f==ex && s==ey) {
				is_Found=true;
				break;
			}
			for(int i=0; i<4; i++) {
				int x1=f+dx[i],y1=s+dy[i];
				if(is_Valid(x1,y1)) {
					Pair<Integer,Integer> child=new Pair<Integer,Integer>(x1,y1),
					parent=new Pair<Integer,Integer>(f,s);
					q.add(child);
					vis[x1][y1]=true;
					char c=(dx[i]==-1 && dy[i]==0?'U':dx[i]==0 && dy[i]==-1?'L':
						dx[i]==1 && dy[i]==0?'D':'R');
					par[x1][y1]=new Pair<Pair<Integer,Integer>,Character>(parent,c);					
				}
			}
		}
		if(!is_Found) {
			System.out.println("NO");
			return;
		}
		StringBuilder path=new StringBuilder();
		while(true) {
			path.append(par[ex][ey].y);
			int r=par[ex][ey].x.x,c=par[ex][ey].x.y;
			ex=r;
			ey=c;
			if(ex==sx && ey ==sy) break;
		}
		System.out.println("YES\n"+(path.length())+"\n"+path.reverse().toString());
	}

}
