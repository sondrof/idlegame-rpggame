package affected.id;

public class Player implements Entity {
  private String name;
  private CharacterType characterType;
  private int level, xp, hp, armor, mr, ad, ap, dex, cdr, luck, speed;
  private int mana;
  private int maxMana;
  private PlayerPos position;

  private Hitbox hitbox;
  private Hurtbox hurtbox;

  private Inventory inventory;
  private Equipment equipment;


  public Player(String name, CharacterType characterType, int level, int xp, int hp, int armor, int mr, int ad, int ap, int dex, int cdr, int luck, int speed, double startX, double startY) {
    setName(name);
    setCharacterType(characterType);
    setLevel(level);
    setXp(xp);
    setHp(hp);
    setArmor(armor);
    setMr(mr);
    setAd(ad);
    setAp(ap);
    setDex(dex);
    setCdr(cdr);
    setLuck(luck);
    setSpeed(speed);
    this.hitbox = new Hitbox(startX, startY, 32, 32);
    this.hurtbox = new Hurtbox(startX, startY, 32, 32);
    this.mana = 100;
    this.maxMana = 100;
    setPosition(new PlayerPos(startX, startY));// Using setter for position

    inventory = new Inventory();
    equipment = new Equipment();
  }

  public Inventory getInventory() {
    return inventory;
  }

  public Equipment getEquipment() {
    return equipment;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setMana(int mana) {
    this.mana = Math.max(0, Math.min(mana, maxMana)); // Prevent overfilling
  }

  public int getMaxMana() {
    return maxMana;
  }

  public int getMana() {
    return mana;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CharacterType getCharacterType() {
    return characterType;
  }

  public void setCharacterType(CharacterType characterType) {
    this.characterType = characterType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  @Override
  public int getHp() {
    return hp;
  }

  @Override
  public void setHp(int hp) {
    this.hp = Math.max(hp, 0); // Prevent negative HP
  }

  @Override
  public int getArmor() {
    return armor;
  }

  public void setArmor(int armor) {
    this.armor = armor;
  }

  @Override
  public int getMr() {
    return mr;
  }

  public void setMr(int mr) {
    this.mr = mr;
  }

  public int getAd() {
    return ad;
  }

  public void setAd(int ad) {
    this.ad = ad;
  }

  public int getAp() {
    return ap;
  }

  public void setAp(int ap) {
    this.ap = ap;
  }

  public int getDex() {
    return dex;
  }

  public void setDex(int dex) {
    this.dex = dex;
  }

  public int getCdr() {
    return cdr;
  }

  public void setCdr(int cdr) {
    this.cdr = cdr;
  }

  public int getLuck() {
    return luck;
  }

  public void setLuck(int luck) {
    this.luck = luck;
  }

  public PlayerPos getPosition() {
    return position;
  }


  public void setPosition(PlayerPos position) {
    this.position = position;
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
}
