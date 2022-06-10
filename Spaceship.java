import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Spaceship extends Actor
{
    GreenfootSound spaceshipSound = new GreenfootSound("water drop.mp3");
    GreenfootSound backgroundSound = new GreenfootSound("background music.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[2];
    GreenfootImage[] idleLeft = new GreenfootImage[2];
    String facing ="up";
    SimpleTimer animationTimer = new SimpleTimer();
    public Spaceship()
    {
        for(int i = 0;i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/idle_SpaceShip_right/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        for(int i = 0;i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/idle_SpaceShip_left/idle" + i + ".png");
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        
        setImage(idleLeft[0]);
    }
    
    int imageIndex = 0;
    
    public void animateSpaceship()
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
            move(-6);
            facing = "Left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(6);
            facing = "Right";
        }
        eat();
        destroy();
        animateSpaceship();
    }

    public void eat()
    {
        if(isTouching(Gasoline.class))
        { 
            removeTouching(Gasoline.class);
            MyWorld world = (MyWorld)getWorld();
            world.createGasoline();
            world.increaseScore();
            spaceshipSound.play();
        }
    }
    public void destroy()
    {
        if(isTouching(Meteorite.class))
        {
            removeTouching(Meteorite.class);
            MyWorld world = (MyWorld) getWorld();
            world.createMeteorite();
            world.gameOver();
        }
    }
}
