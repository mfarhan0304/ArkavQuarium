/**
 * This class implements Food and inherits Entity class and Interface.
 * @author Funtastic4
 * @version 1.0
 */
class Food extends Entity {
  /**
   * This constructs a Food with a specified (x,y) position.
   * @param abscissa : x-axis
   * @param ordinate : y-axis
   */
  public Food(double abscissa, double ordinate) {
    super(abscissa, ordinate);
  }

  /**
   * This method is used to move the position of Food to
   * a greater y as long as the value of y is not at 4%
   * of the bottom of the Aquarium.
   */
  @Override
  public void move() {
    ordinate++;
  }

  /**
   * Food movement to the bottom of Aquarium
   * Remove Food from list if already in bottom.
   * @param listFood : Food list in Aquarium
   */
  public void lifeCycle(LinkedList<Food> listFood) {
    move();
    if (ordinate > 100) {
      listFood.remove(this);
    }
  }
}