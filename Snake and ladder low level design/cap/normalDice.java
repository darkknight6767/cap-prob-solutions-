package cap;

import java.util.Random;

public class normalDice implements dice {
    
    public int rollDice()
    {
        Random ran = new Random();
        int rand= ran.nextInt(6);
        while(rand==0)
        {
            rand=ran.nextInt(6);
        }
        return rand;
    }
}
