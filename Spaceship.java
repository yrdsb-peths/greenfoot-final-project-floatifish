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

    GreenfootImage leftImage = new GreenfootImage("images/idle_SpaceShip_left/idle1.png");
    String isFacing ="up";
    SimpleTimer animationTimer = new SimpleTimer();

    public Spaceship()
    {

        animationTimer.mark();

    }

    int imageIndex = 0;

    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            isFacing = "left";
            move(-6);
            
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            isFacing = "right";
            move(6);
            
        }
        eat();
        destroy();

        if(isFacing.equals("left")){
            setImage(leftImage);
        }
        // else if(isFacing.equals("up")...
        
        
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
