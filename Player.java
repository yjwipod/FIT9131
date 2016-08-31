//import java.util.Scanner;

public class Player
{
    private String name;
    private int win;
    private int loss;
    private int balance;
    private String guessNumber;
    
    public Player()
    {
        name = null;
        win = 0;
        loss = 0;
    }
    
    public Player(String newName)
    {
        name = newName;
        win = 0;
        loss = 0;
    }
    
    public void setName(String typeIn)
    {
        
        name = typeIn;
        System.out.println("Welcome and enjoy, " + name);
    }
    
    public String getName()
    {
        return name;
    }
//     public void setName()
//     {
//         Scanner console = new Scanner(System.in);
//         System.out.print("Please enter your name: ");
//         name = console.nextLine();
//         System.out.println("Welcome and enjoy, " + name);
//     }
//     
//     public String getName()
//     {
//         return name;
//     }
    
    public void setWin()
    {
        win ++;
    }
    
    public int getWin()
    {
        return win;
    }
    
    public void setLoss()
    {
        loss ++;
    }
    
    public int getLoss()
    {
        return loss;
    }
    
    public void setBalance(int number)
    {
        balance = balance + number;
    }
    
    public void resetBalance()
    {
        balance = balance * 0;
    }
    
    
    
    public int getBalance()
    {
        return balance;
    }
    
    
    public void setGuessNumber(String typeIn)
    {
        guessNumber = typeIn;
    }
    
    public String getGuessNumber()
    {
        return guessNumber;
    }
    
    public int getNum()
    {
        int number = Integer.parseInt(guessNumber);
        return number;
    }
}