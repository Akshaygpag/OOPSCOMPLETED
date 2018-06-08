package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.Tree;
import com.bridgelabz.algorithm.impl.TreeNode;
import com.bridgelabz.functionalprogramming.util.Utility;

/** 
 * @author Akshay
 * @version 1.0.0
 * @since 24-May-2018
 */

public class BSTProblem {

    public static int count = 0;

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	System.out.println("Enter the number of nodes");

	int nodes = Utility.getIntergerValue();
	Tree binaryTree = new Tree();
	countBinaryTrees(nodes - 1, binaryTree.root);
	System.out.println("Trees created are : " + count);

    }

    /**
     * @param nodes
     * @param binaryTree
     * 
     */
    private static void countBinaryTrees(int nodes, TreeNode binaryTreeRoot) {
	
	if (nodes == 0) {
	    count++;
	}

	if (nodes > 0) {

	    System.out.println("Nodes exists to be placed >>>>");
	    int temp = nodes;

	
	    System.out.println("the temp value of tree is :::"+temp);

	    
	    if (nodes > 0) {

		TreeNode left = new TreeNode();
		countBinaryTrees(nodes - 1, left);

		TreeNode right = new TreeNode();
		countBinaryTrees(nodes - 1, right);
	    }
	    
	    if (nodes >= 2) {
			temp = nodes - 2;
			countBinaryTrees(temp , binaryTreeRoot);
		  if(temp==1) {count+=2;}
		    
		    }
	}

    }

}
