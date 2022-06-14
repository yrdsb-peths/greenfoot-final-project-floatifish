import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Eric wang 
 * @2022.6.1
 */
public class MyWorld extends World
{
    GreenfootSound backgroundSound = new GreenfootSound("background music.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
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
        
        Spaceship spaceship = new Spaceship();
        addObject(spaceship, 350, 350);
        
        scoreLabel = new Label(0 , 80);
        addObject(scoreLabel,50 ,50 );
        backgroundSound.play();
        createGasoline();
        createMeteorite();
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
    
    public void createGasoline()
    {
        Gasoline gasoline = new Gasoline();
        gasoline.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(gasoline ,x ,y);
    }
    
    public void createMeteorite()
    {
        Meteorite meteorite = new Meteorite();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(meteorite ,x ,y);
    }
}
