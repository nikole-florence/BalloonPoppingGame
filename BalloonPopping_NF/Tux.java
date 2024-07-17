import greenfoot.*;  
import greenfoot.World;

/**
 * Tux the penguin is trying to catch as many fish and pop as many balloons as he can.
 * 
 * @author Nikole Florence
 * @version 10/30/23
 */
public class Tux extends Actor
{
    private int balloonsPopped;
    private int fishCaught;
    private int toWin;
    //ints needed for the scoreboard and showText
    World world = getWorld();
    //getWorld() used so that I can use showText
    public void act()
    {
        checkKeyPress();
        lookOut();
        toWin();
        score();
        //methods declared for game
    }
    private void checkKeyPress()
    //Everything below is what controls the arrow keys
    {
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-1, getY());
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+1, getY());
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-1);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+1);
        }
    }
    
    private void lookOut()
    //if statements are used to run game rules
    {
        if(isTouching(balloon.class)){
            removeTouching(balloon.class);
            Greenfoot.playSound("pop.wav");
            balloonsPopped++;
            toWin = 50;
        }
        if(isTouching(fish.class)){
            removeTouching(fish.class);
            Greenfoot.playSound("pop.wav");
            fishCaught++;
            toWin = 15;
        }
        if(isTouching(bomb.class)){
            removeTouching(bomb.class);
            Greenfoot.playSound("au.wav");
            getWorld().showText("Game over", 350,300);
            Greenfoot.stop();
        }
    }
    private void score()
    //score is used to keep track of score in game
    {
        int score = balloonsPopped + 1;
        int score1 = fishCaught + 1;
        World world = getWorld();
        getWorld().showText("Balloons Popped: " + balloonsPopped, 350, 125);
        getWorld().showText("Fish Caught: " + fishCaught, 350, 155);
    }
    private void toWin() 
    //to win sets the rules for how to win
    {
        if(balloonsPopped == 50 || fishCaught == 15){
            Greenfoot.playSound("fanfare.wav");
            getWorld().showText("You won!", 350,300);
            Greenfoot.stop();
        }
    }
}
