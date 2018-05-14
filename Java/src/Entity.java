import java.util.Comparator;

/**
 * This class implements the entity in the game.
 * @author Funtastic4
 * @version 1.0
 */
public abstract class Entity implements Comparator<Entity>, Interface {
  /**
   * This Construct abstract object entity with random position.
   */
  public Entity() {
    this.abscissa = Math.random() * Aquarium.getSize();
    this.ordinate = Math.random() * Aquarium.getSize();
    this.speed = 1;
  }

  /**
   * This Construct abstract object entity with specified position.
   * @param abscissa entity's axis
   * @param ordinate entity's ordinate
   */
  public Entity(double abscissa, double ordinate) {
    this.abscissa = abscissa;
    this.ordinate = ordinate;
    this.speed = 1;
  }

  @Override
  public abstract void move();

  @Override
  public int compare(Entity e1, Entity e2) {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Entity) {
      Entity newE = (Entity)obj;
      return (abscissa == newE.getX() && ordinate == newE.getY());
    }
    return false;
  }

  /**
   * This sets the Entity's axis.
   * @param abscissa the entity's axis
   */
  public void setX(double abscissa) {
    this.abscissa = abscissa;
  }

  /**
   * This sets the Entity's ordinate.
   * @param ordinate the entity's ordinate
   */
  public void setY(double ordinate) {
    this.ordinate = ordinate;
  }

  /**
  * This sets the Entity's speed.
  * @param speed the entity's speed
  */
  public void setSpeed(double speed) {
    this.speed = speed;
  }

  /**
   * This returns this' axis.
   * @return this' axis
   */
  public double getX() {
    return this.abscissa;
  }

  /**
   * This returns this' ordinate.
   * @return this' ordinate
   */
  public double getY() {
    return this.ordinate;
  }

  /**
  * This returns this' speed.
  * @return this' speed
  */
  public double getSpeed() {
    return this.speed;
  }

  protected double abscissa;
  protected double ordinate;
  protected double speed;
}