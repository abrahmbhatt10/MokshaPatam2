import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Agastya Brahmbhatt
 *
 */

public class MokshaPatam {

    /*
        This will return the next square value depending on the amount of
        ladders, snakes, and the current square on the board.
     */
    public static int getNextSquare(int currentPosition, int[][] ladders, int[][] snakes){
        int nextPosition = 0;
        for(int i = 0; i < ladders.length; i++)
        {
            if(currentPosition == ladders[i][0])
            {
                nextPosition = ladders[i][1];
                break;
            }
        }
        for(int i = 0; i < snakes.length; i++)
        {
            if(currentPosition == snakes[i][0])
            {
                nextPosition = snakes[i][1];
                break;
            }
        }
        if(nextPosition == 0)
        {
            nextPosition = currentPosition;
        }
        return nextPosition;
    }

    /*
    This checks whether or not the node has reached the final square.
     */
    public static boolean isEnd(int boardSize, int currentPosition)
    {
        if(currentPosition == boardSize)
        {
            return true;
        }
        return false;
    }

    /*
        This function uses traversing a continuous while loop
        in order to successfully keep track of the number of roles needed
        to traverse the shortest path possible.
     */
    public static int getNumRolls(MokshaNode pNode){
        if(pNode == null){
            return -1;
        }
        int numRolls = 0;
        MokshaNode parentNode = null;
        MokshaNode cNode = pNode;
        String pathStr = "Path ";
        while(cNode != null){
            if(cNode.getSquareValue() != 0)
                numRolls++;
            pathStr += cNode.getSquareValue()+" ";
            cNode = cNode.getParentNode();
        }
        System.out.println(pathStr);
        return numRolls;
    }
    /**
     * fewestMoves() returns the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<MokshaNode> mPath= new LinkedList<MokshaNode>();
        mPath.removeAll(mPath);
        ArrayList<MokshaNode> mBoard = new ArrayList<MokshaNode>();

        if(boardsize < 1 || boardsize > 400)
        {
            System.out.println("Boardsize exceeds specification");
            return -1;
        }
        if(ladders == null || ladders.length > 15 || ladders.length < 1)
        {
            System.out.println("Ladders exceeds specification");
            return -1;
        }
        if(snakes == null || snakes.length > 15 || snakes.length < 1)
        {
            System.out.println("Snakes exceeds specification");
            return -1;
        }
        for(int i = 0; i < boardsize+1; i++)
        {
            mBoard.add(new MokshaNode(i, null));
        }
        /*
            Added the first position to the Queue.
         */
        MokshaNode pNode = mBoard.get(0);
        mPath.add(pNode);
        /*
        While there are still nodes left in the queue, I make the current
        node the latest node removed from queue.
        If currentNode is the last square, then I return its roll number.
        For each roll, I determine that the node is equal to the node r spaces away.
        If it is the beginning of a snake/ladder, then I make the node point
        to the ending node of a snake/ladder.
        If node has never been visited, then I save the # of rolls it took to get to node
        and I add the node to the back of the queue.
         */
        boolean playDice = true;
        int currentPosition = 0;
        MokshaNode startNode = null;
        int nextPosition = 0;
        MokshaNode newNode = null;
        boolean[] isVisited = new boolean[boardsize + 1];
        for(int i = 1; i < boardsize + 1; i++){
            isVisited[i] = false;
        }
        isVisited[0] = true;
        while(playDice)
        {
            startNode = null;
            if(!mPath.isEmpty()) {
                startNode = mPath.remove();
            }
            if(startNode == null)
            {
                playDice = false;
                break;
            }
            currentPosition = startNode.getSquareValue();
            isVisited[currentPosition] =true;
            for(int diceValue = 1; diceValue < 7; diceValue++){
                if((currentPosition + diceValue) > boardsize){
                    continue;
                }
                nextPosition = getNextSquare(currentPosition+diceValue, ladders, snakes);
                if(nextPosition < 0 || nextPosition > boardsize)
                {
                    continue;
                }
                if(isVisited[nextPosition] == false)
                {
                    newNode = mBoard.get(nextPosition);
                    newNode.setParentNode(startNode);
                    mPath.add(newNode);
                    if(nextPosition == boardsize)
                    {
                        return getNumRolls(newNode);
                    }
                    isVisited[nextPosition] = true;
                }
            }
        }
        return -1;
    }
}