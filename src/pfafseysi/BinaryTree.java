package pfafseysi;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	//TreeNode root;
	int deepestlevel = -1;
	BasinNode node = null;
	
/*	
	public TreeNode addRecursive(TreeNode current, BasinNode basin) {
	  
		if (current == null) {
	        return new TreeNode(basin);
	    }
	 
		if (basin.startNode == current.basin.startNode) {
			
			if (current.left == null ) {
				current.left = addRecursive(current.left, basin);
			}
			else if (current.right == null) {
				current.right = addRecursive(current.right, basin);		
			}
	       
	    } else if (basin.startNode != current.basin.startNode){
	       
	    	current.right = addRecursive(current.right, basin);
	    	
	    } else if (basin.startNode != current.basin.startNode)
	    
	    	current.left = addRecursive(current.left, basin);
	 
	    return current;
	}*/
	
	
	public void addRecursive(TreeNode current, BasinNode basin) {
		
		//System.out.println(basin.startNode+"--"+current.basin.endNode);
		
		if (basin.startNode == current.basin.endNode) {
			
			if (current.left == null ) {
				current.left = new TreeNode(basin);
			}
			else if (current.right == null) {
				current.right = new TreeNode(basin);;		
			}
	       
	    } else {
	       
	    	if (current.left != null) addRecursive(current.left, basin);
	    	if (current.right != null) addRecursive(current.right, basin);
	    	
	    } 
		
	}
	
	
	public void traverseLevelOrder(TreeNode root) {
	    if (root == null) {
	        System.out.println("Nothing to display!");
	    	return;
	    }
	 
	    Queue<TreeNode> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	        TreeNode node = nodes.remove();
	 
	        System.out.print(" " + node.basin.endNode);
	 
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	 
	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }

	}
	
	public BasinNode deep(TreeNode root) {
		find(root, 0);
		return node;
	}

	public void find(TreeNode root, int level) {
		if (root != null) {
			
			find(root.left, ++level);
			if (level > deepestlevel) {
				node = root.basin;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}

		
}
