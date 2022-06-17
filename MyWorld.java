import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * create MyWorld.
 * 
 * @Eric wang 
 * @2022.6.1
 */
public class MyWorld extends World
{
    //define initial variables
    boolean gameOver = false;
    GreenfootSound backgroundSound = new GreenfootSound("background music.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    public int score = 0;
    Label scoreLabel;
    int level = 1;

    public MyWorld()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 

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
        gameOver = true;
        backgroundSound.stop();
        Label gameOverLabel = new Label("Game Over" ,100);
        addObject(gameOverLabel, 400, 200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        //each 5 point increase one speed
        if(score % 5 == 0)
        {
            level +=1;
        }
    }

    public void createGasoline()
    {
        if(gameOver) {
            return;
        }
        Gasoline gasoline = new Gasoline();
        gasoline.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(gasoline ,x ,y);
    }

    public void createMeteorite()
    {
        if(gameOver)
        {
            return;
        }
        Meteorite meteorite = new Meteorite();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(meteorite ,x ,y);
    }
}
