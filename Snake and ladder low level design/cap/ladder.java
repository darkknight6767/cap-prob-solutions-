package cap;

import java.util.HashMap;

public class ladder {
    private HashMap<Integer,Integer> ladders=new HashMap<>();

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadder(int start,int end)
    {
         ladders.put(start,end);
    }
}
