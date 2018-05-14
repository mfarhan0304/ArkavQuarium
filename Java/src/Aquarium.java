/**
 * This class implements the aquarium of the ArkavQuarium.
 * it inherits Interface
 * @author Funtastic4
 * @version 1.0
 */
class Aquarium {
  private static final int size = 100;
    
  public Aquarium() {

  }
  
  /**
   * This returns the current size of the aquarium.
   * @return this aquarium's size
   */
  
  public static int getSize() {
    return size;
  }
    
  public static double getPercentSize(int percent) {
    return (getSize() * percent / 100);
  }

  public static double getBorder(int percent) {
    return (getSize() - getPercentSize(percent));
  }

  public static void main(String[] args) {
    System.out.println(Aquarium.getSize());
  }

}
