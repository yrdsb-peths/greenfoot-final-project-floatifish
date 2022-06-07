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
        addObject(titleLabel, 270, 97);
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
        Elephant elephant = new Elephant();
        addObject(elephant,482,96);
        Label label = new Label("Use 🠔 and 🠖 to Move",25);

        addObject(label,309,272);
        label.setLocation(343,278);
        label.setLocation(318,337);
        label.setLocation(364,327);
        label.setLocation(370,238);
        Label label2 = new Label("Press <space> to Start", 40);
        addObject(label2,278,314);
        label2.setLocation(317,357);
        label.setLocation(180,149);
        label.setLocation(141,170);
        label.setLocation(110,166);
        label.setLocation(133,158);
    }
}