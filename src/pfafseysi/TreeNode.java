package pfafseysi;

public class TreeNode {

//	    public int pfafCode;
//	    public int length;
	    public BasinNode basin;
	    public TreeNode left, right; 
	  
	    public TreeNode(BasinNode basin) { 
	        this.basin = basin;
	        this.left = null;
	        this.right = null; 
	    }


/*	    public void setPfafCode(int pfafCode) {
	    	this.pfafCode = pfafCode;
	    }

	    public int getPfafCode(TreeNode node) {
	    	return this.pfafCode;
	    }
*/	    

}
