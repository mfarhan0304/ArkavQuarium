/**
 * This class implements coins and inherit Entity class.
 * @author Funtastic4
 * @version 1.0
 */
public class Coins extends Entity {
  public static Integer money;
  private int value;

  /**
   * This constructs a coin with a specified (x,y) position
   * and value.
   * @param abscissa : x-axis
   * @param ordinate : y-axis
   * @param value : coin value
   */
  public Coins(double abscissa, double ordinate, int value) {
    super(abscissa, ordinate);
    setValue(value);
  }

  /**
   * This is used to set the value of the coins.
   * @param value : coin value
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * This method is used to move the coins to a greater y
   * as long as the value of y is not at 4% of the bottom of
   * the aquarium.
   */
  public void move() {
    if (ordinate <= 100) {
      ordinate += 2;
    }
  }

  /**
   * This returns the current value of the coin.
   * @return this coin's value
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Coins move down to the bottom of Aquarium.
   */
  public void lifeCycle() {
    move();
  }
}