import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

/**/import java.util.ArrayList;

public class Player extends GameObject{

    private int speed;
    private ArrayList<float[]> trail = new ArrayList<>();
    private ArrayList<Rectangle> trailHitboxes;
    private String direction;
    public Rectangle hitbox;
    private int rectSize;
    private int prevX;
    private int prevY;


    public Player(double x, double y) {
        super(x, y, 18, 18, "assets/blueForward.png");
        prevX = -1;
        prevY = -1;
        speed = 200;
        // this.x = x;
        // this.y = y;
        this.hitbox = new Rectangle();
        this.rectSize = 5;
        trailHitboxes = new ArrayList<Rectangle>();
    }

    public void update() {
        // Always keep the hitbox synchronized with the player's position
        // hitbox.x = this.x;
        // hitbox.y = this.y;
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
        
  

        if(prevX != -1 && prevY != -1){

            trailHitboxes.add(new Rectangle(prevX, prevY, rectSize, rectSize)); 
        }
        prevX = (int)getX();
        prevY = (int) getY();


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
    public ArrayList<Rectangle> getTrail(){
        return trailHitboxes;
    }
    
}
