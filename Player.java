import java.util.Scanner;

public class Player
{
    private String name;
    private int win;
    private int loss;
    private int balance;
    private int guessNumber;
    
    public Player()
    {
        name = "null";
        win = 0;
        loss = 0;
    }
    
    public Player(String newName)
    {
        name = newName;
        win = 0;
        loss = 0;
    }
    
    public void setName()
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = console.nextLine();
        System.out.println("Welcome and enjoy, " + name);
        //name = newName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setWin(int winNumber)
    {
        win = winNumber;
    }
    
    public int getWin()
    {
        return win;
    }
    
    public void setLoss(int lossNumber)
    {
        loss = lossNumber;
    }
    
    public int getLoss()
    {
        return loss;
    }
    
    public void setBalance(int newBalance)
    {
        balance = newBalance;
    }
    
    public int getBalance()
    {
        return balance;
    }
    

}