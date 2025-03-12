package affected.id;

public class EnemyPos {
  private double x, y;
  private double velocityX, velocityY;

  public EnemyPos(double x, double y) {
    this.x = x;
    this.y = y;
    this.velocityX = 0;
    this.velocityY = 0;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void move() {
    this.x += velocityX;
    this.y += velocityY;
  }

  public void setVelocity(double velocityX, double velocityY) {
    this.velocityX = velocityX;
    this.velocityY = velocityY;
  }

  public void stopMovement() {
    this.velocityX = 0;
    this.velocityY = 0;
  }
}
