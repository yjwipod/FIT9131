import java.util.Scanner;
import java.util.Random;

public class Game
{
    private Player newPlayer;
    private String key;
    private LuckyNumberGenerator luckyNumber;
    private LuckyNumberGenerator consolationPrize;
    private Random prizeGenerator;
    private int prize;
    
    public Game()
    {
        newPlayer = new Player();
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
                keyScanner();
                break;
            case "2":
                checkOpt();
                gamePlay();
                keyScanner();
                break;
            case "3":
                checkOpt();
                getStatistics();
                keyScanner();
                break;
            case "4":
                displayHelp();
                keyScanner();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Please select the options from 1 to 5, thank you!");
                keyScanner();
                break;
        }
    }

    public void checkOpt()
    {
        if (newPlayer.getName() == null)
        { 
            System.out.println("Please press 1 to set a player first.");
            keyScanner(); 
        }
    }
    
    public void getStatistics()
    {
        System.out.print(newPlayer.getName() + " now wins " + newPlayer.getWin() + " round(s), and loses " + newPlayer.getLoss ()+ " round(s)." + "Your balance is $" + newPlayer.getBalance() + ".");
        if(newPlayer.getLoss() == 0)
        {
            if(newPlayer.getWin() != 0)
                System.out.println(" Your winning percentage is 100%!!!");
            else
                System.out.println(" The game has not been started!");
        }
        else
            System.out.println(" Your winning percentage is " + newPlayer.getWin() * 1.0 / (newPlayer.getLoss() + newPlayer.getWin()) * 100 + "%");
    }
    
    public boolean isCharacterNumeric(char typeIn)
    {
        boolean checkNum;
        Character a = typeIn;
        if(a.isDigit(a))
            checkNum = true;
        else
            checkNum = false;
        return checkNum;
    }

    public boolean isStringNumeric(String typeIn)
    {
        boolean checkStrNum = true;
        int position = 0;
        
        while(position < typeIn.length())
        {
            if (isCharacterNumeric(typeIn.charAt(position)))
                {
                    position ++;
                    if (position == typeIn.length() - 1)
                        checkStrNum = true; 
                }
            else 
                {
                    checkStrNum = false;
                    break;
                }
        }
        return checkStrNum;        
    }
    
    public void gamePlay()
    {
        luckyNumber = new LuckyNumberGenerator();
        int targetNumber = luckyNumber.getTargetNumber();
        int round = 1;
        int guessNumber;
        while(round <= 3)
        {   
            newPlayer.setGuessNumber();
            if (isStringNumeric(newPlayer.getGuessNumber()))            
                {
                    guessNumber = newPlayer.getNum();
                    if (round == 3)
                    {
                        if(guessNumber - targetNumber <= 5 && guessNumber - targetNumber >= -5 && guessNumber <= 100)
                        {
                            newPlayer.setWin();
                            consolationPrize = new LuckyNumberGenerator();
                            setPrize();
                            int conPrize = getPrize();
                            newPlayer.setBalance(conPrize);
                            System.out.println("Congratulations! The lucky number is " + targetNumber + ". Your win and get " + conPrize + " for consolation prize.");
                            break;
                        }
                        else
                        {
                            newPlayer.setLoss();
                            System.out.println("Sorry, your guesses were wrong. You have lost the game and $1. The lucy number is " + targetNumber + ". Please try again and have a good luck!"); 
                            newPlayer.setBalance(-1);
                            if(newPlayer.getBalance() < 0)
                               newPlayer.resetBalance();
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
                            newPlayer.setWin();
                            newPlayer.setBalance(10);
                            System.out.println("Your number is correct! You win $10!");
                            break;
                        }
                        else
                        {
                            if(guessNumber - targetNumber > 0)
                            {
                                System.out.println("Your number need to be lower. ");
                            }
                            else
                            {
                                System.out.println("Your number need to be higher.");
                            }
                        }
                    }
                }
                
            else                
                {
                    if(round == 3)
                    {
                        System.out.println("You have not entered an integer number in the last round, and the game is over.");
                    }
                    else
                    {
                    System.out.println("Please enter an integer number bewteen 1 to 100");
                    }
                }   
                
            round ++;
        }
    }
            
    
    public void displayHelp()
    {
        System.out.println("1,Please set up a player before any other option.");
        System.out.println("2,Only one player can play it at one time.");
        System.out.println("3,You will guess a random integer lucky number between 1 to 100(inclusive).");
        System.out.println("4,There are 3 chances in a round, and do not waste chance by inputing a number out of range. ");
        System.out.println("5,You will get $10 for rewarding any success guessing in 3 times.");
        System.out.println("6,If your guess number is within ±5 of the lucky number, you will win a round and get $1-$5 consolation prize.");
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
