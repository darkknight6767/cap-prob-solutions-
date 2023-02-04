package cap;

import java.util.HashMap;

public class Move 
{
    private int max;
    
    
    private HashMap<Integer,Integer> snakHashMap;
    private HashMap<Integer,Integer> ladderHashMap;
    
    public Move(final int max,Snakes snakes,ladder ladders) {
        this.max=max;
        snakHashMap=snakes.getSnakes();
        ladderHashMap=ladders.getLadders();
    }
    
    /**
     * @param currentPlayer
     * @return finalPosition
     * returns next position that the player will go to after the dice is rolled.
     */
    public int makeMove (Player currentPlayer,int move) {
        
       int currentPosition=currentPlayer.getLocation();
        int finalPosition=currentPosition+move;
        

        if(snakHashMap.containsKey(finalPosition))
        {
            finalPosition=snakHashMap.get(finalPosition);
            System.out.println("");
           //snakHashMap.remove(finalPosition); //lazy snakes 
        }
       
        if(ladderHashMap.containsKey(finalPosition))
        {
            finalPosition=ladderHashMap.get(finalPosition);
        }
       
        if(finalPosition>max)
        {
            finalPosition=currentPosition;
        }
    return finalPosition;
    }

}
