import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObject{

    private int speed;
    private int colornum;


    public Player(double x, double y) {
        super(x, y, 18, 18, "assets/blueForward.png");
        speed = 200;
        colornum = 1;
    }
    public void move(double deltaTime) {

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
           
            setX(getX()- speed * deltaTime);
            setImg("assets/blueLeft.png");
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setX(getX()+ speed * deltaTime);
            setImg("assets/blueRight.png");
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            setY(getY()+ speed * deltaTime);
            setImg("assets/blueForward.png");
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            setY(getY()- speed * deltaTime);
            setImg("assets/blueBackward.png");
        }

        
        
        

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
    
}
