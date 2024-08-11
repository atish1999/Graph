package Tree.BinaryTree;
import java.io.*;
import java.util.*;
public class Creation_of_BT_and_its_Traversal {
	
	static BufferedReader br=null;
	public static void main(String[] args) throws Exception {
		
		Node root=createTree();
		System.out.println("Inorder traversal:");
		inOrder(root);
		System.out.println();
		System.out.println("Preorder traversal:");
		PreOrder(root);
		System.out.println();
		System.out.println("Postorder traversal:");
		PostOrder(root);
	}
	static class Node{
		Node left,right;
		int data;
		public Node(int data) {
			this.data=data;
		}
	}
	static Node createTree() throws java.lang.Exception {
		Node root=null;
		br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter data");
		int data=Integer.parseInt(br.readLine());
		
		if (data==-1) return null;
		
		root=new Node(data);
		
		System.out.println("Enter data for left of "+data);
		root.left=createTree();
		
		System.out.println("Enter data for right of "+data);
		root.right=createTree();
		
		return root;
	}
	
	static void inOrder(Node root) { // L N R
		if(root==null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	static void PreOrder(Node root) { // N L R
		if(root==null) return;
		System.out.print(root.data+" ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	static void PostOrder(Node root) { // L R N
		if(root==null) return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data+" ");
	}
	
}
