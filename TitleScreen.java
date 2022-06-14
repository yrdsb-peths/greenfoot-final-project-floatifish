import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(titleLabel, 300, 70);
        prepare();
    }


    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare()
    {
        Label label = new Label("Use A and D to Move",25);

        addObject(label,150,150);
        Label label2 = new Label("Press <space> to Start", 40);
        Label label3 = new Label("Catch the gas to get score!", 25);
        Label label4 = new Label("Do not touch the meteorite", 25);
        addObject(label2,300,380);
        addObject(label3,178,210);
        addObject(label4,180,270);
    }
}