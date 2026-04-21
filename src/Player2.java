import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class Player2 extends GameObject {
    
        private int speed;
        private ArrayList<float[]> trail = new ArrayList<>();
        private ArrayList<Rectangle> trailHitboxes;
        public Rectangle hitbox;
        private int rectSize;
        private String direction;
        private int prevX;
        private int prevY;
        


    public Player2(double x, double y) {
        super(x, y, 18, 18, "assets/yellowBackward.png");
        // speed = 200;
        speed = 5;
        prevX = -1;
        prevY = -1;
        this.hitbox = new Rectangle();
        this.rectSize = 5;
        trailHitboxes = new ArrayList<Rectangle>();
    }
    public void move(double deltaTime) {

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            // setX(getX()- speed * deltaTime);
            setX(getX()- speed);
            setImg("assets/yellowLeft.png");
            direction = "LEFT";
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            // setX(getX()+ speed * deltaTime);
            setX(getX()+ speed);
            setImg("assets/yellowRight.png");
            direction = "RIGHT";
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.W)){
            // setY(getY()+ speed * deltaTime);
            setY(getY()+ speed);
            setImg("assets/yellowForward.png");
            direction = "UP";
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            // setY(getY()- speed * deltaTime);
            setY(getY()- speed);
            setImg("assets/yellowBackward.png");
            direction = "DOWN";
        }

        if(prevX == -1 || prevY == -1) {
            prevX = (int)getX();
            prevY = (int) getY();
        }
        if(prevX != getX() || prevY != getY()){

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
