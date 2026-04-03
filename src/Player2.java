import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player2 extends GameObject {
    
        private int speed;
        private int colornum;
        private ArrayList<float[]> trail = new ArrayList<>();


    public Player2(double x, double y) {
        super(x, y, 18, 18, "assets/yellowBackward.png");
        speed = 200;
        colornum = 2;
    }
    public void move(double deltaTime) {

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX()- speed * deltaTime);
            setImg("assets/yellowLeft.png");
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX()+ speed * deltaTime);
            setImg("assets/yellowRight.png");
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.W)){
            setY(getY()+ speed * deltaTime);
            setImg("assets/yellowForward.png");
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            setY(getY()- speed * deltaTime);
            setImg("assets/yellowBackward.png");
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
