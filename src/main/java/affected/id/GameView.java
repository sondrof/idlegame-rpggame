package affected.id;


import affected.id.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class GameView extends Application {
  private GameController gameController;
  private Canvas canvas;
  private GraphicsContext gc;
  private Image playerImage, enemyImage;
  private boolean debugMode = false;

  private double cameraX = 0;
  private double cameraY = 0;
  private double cameraLerpFactor = 0.1;


  @Override
  public void start(Stage stage) {
    gameController = new GameController();

    canvas = new Canvas(800, 600);
    gc = canvas.getGraphicsContext2D();

    loadImages();

    StackPane root = new StackPane(canvas);
    Scene scene = new Scene(root, 800, 600);

    // Setup input for GameController (WASD)
    gameController.setupInput(scene);

    // Add Debug Mode Toggle Without Overwriting Movement
    scene.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.F1) {
        debugMode = !debugMode;
        System.out.println("Debug Mode: " + (debugMode ? "ON" : "OFF"));
      }
      // Pass other key events to GameController
      gameController.handleKeyPress(event);
    });

    scene.setOnKeyReleased(event -> gameController.handleKeyRelease(event));

    new AnimationTimer() {
      @Override
      public void handle(long now) {
        gameController.update(now); // Ensure GameController updates with delta time
        render();
      }
    }.start();

    stage.setScene(scene);
    stage.setTitle("RPG Game");
    stage.show();
  }


  private void loadImages() {
    playerImage = new Image("player.png");
    enemyImage = new Image("enemy.png");
  }

  private void render() {
    gc.clearRect(0, 0, 800, 600);

    // Target camera position (centered on player)
    double targetX = gameController.getPlayer().getPosition().getX() - 400;
    double targetY = gameController.getPlayer().getPosition().getY() - 300;

    // Smoothly move camera towards target using lerp
    cameraX += (targetX - cameraX) * cameraLerpFactor;
    cameraY += (targetY - cameraY) * cameraLerpFactor;

    // Render player relative to the camera
    gc.drawImage(playerImage, gameController.getPlayer().getPosition().getX() - cameraX,
        gameController.getPlayer().getPosition().getY() - cameraY);

    // Render enemy relative to the camera
    gc.drawImage(enemyImage, gameController.getEnemy().getPosition().getX() - cameraX,
        gameController.getEnemy().getPosition().getY() - cameraY);

    // Debug Mode (Show Hitboxes)
    if (debugMode) {
      gameController.getPlayer().getHitbox().render(gc, cameraX, cameraY);
      gameController.getEnemy().getHurtbox().render(gc, cameraX, cameraY);
    }
  }


  public static void main(String[] args) {
    launch(args);
  }
}