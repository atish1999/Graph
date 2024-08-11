package Graph_GFG.Easy;
import java.util.*;
import java.io.*;

public class DFS_of_a_graph
{
 public static void main(String args[])
 {
     Scanner sc = new Scanner(System.in);
     int t =sc.nextInt();
     while(t-- > 0)
     {
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         int nov = sc.nextInt();
         int edg  =sc.nextInt();
         for(int i = 0; i < nov; i++)
             list.add(i, new ArrayList<Integer>());
             
         for(int i = 1; i <= edg; i++)
         {
             int u = sc.nextInt();
             int v = sc.nextInt();
             list.get(u).add(v);
             list.get(v).add(u);
         }
         
         ArrayList<Integer> res = new Traversal().dfs(list, nov);
         for (int i = 0; i < res.size (); i++) 
             System.out.print (res.get(i) + " ");
         System.out.println();
     }
 }
}

//} Driver Code Ends


//User function Template for Java


/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal{
	
	 static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
	 {
	    boolean vis[]=new boolean[N]; 
	    ArrayList<Integer> l=new ArrayList<>();
	    dfs1(g,vis,0,l);// starting index from 0.
	    return l;
	 }
	 static void dfs1(ArrayList<ArrayList<Integer>> g, boolean[] vis, int v, ArrayList<Integer> l){
	     vis[v]=true;
	     l.add(v);
	     for(Integer x: g.get(v)){
	         if(!vis[x]) dfs1(g,vis,x,l);
	     }
	 }
}


