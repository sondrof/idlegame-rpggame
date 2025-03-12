package affected.id;

public class Equipment {
  private Item helmet, chestpiece, ring1, ring2, leftHand, rightHand;

  public boolean equip(Item item) {
    switch (item.getType()) {
      case HELMET:
        helmet = item;
        break;
      case CHESTPIECE:
        chestpiece = item;
        break;
      case RING:
        if (ring1 == null) ring1 = item;
        else if (ring2 == null) ring2 = item;
        else return false; // Both ring slots full
        break;
      case WEAPON:
        if (rightHand == null) rightHand = item;
        else if (leftHand == null) leftHand = item; // Dual-wielding
        else return false; // Both hands full
        break;
      case SHIELD:
        if (leftHand == null) leftHand = item;
        else return false; // Left hand occupied
        break;
      default:
        return false;
    }
    System.out.println(item.getName() + " equipped.");
    return true;
  }

  public boolean unequip(Item item) {
    if (helmet == item) helmet = null;
    else if (chestpiece == item) chestpiece = null;
    else if (ring1 == item) ring1 = null;
    else if (ring2 == item) ring2 = null;
    else if (leftHand == item) leftHand = null;
    else if (rightHand == item) rightHand = null;
    else return false;
    System.out.println(item.getName() + " unequipped.");
    return true;
  }

  public void printEquipment() {
    System.out.println("Equipped Gear:");
    System.out.println("Helmet: " + (helmet != null ? helmet.getName() : "None"));
    System.out.println("Chestpiece: " + (chestpiece != null ? chestpiece.getName() : "None"));
    System.out.println("Ring 1: " + (ring1 != null ? ring1.getName() : "None"));
    System.out.println("Ring 2: " + (ring2 != null ? ring2.getName() : "None"));
    System.out.println("Left Hand: " + (leftHand != null ? leftHand.getName() : "None"));
    System.out.println("Right Hand: " + (rightHand != null ? rightHand.getName() : "None"));
  }
}
