import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    private final static double CANNON_BALL_VELOCITY = 1500.0;
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    
        // Ad yopublic void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            Vector2D cannonToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
            
            allignWithVector(cannonToMouse);
            
            if (Greenfoot.mouseClicked(null)){
                cannonToMouse.normalize();
                cannonToMouse = Vector2D.multiply(cannonToMouse, CANNON_BALL_VELOCITY);
                
                CannonBall ball = new CannonBall();
                ball.setVelocity(cannonToMouse);
                getWorld().addObject(ball, getX(), getY());
                Greenfoot.playSound("cannonSound.wav");
                
        
            }
        }
        
    
    }
    
    public void allignWithVector(Vector2D v)
    {
        double adjacent = v.getX();
        double opposite = v.getY();
        
        double angleRadians = Math.atan2(opposite, adjacent);
        double angleDegrees = Math.toDegrees(angleRadians);
        
        setRotation((int) angleDegrees);
    }
}
    

