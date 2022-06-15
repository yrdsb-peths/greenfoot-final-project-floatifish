import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * it can introduce the gameplay
 * @author Eric Wang
 * @version 2022.6.1
 */
public class TitleScreen extends World
{  
    Label titleLabel = new Label ("Spaceship!",60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 800x450.
        super(800, 450, 1);
        addObject(titleLabel, 400, 70);
        prepare();
    }


    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare()
    {
        Label label = new Label("Use A and D to Move",30); 
        addObject(label,150,150);
        Label label2 = new Label("Press <S> to Start", 40);
        Label label3 = new Label("Catch the gas to get score!", 30);
        Label label4 = new Label("Do not touch the meteorite", 30);
        addObject(label2,400,380);
        addObject(label3,178,210);
        addObject(label4,180,270);
    }
}