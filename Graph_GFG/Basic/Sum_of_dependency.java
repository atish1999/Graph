package Graph_GFG.Basic;
import java.util.*;
import java.io.*;
public class Sum_of_dependency {

// Q. In this problem we have to calculate sum of the out degrees of all the nodes of a DG
	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()),e=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int c=0;
			for(int i=0; i<2*e; i++) {
				int a=Integer.parseInt(st.nextToken());
				if((i&1)==0) ++c;
			}
			System.out.println(c);//here we are giving the answer after calculating out degree
//					or
			System.out.println(e);
//			because jitne pair honge edgeskki utne hi answer hai.
		}
	}

}
