package pfafseysi;

import java.util.Stack;

public class pfafseysi{

						//  ID  A  B   BS O  C  LENGTH   B=> Start    A=>end
static int[][] testdata = { {1, 1, 15, 1, 1, 8, 23689},
							{2, 2, 5, 1, 1, 8, 3475},
							{3, 3, 9, 1, 1, 8, 8939},
							{4, 4, 5, 1, 1, 8, 2353},
							{5, 5, 12, 1, 2, 9, 5533},
							{6, 6, 13, 1, 1, 8, 6401},
							{7, 7, 10, 1, 1, 8, 9629},
							{8, 8, 10, 1, 1, 8, 3681},
							{9, 9, 12, 1, 2, 9, 4943},
							{10, 10, 9, 1, 2, 9, 1588},
							{11, 11, 18, 1, 1, 8, 2775},
							{12, 12, 16, 1, 3, 10, 1824},
							{13, 13, 14, 1, 3, 10, 1381},
							{14, 14, 18, 1, 3, 10, 1320},
							{15, 16, 13, 1, 3, 10, 2569},
							{16, 17, 15, 1, 3, 10, 8236},
							{17, 18, 17, 1, 3, 10, 4365},
							{18, 19, 14, 1, 1, 8, 4703},
							{19, 20, 21, 1, 1, 8, 10967},
							{20, 21, 16, 1, 2, 9, 6872},
							{21, 22, 17, 1, 1, 8, 4809},
							{22, 23, 21, 1, 1, 8, 2483}
							};
		
    
    public static BasinNode getBasinByStartNode(BasinNode[] data, int startNode) {
    	BasinNode temp = null;
    	for (int i = 0; i < data.length; i++)
    		if (data[i] != null && data[i].startNode == startNode) {
   // 			System.out.println(data[i].startNode + "---" + data[i].endNode + "  in getbasin method");
    			temp = data[i];
    			data[i] = null; 
    			return temp;
    		}
    	return temp;
    }
    
    public static void main(String[] args){

    	Stack<Integer> startnodestack = new Stack<Integer>(); 
    	
    	BinaryTree binarytree = new BinaryTree();   	
    	
        BasinNode[] maindata = new BasinNode[testdata.length];
        
        //Migrate the data in the testdata array to the BasinNode Object array
        for (int i=0; i < testdata.length; i++){
             maindata[i] = new BasinNode(testdata[i][0], testdata[i][1], testdata[i][2], testdata[i][3],
                						testdata[i][4], testdata[i][5], testdata[i][6]);
            }

        //find starting node
        int startnode = -1;
                
        for (int i=0; i < maindata.length - 1 ; i++){
            if (maindata[i].endNode +1 != maindata[i+1].endNode) {
               startnode = maindata[i].endNode +1;
               break;
            }
        }

        BasinNode dummyforroot = new BasinNode(0, startnode, 0, 0, 0, 0, 0);
        
        TreeNode root = new TreeNode(dummyforroot);
        
        BasinNode temp = null;
        
        startnodestack.push(startnode);
        
        while (! startnodestack.isEmpty()) {

        	temp = getBasinByStartNode (maindata, startnodestack.peek());

        	if (temp != null) {
        		//System.out.println(temp.startNode + "-" + temp.endNode + " found!");
        		binarytree.addRecursive(root, temp);
        		//System.out.println(temp.endNode + " added to the tree");
        		startnodestack.push(temp.endNode);
                //System.out.println(temp.endNode + " pushed to the stack");
        	} else {
        		//System.out.println("cant find any node starting with " + startnodestack.peek() + " so popped from the stack");
        		startnodestack.pop();
        	}
        } 
        binarytree.traverseLevelOrder(root);
    
        BasinNode temp2 = binarytree.deep(root);
        
        
        System.out.println("Deepest child is: " + temp2.endNode);
        //System.out.println(root.right.left.right.left.right.right.left.basin.endNode);
    }



}