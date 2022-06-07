import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteoite here.
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Meteoite extends Actor
{
    public void act()
    {
        int x = getX();
        int y = getY() + 5;
        setLocation(x , y);
    }
}
