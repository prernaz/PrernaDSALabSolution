package com.greatlearning.DSALab3SolutionProblem2;
import java.util.*;
//This Program finds a Pair of nodes with specified sum in a given BST

//A class to store a BST node
class Node
 {
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
 }

public class FindSumPair {
  
	// Recursive method to insert a key into a BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) 
        {
            return new Node(key);
         }
 
        // if the given key is less than the root node, insert in the left subtree
        if (key < root.data)
        {
            root.left = insert(root.left, key);
        }
 
        // if the given key is more than the root node, insert in the right subtree
        else 
        {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
    
 //The method below is to print BST in Levelorder
    public void levelOrder(Node root) {
       Queue<Node> queue1 = new LinkedList<Node>();
       queue1.add(root);
       while (!queue1.isEmpty()) {
         Node tempNode = queue1.poll();
         System.out.print(tempNode.data + " ");
          
         // enqueue left node
         if (tempNode.left != null) {
          queue1.add(tempNode.left);
         }

         // enqueue right node
         if (tempNode.right != null) {
           queue1.add(tempNode.right);
        }
       }
     }
    
    // Method to find a pair with a given sum in the BST
    public static boolean findPair(Node root, int sum, Set<Integer> set)
    {
       // base case
       if (root == null) 
       {
         return false;
        }
 
      // return true if pair is found in the left subtree; 
      //otherwise, continue processing the node
       if (findPair(root.left, sum, set)) 
        {
         return true;
        }
 
     // if a pair is formed with the current node, print the pair and return true
     if (set.contains(sum - root.data))
      {
        System.out.println("Node Pair found (" + (sum - root.data) + ", "
                                    + root.data + ")");
        return true;
      }
 
     // insert the current node's value into the set
     else 
     {
        set.add(root.data);
      }
 
     // search in the right subtree
     return findPair(root.right, sum, set);
    }
 
   public static void main(String[] args)
   {
    Scanner sc = new Scanner(System.in);
    Node root = null;
    FindSumPair findSP = new FindSumPair();
    root = findSP.insert(root, 40);
    root = findSP.insert(root, 20);
    root = findSP.insert(root, 60);
    root = findSP.insert(root, 10);
    root = findSP.insert(root, 30);
    root = findSP.insert(root, 50);
    root = findSP.insert(root, 70);
    System.out.println("The Binary Search Tree we have \n"+ 
    	"<Printed using levelorder Traversal>"+"\n");
   	findSP.levelOrder(root);
   	System.out.println();
    	
    //Set<Integer> set = new HashSet<>();
    System.out.println("\nPlease enter the sum value 130 \n"+
    "<we find if pair of nodes = Sum is found in the above BST>\n");
    // find pair with the given sum
    int sum = sc.nextInt();
    while(sum!=0)
    {
     System.out.println("Sum You have entered is = " +sum+"\n");
     // create an empty set
     Set<Integer> set = new HashSet<>();
     boolean bool = findPair(root, sum, set);
      if(!bool)
       //if (!findPair(root, sum, set)) 
       System.out.println("Nodes are not found");
       System.out.println("\nPlease enter new sum value(any value)"+
            		 "<we find if any pair of nodes = Sum is found in given BST>\n"+
            		"<Enter 0 to quit>");
       sum = sc.nextInt(); 
    }   
    System.out.println("Program executed Successfully");
   }//end main method
 }//end class FindSumPair