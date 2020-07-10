package pfafseysi;

public class BasinNode {

	public int segmentID;
	public int endNode;
	public int startNode;
	public int basin;
	public int order;
	public int orderCell;
	public float length;
	public int pfafCode;
	
	public BasinNode(int segmentID, int endNode, int startNode, int basin, int order, int orderCell, float length) {
		
		this.segmentID = segmentID;
		this.endNode = endNode;
		this.startNode = startNode;
		this.basin = basin;
		this.order = order;
		this.orderCell = orderCell;
		this.length = length;
		this.pfafCode = -1;

	}
	
	//Finds the starting point of the basin by comparing the basin IDs
	//If the start node cannot be found returns -1
    public static int findStartNode(BasinNode[] data){

        for (int i=0; i<data.length; i++){
            if (data[i].segmentID != data[i+1].segmentID)
                return data[i].startNode;
        }

        return -1;
    }
	
	public BasinNode getBasinNode(BasinNode[] basinDataArray, int uniqueBasinID) {
		
		for (int i = 0; i < basinDataArray.length; i++)
			if (basinDataArray[i].segmentID == uniqueBasinID)
				return basinDataArray[i];
		
		return null;
	}
	

	
}
