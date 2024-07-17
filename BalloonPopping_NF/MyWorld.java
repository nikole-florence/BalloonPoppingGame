import greenfoot.*;  

/**
 * The world takes place on a sheet of ice.
 * 
 * @author Nikole Florence 
 * @version 10/30/23
 */
public class MyWorld extends World
//the ints are used to do the width and height of the world 
//the string is for the showText variable
//String explains how to play game as well

{
    private boolean spawn = false;
    private final static int Width = 700;
    private final static int Height = 500;
    private final static int Pixel = 1;
    
    public int i;
    public int locX1 = 350;
    public int locY1 = 125;
    public int locX2;
    public int locY2;
    
    private String text = "Use arrows to move Tux the penguin. \nCatch fish and pop balloons to win. \nMake sure to avoid bombs. \nPress run and then s to start.";
    public MyWorld()
    //ints are used to do the size of the world
    //private string is used for showText
    {   
        super(Width, Height, Pixel);
        showText(text, locX1, locY1);
    }
    
    public void act()
    //if s is pressed the game starts
    //Tux is spawned and the rest of the game is set up as well
    {
        if(Greenfoot.isKeyDown("s") && spawn == false)
        {
            spawn = true;
            prepare();
            showText("", locX1, locX2);
        }
    }
    
     public void prepare() 
     //prepare calls all the methods it needs for the game
    { 
        setBackground(new GreenfootImage("bluerock.jpg"));
        addBalloons();
        addFish();
        addRandomBomb();
        addTux();
    } 
    private void addBalloons()
    //this for loop adds the balloons
    {
        for (int i = 0; i < 85; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new balloon(), x, y);
        }
    }
    private void addFish()
    //this for loop adds the fish
    {
      for (int i = 0; i < 20; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new fish(), x, y);
        }
    }
    private void addRandomBomb()
    //this for loop adds the bombs but also makes sure they arent on Tux
    {
        for (int i = 0; i < 15; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - locY1);
            addObject(new bomb(), x, y);
        }
    }
    private void addTux()
    //this for loop adds Tux in the bottom right of the World
    
    {
        for (int i = 0; i < 1; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int locX1 = 650;
            int locY1 = 450;
            addObject(new Tux(), locX1, locY1);
        }

    } 
    
    
    
    
   
}
