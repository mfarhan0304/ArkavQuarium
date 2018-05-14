/**
 * This class is used for linked list element.
 * @author Funtastic4
 * @version 1.0
 */
public class List<T> {
  private T elmt;
  private List<T> next;

  /**
   * Default List constructor.
   */
  public List() {
    this.elmt = null;
    this.next = null;
  }

  /**
   * List constructor with element.
   * @param elmt : element that will be set to List element.
   */
  public List(T elmt) {
    this.elmt = elmt;
    this.next = null;
  }

  /**
   * Procedure to set the list element.
   * @param elmt : desire element
   */
  public void setElmt(T elmt) {
    this.elmt = elmt;
  }

  /**
   * Procedure to set the next element of list.
   * @param elmt : Expected next element
   */
  public void setNext(List<T> elmt) {
    this.next = elmt;
  }

  /**
   * Function to get the first element of list.
   * @return the first element of list
   */
  public T getElmt() {
    return this.elmt;
  }

  /**
   * Function to get next list of list.
   * @return next attribute of first list
   */
  public List<T> getNext() {
    return this.next;
  }
}