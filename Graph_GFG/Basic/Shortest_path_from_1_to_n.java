package Graph_GFG.Basic;
import java.io.*;
import java.util.*;

public class Shortest_path_from_1_to_n{
	
	 public static void main(String args[])throws IOException
	 {
	     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(read.readLine());
	     while(t-- > 0)
	     {
	         int n = Integer.parseInt(read.readLine());
	         Solution ob = new Solution();
	         System.out.println(ob.minStep(n));
	     }
	 }
}

class Solution{
	 
	static int minStep(int n){
	    int count = 0;
	     while (n > 1) {
	         ++count;
	         if(n%3==0) n/=3;
	         else n-=1;
	     }
	     return  (count);
	 }
}
