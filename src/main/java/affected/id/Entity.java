package affected.id;

public interface Entity {
  String getName();
  int getHp();
  void setHp(int hp);
  int getArmor();
  int getMr();
  int getDex();

  // Add these methods:
  Hitbox getHitbox();
  Hurtbox getHurtbox();
}
