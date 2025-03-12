package affected.id;

public class PlayerLogic {
  private Player player;

  public PlayerLogic(Player player) {
    this.player = player;
  }

  public void gainXp(int amount) {
    player.setXp(player.getXp() + amount);
    checkLevelUp();
  }

  private void checkLevelUp() {
    int requiredXp = player.getLevel() * 100; // Example formula
    while (player.getXp() >= requiredXp) {
      player.setXp(player.getXp() - requiredXp);
      player.setLevel(player.getLevel() + 1);
      levelUpStats();
      requiredXp = player.getLevel() * 100;
    }
  }

  private void levelUpStats() {
    player.setHp(player.getHp() + 10);
    player.setArmor(player.getArmor() + 2);
    player.setMr(player.getMr() + 2);
    player.setAd(player.getAd() + 3);
    player.setAp(player.getAp() + 3);
    player.setDex(player.getDex() + 1);
    player.setCdr(player.getCdr() + 1);
    player.setLuck(player.getLuck() + 1);
    System.out.println("Leveled up! New level: " + player.getLevel());
  }
}
