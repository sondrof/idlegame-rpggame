package affected.id;

public class Item {
  public enum ItemType {
    HELMET, CHESTPIECE, RING, WEAPON, SHIELD, POTION
  }

  private String name;
  private ItemType type;
  private int bonusHp, bonusMana, bonusAd, bonusAp, bonusArmor, bonusMr;

  public Item(String name, ItemType type, int bonusHp, int bonusMana, int bonusAd, int bonusAp, int bonusArmor, int bonusMr) {
    this.name = name;
    this.type = type;
    this.bonusHp = bonusHp;
    this.bonusMana = bonusMana;
    this.bonusAd = bonusAd;
    this.bonusAp = bonusAp;
    this.bonusArmor = bonusArmor;
    this.bonusMr = bonusMr;
  }

  public String getName() { return name; }
  public ItemType getType() { return type; }

  public int getBonusHp() { return bonusHp; }
  public int getBonusMana() { return bonusMana; }
  public int getBonusAd() { return bonusAd; }
  public int getBonusAp() { return bonusAp; }
  public int getBonusArmor() { return bonusArmor; }
  public int getBonusMr() { return bonusMr; }
}

