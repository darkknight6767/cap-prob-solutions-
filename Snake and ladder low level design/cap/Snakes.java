package cap;

import java.util.HashMap;

public class Snakes {
   private HashMap<Integer,Integer> snakes=new HashMap<>();
      
   public HashMap<Integer, Integer> getSnakes() {
      return snakes;
   }

  public void setSnakes(int start,int end)
   {
      snakes.put(start,end);     
   }
   /*  public void snakeSetter()
    {
      snakes.put(5,2);
    } 
    */ 
  
}
