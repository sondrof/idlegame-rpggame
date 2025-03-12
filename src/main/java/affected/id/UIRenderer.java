package affected.id;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UIRenderer {
  public static void drawHealthBar(GraphicsContext gc, double x, double y, int currentHp, int maxHp) {
    double width = 100; // Bar width
    double height = 10; // Bar height
    double healthPercentage = (double) currentHp / maxHp;
    double healthWidth = width * healthPercentage;

    // Background (gray bar)
    gc.setFill(Color.DARKGRAY);
    gc.fillRect(x, y, width, height);

    // Health (green bar)
    gc.setFill(Color.LIMEGREEN);
    gc.fillRect(x, y, healthWidth, height);

    // Border
    gc.setStroke(Color.BLACK);
    gc.strokeRect(x, y, width, height);
  }

  public static void drawManaBar(GraphicsContext gc, double x, double y, int currentMana, int maxMana) {
    double width = 100;
    double height = 10;
    double manaPercentage = (double) currentMana / maxMana;
    double manaWidth = width * manaPercentage;

    // Background
    gc.setFill(Color.DARKGRAY);
    gc.fillRect(x, y, width, height);

    // Mana (blue bar)
    gc.setFill(Color.CORNFLOWERBLUE);
    gc.fillRect(x, y, manaWidth, height);

    // Border
    gc.setStroke(Color.BLACK);
    gc.strokeRect(x, y, width, height);
  }

  public static void drawText(GraphicsContext gc, String text, double x, double y) {
    gc.setFill(Color.WHITE);
    gc.setFont(new Font("Arial", 14));
    gc.fillText(text, x, y);
  }
}
