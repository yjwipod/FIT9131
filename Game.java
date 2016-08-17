import java.util.Scanner;
import java.util.Random;

public class Game
{
    private Player newPlayer;
    private String key;
    private LuckyNumberGenerator luckyNumber;
    private LuckyNumberGenerator consolationPrize;
    private int win;
    private int loss;
    private int balance; 
    private int guessNumber;
    private Random prizeGenerator;
    private int prize;
    
    public Game()
    {
        newPlayer = new Player();
        win = newPlayer.getWin();
        loss = newPlayer.getLoss();
        balance = newPlayer.getBalance();
        updateDisplay();        
    }

    public void updateDisplay()
    {
        System.out.println("Welcome to the Guessing Game");
        System.out.println("============================");
        System.out.println("(1) Change (or Set Up) New Player");
        System.out.println("(2) Play One Round");
        System.out.println("(3) Display Player Wins Statistics");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        keyScanner();
    }

    public void keyScanner()
    {
        System.out.print("Choose an option :" );
        Scanner console = new Scanner(System.in);
        key = console.nextLine();
        playerOption();
    }

    public void playerOption()
    {
        switch (key)
        {
            case "1":                  
                newPlayer.setName();
                //System.out.print("test 1");
                keyScanner();
                break;
            case "2":
                if (newPlayer.getName() == "null")
                { 
                    System.out.println("Please press 1 to set a player first.");
                    keyScanner();
                    //return case "1";
                }
                else
                    gamePlay();
                keyScanner();
                break;
            case "3":
                if (newPlayer.getName() == "null")
                { 
                    System.out.println("Please press 1 to set a player first.");
                    keyScanner();
                    //return case "1";
                }
                else
                {
                    System.out.println(newPlayer.getName() + " now wins " + win + " round(s), and loses " + loss + " round(s)." + "Your balance is $" + balance + ".");
                    getPercent();
                }
                System.out.println("");
                keyScanner();
                break;
            case "4":
                System.out.println("1,Please set up a player before any other option.");
                System.out.println("2,Only one player can play it at one time.");
                System.out.println("3,You will guess a random integer lucky number between 1 to 100(inclusive).");
                System.out.println("4,There are 3 chances in a round, and do not waste chance by inputing a number out of range. ");
                System.out.println("5,You will get $10 for rewarding any success guessing in 3 times.");
                System.out.println("6,If your guess number is within ±5 of the lucky number, you will win a round and get $1-$5 consolation prize.");
                keyScanner();
                //System.out.println("");
                break;
            case "5":
                System.exit(0);
                //System.out.print("test 5");
                break;
            default:
                System.out.println("Please select the options from 1 to 5, thank you!");
                keyScanner();
                break;
        }
    }

    public void getPercent()
    {
        if(loss == 0)
        {
            if(win != 0)
                System.out.println(" Your winning percentage is 100%!!!");
            else
                System.out.println(" The game has not been started!");
        }
        else
            System.out.print(" Your winning percentage is " + win * 1.0 / loss * 100 + "%");
    }

    public void gamePlay()
    {
        luckyNumber = new LuckyNumberGenerator();
        int targetNumber = luckyNumber.getTargetNumber();
        int round = 1;

        while(round <= 3)
        {   
            setGuessNumber();
            int guessNumber = getGuessNumber();
            if (round == 3)
            {
                if(guessNumber - targetNumber <= 5 && guessNumber - targetNumber >= -5 && guessNumber <= 100)
                {
                    win = win + 1;
                    consolationPrize = new LuckyNumberGenerator();
                    setPrize();
                    int conPrize = getPrize();
                    balance = balance + conPrize;
                    System.out.println("Congratulations! The lucky number is " + targetNumber + ". You win and get " + conPrize + " for consolation prize.");
                    break;
                }
                else
                {
                    balance = balance - 1;
                    if(balance < 0)
                       balance = 0;
                    loss = loss + 1;
                    System.out.println("Sorry, your guesses were wrong. You have lost the game and $1. The lucy number is " + targetNumber + ". Please try again and have a good luck!"); 
                    break;
                }                
            }
            if(guessNumber > 100)
            {
                System.out.println("The guess number should be between 1 to 100.");
                round ++;                
            }
            else
            {            
                if(guessNumber - targetNumber == 0)
                {
                    win = win + 1;
                    balance = balance + 10;
                    System.out.println("Your number is correct!. You win $10!");
                    break;
                }
                else
                {
                    if(guessNumber - targetNumber > 0)
                    {
                        System.out.print("Your number need to be lower. ");
                    }
                    else
                    {
                        System.out.print("Your number need to be higher.");
                    }
                }
                round ++;
            }
        }
     }
                   
    public void setGuessNumber()
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your guessing number: ");
        guessNumber = console.nextInt();
    }

    public int getGuessNumber()
    {
        return guessNumber;
    }
    
    public void setPrize()
    {
        prizeGenerator = new Random();
        prize = prizeGenerator.nextInt(5);
    }
    
    public int getPrize()
    {
        return prize;
    }
}
