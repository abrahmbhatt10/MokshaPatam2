/* this class treats every square on the Moksha board
as a node.
 */
public class MokshaNode {
    private int squareValue;
    private MokshaNode parentNode;
// This is the constructor for the Moksha Node class
    public MokshaNode(int squareValue, MokshaNode parentNode) {
        this.squareValue = squareValue;
        this.parentNode = parentNode;
        // System.out.println("New node "+squareValue+" Parent node "+parentNode.getSquareValue());
    }

    // This is the default constructor for the Moksha Node class
    public MokshaNode() {
        this.squareValue = 0;
        this.parentNode = null;
    }

    /*
    The following are getters and setters for each attribute
    of each Moksha node.
     */
    public int getSquareValue() {
        return squareValue;
    }

    public void setSquareValue(int squareValue) {
        this.squareValue = squareValue;
    }

    public MokshaNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(MokshaNode parentNode) {
        //System.out.println("I am "+getSquareValue()+" Setting parent "+parentNode.getSquareValue());
        this.parentNode = parentNode;
    }


}
