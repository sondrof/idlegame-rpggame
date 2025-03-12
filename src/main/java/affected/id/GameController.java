package affected.id;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class GameController {
  private Player player;
  private Enemy enemy;
  private final Set<KeyCode> pressedKeys = new HashSet<>();
  private long lastUpdate = 0;

  public GameController() {
    player = new Player("Hero", CharacterType.AD, 1, 0, 100, 10, 5, 20, 15, 10, 5, 3, 5, 400, 300);
    enemy = new Enemy("Goblin", 80, 5, 2, 3, 600, 300);
  }

  public void setupInput(Scene scene) {
    scene.setOnKeyPressed(event -> {
      pressedKeys.add(event.getCode());
      handleKeyPress(event);
    });

    scene.setOnKeyReleased(event -> {
      pressedKeys.remove(event.getCode());
      handleKeyRelease(event);
    });
  }

  public void update(long now) {
    if (lastUpdate == 0) {
      lastUpdate = now; // First frame, set baseline time
      return;
    }

    double deltaTime = (now - lastUpdate) / 1_000_000_000.0; // Convert nanoseconds to seconds
    lastUpdate = now;

    double speed = player.getSpeed() * deltaTime * 60; // Adjust movement for time passed

    // Determine movement direction
    double dx = 0, dy = 0;

    if (pressedKeys.contains(KeyCode.W)) dy -= 1;
    if (pressedKeys.contains(KeyCode.S)) dy += 1;
    if (pressedKeys.contains(KeyCode.A)) dx -= 1;
    if (pressedKeys.contains(KeyCode.D)) dx += 1;

    // Normalize diagonal movement
    double length = Math.sqrt(dx * dx + dy * dy);
    if (length > 0) {
      dx /= length;
      dy /= length;
    }

    // Apply movement
    player.updatePosition(player.getPosition().getX() + dx * speed,
        player.getPosition().getY() + dy * speed);
  }


  public void handleKeyPress(KeyEvent event) {
    pressedKeys.add(event.getCode());
  }

  public void handleKeyRelease(KeyEvent event) {
    pressedKeys.remove(event.getCode());
  }

  public Player getPlayer() {
    return player;
  }

  public Enemy getEnemy() {
    return enemy;
  }

  public void testInventorySystem() {
    Item sword = new Item("Iron Sword", Item.ItemType.WEAPON, 0, 0, 10, 0, 0, 0);
    Item shield = new Item("Wooden Shield", Item.ItemType.SHIELD, 5, 0, 0, 0, 5, 2);
    Item ring = new Item("Ring of Luck", Item.ItemType.RING, 0, 10, 0, 0, 0, 0);

    player.getInventory().addItem(sword);
    player.getInventory().addItem(shield);
    player.getInventory().addItem(ring);

    player.getInventory().printInventory();

    player.getEquipment().equip(sword);
    player.getEquipment().equip(shield);
    player.getEquipment().equip(ring);

    player.getEquipment().printEquipment();
  }
}
