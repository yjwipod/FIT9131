import java.util.Scanner;

public class Game
{
    private Player newPlayer;
    private RandomNumberGenerator randomNumber;

    public Game()
    {
        newPlayer = new Player();
        randomNumber = new RandomNumberGenerator();
        playerOption();
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
        System.out.print("Choose an option :" );
    }

    public String typeInName()
    {
        System.out.print("Please enter your name: ");
        Scanner console = new Scanner(System.in);
        String typeIn = console.nextLine();
        return typeIn;
    }

    public void playerOption()
    {
        String key = "a";
        while (key.equals("5") == false)
        {
            updateDisplay();
            Scanner console = new Scanner(System.in);
            key = console.nextLine();
            switch (key)
            {
                case "1":
                newPlayer.setName(typeInName());
                break;
                case "2":
                gamePlay();
                break;
                case "3":
                getStatistics();
                break;
                case "4":
                displayHelp();
                break;
                case "5":
                System.out.println("Thank you for your playing! See you next time!");
                break;
                default:
                System.out.println("Please select the options from 1 to 5, thank you!");
                break;
            }
        }
    }

    public void getStatistics()
    {
        if(newPlayer.getName() == null)
        {
            System.out.println("Please press 1 to set a player first.");
        }
        else
        {
            System.out.print(newPlayer.getName()+ " now wins " + newPlayer.getWin() + " round(s), and loses " + newPlayer.getLoss ()+ " round(s)." + "Your balance is $" + newPlayer.getBalance() + ".");
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
    }

    public boolean isCharacterNumeric(char typeIn)
    {
        Character a = typeIn;
        if(a.isDigit(a))
            return true;
        else
            return false;
    }

    public boolean isStringNumeric(String typeIn)
    {
        int position = 0;

        while(position < typeIn.length())
        {
            if (isCharacterNumeric(typeIn.charAt(position)))
            {
                int length = typeIn.length();

                if (position == typeIn.length() - 1)
                {
                    return true;
                }
            }
            else 
            {
                break;
            }
            position ++;
        }
        return false;
    }

    public void gamePlay()
    {
        if(newPlayer.getName() == null)
        {
            System.out.println("Please press 1 to set a player first.");
        }
        else
        {
            //luckyNumber = new RandomNumberGenerator();
            //consolationPrize = new RandomNumberGenerator();
            int targetNumber = randomNumber.getTargetNumber();
            int round = 1;
            int guessNumber;
            while(round <= 3)
            {   
                newPlayer.setGuessNumber(tpyeInGuessNumber());
                if (isStringNumeric(newPlayer.getGuessNumber()))            
                {
                    guessNumber = newPlayer.getNum();
                    if (round == 3)
                    {
                        if(guessNumber - targetNumber <= 5 && guessNumber - targetNumber >= -5 && guessNumber <= 100)
                        {
                            newPlayer.setWin();
                            int conPrize = randomNumber.getPrize();
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
    }

    public String tpyeInGuessNumber()
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your guessing number: ");
        String guessNumber = console.nextLine();
        return guessNumber;
    }

    public String setName()
    {
        String name;
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = console.nextLine();
        System.out.println("Welcome and enjoy, " + name);
        return name;
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
}
