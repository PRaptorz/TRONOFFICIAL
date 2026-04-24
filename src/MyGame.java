import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
//
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGame extends ApplicationAdapter {
    Texture backgroundTexture;
    Texture bucketTexture;
    Texture dropTexture;
    Sound dropSound;
    Music music;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    Sprite bucketSprite;
    Vector2 touchPos;
    ArrayList<Sprite> dropSprites;
    float dropTimer;
    Rectangle bucketRectangle;
    Rectangle dropRectangle;
    
    private SpriteBatch batch;
    private ShapeRenderer pencil;
    private ArrayList<GameObject> activeObjects;
    private Texture background;
    private OrthographicCamera camera;
    private FitViewport view;
    private Player p1;
    private Player2 p2;
    // private int[][] colornums; 


    @Override
    public void create() {
        batch = new SpriteBatch();
        pencil = new ShapeRenderer();
        activeObjects = new ArrayList<GameObject>();
        background = new Texture("assets/TRON Background - small.png");
        // Array List <Rectangle> blueHitboxes;

        p1 = new Player(300, 50);
        p2 = new Player2(300,500);

        activeObjects.add(p1);
        activeObjects.add(p2);
  
    }

   

    //render() is the game loop, called approx 60 times per second
    @Override
    public void render() {
        // Boilerplate: Clear the screen to black each frame
        // view.apply();
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // --- AP REVIEW: CASTING ---
        // Gdx.graphics.getDeltaTime() returns a float. 
        // We cast it to a double to stay strictly within the AP CSA Java standards.
        double deltaTime = (double) Gdx.graphics.getDeltaTime();

        // For each object, call its move() method.
        for(GameObject obj : activeObjects){
            obj.move(deltaTime);
        }



        
        //Note: Anything drawn must be between .begin() and .end()
        batch.begin();
        
        batch.draw(background, 0, 0);

        for(GameObject obj : activeObjects){
            obj.draw(batch);
        }

        batch.end();

        //LIGHT TRAIL CODE: postion has issues
        pencil.begin(ShapeRenderer.ShapeType.Filled);
        for(Rectangle r : p1.getTrail()){
            pencil.setColor(Color.BLUE);
            pencil.rect(r.getX(),r.getY(), r.getWidth(),r.getHeight());
            
        }
        for(Rectangle r : p2.getTrail()){
            pencil.setColor(Color.YELLOW);
            pencil.rect(r.getX(),r.getY(), r.getWidth(),r.getHeight());
        }


        
        
        // pencil.rect(100,200,5,5);
        pencil.end();

        //light trail collisions - check if each player hits opponent's trail
        for(Rectangle r : p2.getTrail()){
            if(p1.getHitBox().overlaps(r)){
                System.out.println("Player 1 hit Player 2's trail!");
                gameOver();
            }
        }
        for(Rectangle r : p1.getTrail()){
            if(p2.getHitBox().overlaps(r)){
                System.out.println("Player 2 hit Player 1's trail!");
                gameOver();
            }
        }
        
        //check if players hit their own trail
        for(Rectangle r : p1.getTrail()){
            if(p1.getHitBox().overlaps(r)){
                System.out.println("Player 1 hit their own trail!");
                gameOver();
            }
        }
        for(Rectangle r : p2.getTrail()){
            if(p2.getHitBox().overlaps(r)){
                System.out.println("Player 2 hit their own trail!");
                gameOver();
            }
        }
    }

    public void resetGame() {

        //to be filled by @atom-wakelin

        if (Gdx.isKeyPressed(Input.Keys.Q) == true) {


        p1 = null;
        p2 = null;

        p1 = new Player(300, 50);
        p2 = new Player2(300,500);

        }
    }

    public void gameOver(){


        //TODO: @atom-wakelim will finish this method (I use Arch BTW)



        System.out.println("Anirudha");
    }




    
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}