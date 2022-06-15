import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * to make gasoline move and make it random drop.
 * 
 * @author Eric Wang 
 * @version 2022.6.1
 */
public class Gasoline extends Actor
{
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + 2 + speed;
        //it can make gasoline speed up when it get more marks
        setLocation(x , y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()-10)
        {
            world.gameOver();
            world.removeObject(this);
            gameOverSound.play();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
