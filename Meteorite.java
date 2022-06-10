import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteoite here.
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Meteorite extends Actor
{
    public void act()
    {
        int x = getX();
        int y = getY() + 5;
        setLocation(x , y);
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()-10)
        {
            removeTouching(Meteorite.class);
        }
    }
}
