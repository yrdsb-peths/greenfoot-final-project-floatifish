import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author Eric Wang 
 * @version 2022.6.1
 */
public class Gasoline extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + 2 + speed;
        setLocation(x , y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()-10)
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
