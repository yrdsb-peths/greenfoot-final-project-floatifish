import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * to make Spaceship move,eat gasoline and be destroyed
 * 
 * @author Eric Wang
 * @version 2022.6.1
 */
public class Spaceship extends Actor
{
    GreenfootSound spaceshipSound = new GreenfootSound("water drop.mp3");
    GreenfootSound explosion = new GreenfootSound("explosion.mp3");

    GreenfootImage leftImage = new GreenfootImage("images/idle_SpaceShip_left/idle1.png");
    GreenfootImage rightImage = new GreenfootImage("images/idle_SpaceShip_right/idle1.png");
    GreenfootImage upImage = new GreenfootImage("images/idle_SpaceShip_right/idle0.png");
    String isFacing ="up";
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootImage explode1 =new GreenfootImage("images/explode/explode0.png");
    GreenfootImage explode2 =new GreenfootImage("images/explode/explode1.png");
    GreenfootImage explode3 =new GreenfootImage("images/explode/explode2.png");
    GreenfootImage explode4 =new GreenfootImage("images/explode/explode3.png");
    GreenfootImage explode5 =new GreenfootImage("images/explode/explode4.png");
    public Spaceship()
    {

        animationTimer.mark();

    }

    int imageIndex = 0;

    public void act()
    {
        if(Greenfoot.isKeyDown("A"))
        {
            isFacing = "left";
            move(-6);
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            isFacing = "right";
            move(6);
        }
        else{
            isFacing = "up";
        }
        eat();
        destroy(); 
        
        if(isFacing.equals("left")){
            setImage(leftImage);
        }
        else if(isFacing.equals("right")){
            setImage(rightImage);
        }
        else if(isFacing.equals("up"))
        {
            setImage(upImage);
        }
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
            setImage(explode1);
            //setImage(explode2);
            //setImage(explode3);
            //setImage(explode4);
            //setImage(explode5);
            removeTouching(Meteorite.class);
            MyWorld world = (MyWorld) getWorld();
            world.createMeteorite();
            world.gameOver();
            world.removeObject(this);
            explosion.play();
        }
    }
}
