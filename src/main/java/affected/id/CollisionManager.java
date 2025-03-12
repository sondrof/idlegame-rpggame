package affected.id;

import java.util.List;

public class CollisionManager {

  public static boolean checkCollision(Hitbox hb1, Hitbox hb2) {
    return hb1.getX() < hb2.getX() + hb2.getWidth() &&
        hb1.getX() + hb1.getWidth() > hb2.getX() &&
        hb1.getY() < hb2.getY() + hb2.getHeight() &&
        hb1.getY() + hb1.getHeight() > hb2.getY();
  }

  public static boolean checkHit(Hitbox hitbox, Hurtbox hurtbox) {
    return checkCollision(hitbox, new Hitbox(hurtbox.getX(), hurtbox.getY(), hurtbox.getWidth(), hurtbox.getHeight()));
  }

  public static void checkCollisions(List<Entity> entities) {
    for (int i = 0; i < entities.size(); i++) {
      for (int j = i + 1; j < entities.size(); j++) {
        Entity e1 = entities.get(i);
        Entity e2 = entities.get(j);

        if (checkCollision(e1.getHitbox(), e2.getHitbox())) {
          System.out.println(e1.getName() + " collided with " + e2.getName());
        }

        if (checkHit(e1.getHitbox(), e2.getHurtbox())) {
          System.out.println(e1.getName() + " hit " + e2.getName());
        }
      }
    }
  }
}
