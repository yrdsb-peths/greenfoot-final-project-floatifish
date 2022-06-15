import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * to make meteorite move and make it random drop
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Meteorite extends Actor
{
    public void act()
    {
        int x = getX();
        int y = getY() + 10;
        setLocation(x , y);
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()-10)
        {
            //removeTouching(Meteorite.class);
            world.createMeteorite();
            world.removeObject(this);
        }
    }
}
