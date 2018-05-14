import static java.lang.Math.pow;
import static java.lang.Math.round;

/**
 * This class implements the snail and it inherits Entity class.
 * @author Funtastic4
 * @version 1.0
 */
public class Snail extends Entity {
  private Direction direction;

  /**
   * Snail default constructor.
   */
  public Snail() {
    super(50, 100);
    setDirection(Direction.RIGHT);
  }

  /**
   * Function to calculate Snail to one Coins in Aquarium.
   * @param other : Coin which already in Aquarium
   * @return the distance between Snail to Coin
   */
  public double distanceTo(Coins other) {
    return pow((pow(other.getX() - getX(), 2) + (pow(other.getY() - getY(), 2))), 0.5);
  }

  /**
   * Snail movement procedure.
   */
  @Override
  public void move() {}

  /**
   * Procedure used for Snail to move closer to Coins.
   * @param coinsTarget : Chased Coins relative to Snail
   */
  public void moveToCoins(Coins coinsTarget) {
    if (abscissa < round(coinsTarget.getX())) {
      setDirection(Direction.RIGHT);
      abscissa += getSpeed();
    } else if (abscissa > round(coinsTarget.getX())) {
      setDirection(Direction.LEFT);
      abscissa -= getSpeed();
    }
  }

  /**
   * Procedure that describe how Snail live in Aquarium
   * Chasing Coins if Coin's range.
   * @param listCoins : Coins list in Aquarium
   */
  public void lifeCycle(LinkedList<Coins> listCoins) {
    int idx = 0;

    if (!listCoins.isEmpty()) {
      Coins closeCoins = listCoins.get(idx);
      idx++;

      while (idx < listCoins.getIdx()) {
        if (distanceTo(closeCoins) > distanceTo(listCoins.get(idx))) {
          closeCoins = listCoins.get(idx);
        }
        idx++;
      }

      moveToCoins(closeCoins);
      if (round(abscissa) == round(closeCoins.getX()) && ordinate - 10 <= closeCoins.getY()) {
        Coins.money += closeCoins.getValue();
        listCoins.remove(closeCoins);
      }
    }
  }

  /**
   * Direction setter.
   * @param direction : updated direction.
   */
  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  /**
   * Direction getter.
   * @return current direction
   */
  public Direction getDirection() {
    return direction;
  }
}