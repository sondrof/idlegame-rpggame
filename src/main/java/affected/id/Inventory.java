package affected.id;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<Item> items;

  public Inventory() {
    items = new ArrayList<>();
  }

  public void addItem(Item item) {
    items.add(item);
    System.out.println(item.getName() + " added to inventory.");
  }

  public void removeItem(Item item) {
    items.remove(item);
    System.out.println(item.getName() + " removed from inventory.");
  }

  public List<Item> getItems() {
    return items;
  }

  public void printInventory() {
    System.out.println("Inventory:");
    for (Item item : items) {
      System.out.println("- " + item.getName());
    }
  }
}
