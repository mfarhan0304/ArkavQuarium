/**
* This class implements the Fish and it inherits Entity class.
* @author Funtastic4
* @version 1.0
*/
public abstract class Fish extends Entity {
  /**
   * This constructs Fish object by calling its parent's constructor,
   * set the time to zero, set the radius to 2, set the isFull to false,
   * set the destination to random position, and set the direction to right/left.
   */
  public Fish() {
    super();
    setTime(0);
    radius = Aquarium.getSize() * 2 / 100;
    setIsFull(true);
    setDest(Math.random() * Aquarium.getSize(), Math.random() * Aquarium.getSize());
    int dir = (int)(Math.random() * 2);
    if (dir == 0) {
      setDirection(Direction.RIGHT);
    } else {
      setDirection(Direction.LEFT);
    }
  }

  /**
   * This constructs Fish object and set the position of x and y to the input parameter.
   * @param x the Fish's axis
   * @param y the Fish's ordinate
   */
  public Fish(double x, double y) {
    super(x, y);
    setTime(0);
    radius = Aquarium.getSize() * 2 / 100;
    setIsFull(true);
    setDest(Math.random() * Aquarium.getSize(), Math.random() * Aquarium.getSize());
    int dir = (int)(Math.random() * 2);
    if (dir == 0) {
      setDirection(Direction.RIGHT);
    } else {
      setDirection(Direction.LEFT);
    }
  }

  /**
   * Override move method from Entity class.
   * It implements the food's move
   */
  @Override
  public void move() {
    double destX = Math.abs(getDestX());
    double currX = Math.abs(getX());
    if ((destX - currX) < getRadius() && Math.abs(getY() - getDestY()) < getRadius()) {
      setDest(Math.random() * Aquarium.getSize(), Math.random() * Aquarium.getSize());
    }
    double a = Math.atan2(getDestY() - getY(), getDestX() - getX());
    if (getSpeed() * Math.cos(a) >= 0) {
      setDirection(Direction.RIGHT);
    } else {
      setDirection(Direction.LEFT);
    }
    setX(getX() + getSpeed() * Math.cos(a));
    setY(getY() + getSpeed() * Math.sin(a));
  }

  
  //setter
  /**
   * This sets the value of isFull to the input parameter.
   * @param full will be true if the fish is full
   */
  public void setIsFull(boolean full) {
    this.isFull = full;
  }

  /**
   * This sets the value of direction to the input parameter.
   * @param direction the Fish move's direction
   */
  public void setDirection(Direction direction) {
    this.direction = direction;
  }
  
  /**
   * This sets the value of x and y to the input parameter.
   * @param x the fish's axis
   * @param y the fish's ordinate
   */
  public void setDest(double x, double y) {
    this.destX = x;
    this.destY = y;
  }
  
  /**
   * This sets the current time to the input parameter.
   * @param time the current time
   */
  public void setTime(int time) {
    this.time = time;
  }

  
  //getter
  /**
   * This sets the fish's direction to the input parameter.
   * @return the fish's current direction
   */
  public Direction getDirection() {
    return this.direction;
  }
  
  /**
   * This returns this fish's destination axis.
   * @return this' destination axis
   */
  public double getDestX() {
    return this.destX;
  }
  
  /**
   * This returns this fish's destination ordinate.
   * @return this' destination ordinate
   */
  public double getDestY() {
    return this.destY;
  }

  /**
   * This returns this fish's isFull that will be true if the fish is full.
   * @return this fish's isFull
   */
  public boolean getIsFull() {
    return this.isFull;
  }

  /**
   * This returns this fish's time to death.
   * @return this fish's time to death
   */
  public int getTimeToDeath() {
    return this.timetoDeath;
  }

  /**
   * This returns this fish's radius.
   * @return this fish's radius
   */
  public int getRadius() {
    return this.radius;
  }

  /**
   * This returns this' current time.
   * @return this' current time
   */
  public int getTime() {
    return this.time;
  }
  
  /**
  * This returns this fish's time to get hungry.
  * @return this fish's time to get hungry
  */
  public int getTImeT() {
    return this.timeT;
  }

  //Attributes
  protected Direction direction;
  private double destX;
  private double destY; 
  protected boolean isFull;
  protected final int timetoDeath = 100;
  protected final int radius;
  protected int time;
  protected final int timeT = 50;
}