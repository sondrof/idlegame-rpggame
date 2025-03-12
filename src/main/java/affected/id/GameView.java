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
    gameController.testInventorySystem();

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

    // Camera offset for positioning

    double targetX = gameController.getPlayer().getPosition().getX() - 400;
    double targetY = gameController.getPlayer().getPosition().getY() - 300;

    cameraX += (targetX - cameraX) * cameraLerpFactor;
    cameraY += (targetY - cameraY) * cameraLerpFactor;

    // Render background (if added later)
    // gc.drawImage(background, -cameraX, -cameraY);

    // Render entities
    gc.drawImage(playerImage, gameController.getPlayer().getPosition().getX() - cameraX,
        gameController.getPlayer().getPosition().getY() - cameraY);

    gc.drawImage(enemyImage, gameController.getEnemy().getPosition().getX() - cameraX,
        gameController.getEnemy().getPosition().getY() - cameraY);

    // Render UI Elements (Health & Mana Bars)
    UIRenderer.drawHealthBar(gc, gameController.getPlayer().getPosition().getX() - cameraX - 20,
        gameController.getPlayer().getPosition().getY() - cameraY - 20,
        gameController.getPlayer().getHp(), 100);

    UIRenderer.drawManaBar(gc, gameController.getPlayer().getPosition().getX() - cameraX - 20,
        gameController.getPlayer().getPosition().getY() - cameraY - 10,
        gameController.getPlayer().getMana(), 100);

    UIRenderer.drawHealthBar(gc, gameController.getEnemy().getPosition().getX() - cameraX - 20,
        gameController.getEnemy().getPosition().getY() - cameraY - 20,
        gameController.getEnemy().getHp(), 80);

    // Debug Mode (Hitboxes)
    if (debugMode) {
      gameController.getPlayer().getHitbox().render(gc, cameraX, cameraY);
      gameController.getEnemy().getHurtbox().render(gc, cameraX, cameraY);
    }
  }


  public static void main(String[] args) {
    launch(args);
  }
}