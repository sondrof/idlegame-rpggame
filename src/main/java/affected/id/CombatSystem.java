package affected.id;

public class CombatSystem {
  public static void applyAdDamage(Entity target, int damage) {
    double reduction = 100.0 / (100 + target.getArmor());
    int finalDamage = (int) (damage * reduction);
    target.setHp(target.getHp() - finalDamage);
    System.out.println(target.getName() + " took " + finalDamage + " AD damage. HP left: " + target.getHp());
  }

  public static void applyApDamage(Entity target, int damage) {
    double reduction = 100.0 / (100 + target.getMr());
    int finalDamage = (int) (damage * reduction);
    target.setHp(target.getHp() - finalDamage);
    System.out.println(target.getName() + " took " + finalDamage + " AP damage. HP left: " + target.getHp());
  }

  public static void heal(Entity target, int amount) {
    target.setHp(target.getHp() + amount);
    System.out.println(target.getName() + " healed for " + amount + " HP.");
  }
}
