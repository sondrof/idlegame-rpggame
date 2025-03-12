package affected.id;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Hurtbox {
  private double x, y, width, height;

  public Hurtbox(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void updatePosition(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void render(GraphicsContext gc, double cameraX, double cameraY) {
    gc.setStroke(Color.BLUE);
    gc.strokeRect(x - cameraX, y - cameraY, width, height);
  }


  public double getX() { return x; }
  public double getY() { return y; }
  public double getWidth() { return width; }
  public double getHeight() { return height; }
}
