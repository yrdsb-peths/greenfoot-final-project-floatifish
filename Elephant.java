import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("9577.wav");
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Banana.class))
        {
            removeTouching(Banana.class);
            MyWorld world = (MyWorld)getWorld();
            world.createBanana();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
