import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Eric wang 
 * @2022.6.1
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Elephant elephant = new Elephant();
        addObject(elephant, 350, 350);
        
        scoreLabel = new Label(0 , 80);
        addObject(scoreLabel,50 ,50 );
        createBanana();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over" ,100);
        addObject(gameOverLabel, 300, 200);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
    }
    public void createBanana()
    {
        Banana banana = new Banana();
        banana.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(banana ,x ,y);
    }
    
    public void createMeteoite()
    {
        Meteoite meteoite = new Meteoite();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(meteoite ,x ,y);
    }
}
