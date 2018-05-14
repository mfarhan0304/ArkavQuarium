import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * This class implements the Piranha fish
 * and it inherits Fish class.
 * @author Funtastic4
 * @version 1.0
 */
public class Piranha extends Fish {
  /**
   * Piranha default constructor.
   */
  public Piranha() {
    super();
    setSpeed(2);
  }

  /**
   * Procedure to add Coin to listCoins.
   * @param listCoins : Coins list in Aquarium
   * @param eatenGuppy : Guppy that have been eaten by Piranha
   */
  public void makeCoins(LinkedList<Coins> listCoins, Guppy eatenGuppy) {
    listCoins.add(new Coins(getX(), getY(), (eatenGuppy.getPhase() + 1) * 500));
  }

  /**
   * Function to calculate current Piranha to one Guppy in Aquarium.
   * @param other : Guppy which already in Aquarium
   * @return
   */
  public double distanceTo(Guppy other) {
    return pow((pow(other.getX() - getX(), 2) + (pow(other.getY() - getY(), 2))), 0.5);
  }

  /**
   * Procedure used for Piranha to move closer to Guppy.
   * @param guppyTarget : Chased Guppy relative to Piranha
   */
  public void moveToFood(Guppy guppyTarget) {
    setSpeed(getSpeed() + 1);
    double a = Math.atan2(guppyTarget.getY() - getY(), guppyTarget.getX() - getX());

    if ((getSpeed() * Math.cos(a)) >= 0) {
      setDirection(Direction.RIGHT);
    } else {
      setDirection(Direction.LEFT);
    }
    setX(getX() + getSpeed() * Math.cos(a));
    setY(getY() + getSpeed() * Math.sin(a));
  }

  /**
   * Procedure that describe how Piranha live in Aquarium
   * Chasing Guppy if hungry and Guppy is in Piranha's range
   * Move random if nothing special
   * Move faster if hungry
   * Die if can't get any Guppy on timetoDeath time.
   * @param listGuppy : Guppy list in aquarium
   * @param listCoins : Coins list in aquarium
   * @param listPiranha : Piranha list in aquarium
   */
  public void lifeCycle(LinkedList<Guppy> listGuppy, LinkedList<Coins> listCoins,
                        LinkedList<Piranha> listPiranha) {
    int idx = 0;

    if (!listGuppy.isEmpty() && !getIsFull()) {
      Guppy closeGuppy = listGuppy.get(idx);
      idx++;

      while (idx < listGuppy.getIdx()) {
        if (distanceTo(closeGuppy) > distanceTo(listGuppy.get(idx))) {
          closeGuppy = listGuppy.get(idx);
        }
        idx++;
      }

      moveToFood(closeGuppy);
      double rangeX = abs(getX() - closeGuppy.getX());
      double rangeY = abs(getY() - closeGuppy.getY());
      if (rangeX < getRadius() && rangeY < getRadius()) {
        setIsFull(true);
        setTime(0);
        makeCoins(listCoins, closeGuppy);
        listGuppy.remove(closeGuppy);
        setSpeed(2);
      }
    } else {
      move();
    }

    if (getTime() >= getTImeT()) {
      setIsFull(false);
      setSpeed(2);
    }

    if (getTime() >= getTimeToDeath()) {
      listPiranha.remove(this);
    }

    setTime(getTime() + 1);
  }
}