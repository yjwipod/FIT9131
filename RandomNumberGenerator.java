import java.util.Random;

public class RandomNumberGenerator
{
    private Random generator;
    private int targetNumber;
    private int prize;
        
    public RandomNumberGenerator()
    {
        generator = new Random();
        targetNumber = generator.nextInt(99) + 1;
        prize = generator.nextInt(4) + 1;
    }
    
    public void setTargetNumber()
    {
        targetNumber = generator.nextInt(99) + 1;
    }
    
    public int getTargetNumber()
    {
        return targetNumber;
    }        
    
    public void setPrize()
    {
        prize = generator.nextInt(4) + 1;
    }
    
    public int getPrize()
    {
        return prize;
    }

}