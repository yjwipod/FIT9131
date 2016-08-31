import java.util.Random;

public class LuckyNumberGenerator
{
    private Random generator;
    private int targetNumber;
        
    public LuckyNumberGenerator()
    {
        generator = new Random();
        targetNumber = generator.nextInt(100);
    }
    
    public void setTargetNumber()
    {
        targetNumber = generator.nextInt(100);
    }
    
    public int getTargetNumber()
    {
        return targetNumber;
    }        
}