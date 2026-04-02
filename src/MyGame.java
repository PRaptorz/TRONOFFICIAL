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
    private int[][] colornums; 


    @Override
    public void create() {
        batch = new SpriteBatch();
        pencil = new ShapeRenderer();
        activeObjects = new ArrayList<GameObject>();
        background = new Texture("assets/TRON Background - small.png");

        p1 = new Player(300, 50);
        p2 = new Player2(300,500);

        activeObjects.add(p1);
        activeObjects.add(p2);

        colornums = new int [100][100];

        // int width = 800;
        // int height = 600;
        // // 0: empty, 1: player 1, 2: player 2
        // int[][] colornum = new int[width][height]; 

        // p2 = new Player2()

        // camera = new OrthographicCamera();
        // float height = 4000;
        // float width = 3000;
        // view = new FitViewport(width, height, camera);

       
        
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

        // for (int x = 0; x < width; x++) {
        //     for (int y = 0; y < height; y++) {
        //         if (grid[x][y] == 1) {
        //             // Draw Blue pixel/rectangle
        //         } else if (grid[x][y] == 2) {
        //             // Draw Orange pixel/rectangle
        //         }
        //     }
        // }

        batch.end();
        pencil.begin(ShapeRenderer.ShapeType.Filled);
        pencil.setColor(Color.BLUE);
        pencil.rect(100,200,15,15);
        pencil.end();

        // --- AP REVIEW: ARRAYLIST TRAVERSAL & REMOVAL ---
        // TODO 7: Write collision logic. 
        // You must iterate through the list to check if the player overlaps with enemies.
        // See the cheat sheet for the overlap method!
        // NOTE: If you are removing items from an ArrayList, how must you structure 
        // your for-loop to avoid skipping elements?

    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}