package cap;

public class Board {
    private int max;
    public Board(int maxSize) {
        this.max = maxSize;

    }
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @param currentPosition
     * @return boolean
     * it checks whether the current Player win or not  
     */
    public boolean won(int currentPosition)
    {
        if(currentPosition==max)
            return true;
        return false;
    }
    
}
