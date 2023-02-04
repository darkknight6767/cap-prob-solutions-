package cap;

import java.util.*;
class Game implements SnakeAndLadder{
 public void gameStarter(){
    Scanner input=new Scanner(System.in);
    System.out.println("enter name of Player 1 ");
    /**
     *      getting name of players players 
     * next fix is to make no of players also to be choosen by players
     */
    String name1=input.nextLine();
    Player player1=new Player(name1,0);
    System.out.println("enter name of Player2 ");
    String name2=input.nextLine();
    Player player2=new Player(name2,0);

        Queue<Player> chance=new LinkedList<Player>();
            chance.offer(player1);
            chance.offer(player2);
    System.out.println("enter the max size of the board");
    int maxSize=input.nextInt();
   
    // classes declaration
    Board board= new Board(maxSize);
    //Move nextMove=new Move(maxSize);
    Random ran = new Random();
    normalDice dice = new normalDice();
    
    
   
    //user input for no of snakes and where should those ladders be  
  
  System.out.println("enter the no of snakes ");
   int i,start=0,end=0,noOfSnakes=input.nextInt();
  Snakes sn=new Snakes();
 // sn.snakeSetter();
  for( i=1;i<=noOfSnakes;i++)
    {
        while(start<15)
        {
                start=ran.nextInt(maxSize-1);
        }
        end=start-10;
        sn.setSnakes(start,end);
        
    }
   // System.out.println(sn.getSnakes().get(5));
     

    //user input for no of ladders and where should those ladders be 
    System.out.println("Enter the no of ladders ");
    int noOfLadders=input.nextInt();
    HashMap<Integer,Integer>snakessMap=sn.getSnakes();
     ladder ld=new ladder();
    for(i=1;i<=noOfLadders;i++)
    {
        while(end<15 &&  snakessMap.containsKey(end))
        {
                end=ran.nextInt(maxSize-1);
        }
        start=end-10;
        ld.setLadder(start,end);
    }
    //ld.setLadder(2,15); debugging statement please ignore this line
  
    // move class to identify where to go next 
   Move nextMove=new Move(maxSize,sn,ld);
  
       
    while(chance.size()>1)
    {
        Player currentPlayer=chance.poll();
        int currentLocation=currentPlayer.getLocation();
        System.out.println("\ncurrent position of "+currentPlayer.getName()+" is "+currentLocation);
        int dices=dice.rollDice();
        System.out.println("\nthe number after rolling dice is "+dices);
        int previousPosition=currentLocation;
        currentLocation=nextMove.makeMove(currentPlayer,dices);
            if(dices==6)
            {
                int count=1;
                if(previousPosition!=currentLocation)
                {
                    while (dices == 6 && count !=3) {
                        dices = dice.rollDice();
                        System.out.println(dices);
                        previousPosition = currentLocation;
                        currentLocation = nextMove.makeMove(currentPlayer, dices);
                        if (dices == 6)
                            count++;
                    }
                    if(dices == 6 && count == 3)
                    {
                        currentLocation=currentLocation-18;
                    }
                    
                }
            } 
            if(currentLocation>board.getMax())
            {
                currentLocation=previousPosition;
            }       
            if(board.won(currentLocation))
            {
                System.out.println("\nCongrats for "+currentPlayer.getName()+" for winning the game");
                break;
            }
            else{
                chance.offer(new Player(currentPlayer.getName(),currentLocation));
                System.out.println("\n"+currentPlayer.getName()+" turn is over. Current position is "+currentLocation);
            }
            
        System.out.println("\nPress Enter to continue the game");
         input.nextLine();
            
    }
    input.close();
    
}
   
}