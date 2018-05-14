import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * This class implements the Guppy fish
 * and it inherits Fish class.
 * @author Funtastic4
 * @version 1.0
 */
class Guppy extends Fish {
  /**
   * Default Guppy constructors.
   */
  public Guppy() {
    super();
    setSpeed(1);
    setPhase(1);
    setFoodCounter(0);
  }

  /**
   * Procedure that used for Guppy to grow.
   */
  public void grow() {
    setPhase(getPhase() + 1);
  }

  /**
   * Procedure to add Coin to listCoins.
   * @param listCoins : Coins list in Aquarium
   */
  public void makeCoins(LinkedList<Coins> listCoins) {
    listCoins.add(new Coins(getX(), getY(), getPhase() * 100));
  }

  /**
   * Function to calculate current Guppy to one Food in Aquarium.
   * @param other : Food which already in Aquarium
   * @return the distance between Guppy to Food
   */
  public double distanceTo(Food other) {
    return pow((pow(other.getX() - getX(), 2) + (pow(other.getY() - getY(), 2))), 0.5);
  }

  /**
   * Procedure used for Guppy to move closer to Food.
   * @param foodTarget : Chased Food relative to Guppy
   */
  public void moveToFood(Food foodTarget) {
    setSpeed(getSpeed() + 1);
    double a = Math.atan2(foodTarget.getY() - getY(), foodTarget.getX() - getX());
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
   * Chasing Guppy if hungry and Guppy is in Guppy's range
   * Move random if nothing special
   * Move faster if hungry
   * Die if can't get any guppy on timetoDeath time.
   * @param listGuppy : Guppy list in Aquarium
   * @param listCoins : Coins list in Aquarium
   * @param listGuppy : Guppy list in Aquarium
   */
  public void lifeCycle(LinkedList<Food> listFood, LinkedList<Coins> listCoins,
                        LinkedList<Guppy> listGuppy) {
    int idx = 0;
    if (!listFood.isEmpty() && !getIsFull()) {
      Food closeFood = listFood.get(idx);
      idx++;
      while (idx < listFood.getIdx()) {
        if (distanceTo(closeFood) > distanceTo(listFood.get(idx))) {
          closeFood = listFood.get(idx);
        }
        idx++;
      }
      moveToFood(closeFood);
      double rangeX = abs(getX() - closeFood.getX());
      double rangeY = abs(getY() - closeFood.getY());
      if (rangeX < getRadius() && rangeY < getRadius()) {
        setIsFull(true);
        setTime(0);
        setFoodCounter(getFoodCounter() + 1);
        listFood.remove(closeFood);
        setSpeed(1);
      }
    } else {
      move();
    }

    if (getTime() >= getTImeT()) {
      setIsFull(false);
      setSpeed(1);
    }

    if (getTime() >= getTimeToDeath()) {
      listGuppy.remove(this);
    }

    setTime(getTime() + 1);
    if (getTime() % getTimeC() == 0 && getIsFull()) {
      makeCoins(listCoins);
    }

    if (getFoodCounter() > 0 && (getFoodCounter() == 4 || getFoodCounter() == 8)
        && getPhase() < getMaxPhase()) {
      grow();
      setFoodCounter(getFoodCounter() + 1);
    }
  }

  /**
   * Phase setter.
   * @param phase : desire phase
   */
  public void setPhase(int phase) {
    this.phase = phase;
  }

  /**
   * FoodCounter setter.
   * @param foodCounter : updated foodCounter
   */
  public void setFoodCounter(int foodCounter) {
    this.foodCounter = foodCounter;
  }

  /**
   * Phase getter.
   * @return current phase of Guppy
   */
  public int getPhase() {
    return this.phase;
  }

  /**
   * FoodCounter getter.
   * @return current foodCounter of Guppy
   */
  public int getFoodCounter() {
    return this.foodCounter;
  }

  /**
   * MaxPhase getter.
   * @return maxPhase : 3
   */
  public int getMaxPhase() {
    // phase 3
    return 3;
  }

  /**
   * TimeC - time for Guppy to make Coins - getter.
   * @return current timeC
   */
  public int getTimeC() {
    return this.timeC;
  }

  private int phase; // start from phase 1 to 3
  private int foodCounter;
  protected final int timeC = 50;
}