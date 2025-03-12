package affected.id;

public class Enemy implements Entity {
  private String name;
  private int hp;
  private int armor;
  private int mr;
  private int dex;
  private EnemyPos position;
  private Hitbox hitbox;
  private Hurtbox hurtbox;

  public Enemy(String name, int hp, int armor, int mr, int dex, double startX, double startY) {
    this.name = name;
    this.hp = hp;
    this.armor = armor;
    this.mr = mr;
    this.dex = dex;
    this.hitbox = new Hitbox(startX, startY, 32, 32);
    this.hurtbox = new Hurtbox(startX, startY, 32, 32);
    this.position = new EnemyPos(startX, startY);
  }

  public void updatePosition(double x, double y) {
    position.setX(x);
    position.setY(y);
    hitbox.updatePosition(x, y);
    hurtbox.updatePosition(x, y);
  }

  @Override
  public Hitbox getHitbox() { return hitbox; }

  @Override
  public Hurtbox getHurtbox() { return hurtbox; }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHp() {
    return hp;
  }

  @Override
  public void setHp(int hp) {
    this.hp = Math.max(hp, 0);
  }

  @Override
  public int getArmor() {
    return armor;
  }

  @Override
  public int getMr() {
    return mr;
  }

  @Override
  public int getDex() {
    return dex;
  }

  public EnemyPos getPosition() {
    return position;
  }
}
