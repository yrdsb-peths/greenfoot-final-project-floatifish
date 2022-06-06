import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("9577.wav");
    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    String facing ="right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        for(int i = 0;i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("imgages/idle_SpaceShip/idle" + i);
            idleRight[i].scale(100,100);
        }
        for(int i = 0;i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("imgages/idle_SpaceShip/idle" + i);
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        
        setImage(idleLeft[0]);
    }
    
    int imageIndex = 0;
    
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
           return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        { 
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else
        { 
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "Left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "Right";
        }
        eat();
        animateElephant();
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
