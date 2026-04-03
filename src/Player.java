import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
/**/import java.util.ArrayList;

public class Player extends GameObject{

    private int speed;
    private final int COLORNUM = 1;
    private ArrayList<float[]> trail = new ArrayList<>();
    private String direction = "UP";


    public Player(double x, double y) {
        super(x, y, 18, 18, "assets/blueForward.png");
        speed = 200;
    }
    public void move(double deltaTime) {

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
           
            setX(getX()- speed * deltaTime);
            setImg("assets/blueLeft.png");
            direction = "LEFT";
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setX(getX()+ speed * deltaTime);
            setImg("assets/blueRight.png");
            direction = "RIGHT";
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            setY(getY()+ speed * deltaTime);
            setImg("assets/blueForward.png");
            direction = "UP";
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            setY(getY()- speed * deltaTime);
            setImg("assets/blueBackward.png");
            direction = "DOWN";
        }
        // trail.add(new float[]{(float) getX(),(float) getY()});

        //*Note to Adam" Tried adding code here to fix postioning issues the light trail had, if you can find the problem, fix the code,and add code to Player2 class */
        float trailX = (float) getX();
        float trailY = (float) getY();

        if (direction.equals("UP")){
            
            trailX += 18/2f -2;
            trailY += 0;
        }
        else if(direction.equals("DOWN")){
            trailX += 18;
            trailY += 18/2f -2;
        }
        else if (direction.equals("RIGHT")){
            trailX += 0;
            trailY += 18 / 2f - 2;
        }

        trail.add(new float[]{(float) getX(),(float) getY()});

        
        
        

        //boundaries
        if(getX()<0){
            System.out.println("Out of bounds");
            setImg("assets/Explosion.png");
        }
        if(getX()>750){
            System.out.println("Out of bounds");
            setImg("assets/Explosion.png");
        }
        if(getY()<0){
            System.out.println("Out of bounds");
            setImg("assets/Explosion.png"); 
        }
        if(getY()>735){
            System.out.println("Out of bounds");
            setImg("assets/Explosion.png"); 
        }
    }
    public ArrayList<float[]> getTrail(){
        return trail;
    }
    
}
