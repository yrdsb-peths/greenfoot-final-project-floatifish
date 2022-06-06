import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author Eric Wang 
 * @version 2022.6.1
 */
public class Banana extends Actor
{
    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + 2;
        setLocation(x , y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()-10)
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
