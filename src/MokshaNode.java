public class MokshaNode {
    private int squareValue;
    private MokshaNode parentNode;

    public MokshaNode(int squareValue, MokshaNode parentNode) {
        this.squareValue = squareValue;
        this.parentNode = parentNode;
        // System.out.println("New node "+squareValue+" Parent node "+parentNode.getSquareValue());
    }

    public MokshaNode() {
        this.squareValue = 0;
        this.parentNode = null;
    }


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
