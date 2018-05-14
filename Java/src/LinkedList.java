/**
 * This class is used for listing all type of same object.
 * @author Funtastic4
 * @version 1.0
 */
public class LinkedList<T> extends List<T> {
  private List<T> firstList;
  private List<T> lastList;

  /**
   * Default LinkedList ctor.
   */
  public LinkedList() {
    firstList = new List<T>();
    lastList = new List<T>();
  }

  /**
   * Function to find the index of elmt in linked list.
   * @param elmt : searched element
   * @return elmt index on linked list, -1 if not found
   */
  public int find(T elmt) {
    int idx = 0;

    List<T> temp = firstList;

    if (!isEmpty()) {
      do {
        if (temp.getElmt().equals(elmt)) {
          return idx;
        }
        temp = temp.getNext();
        idx++;
      } while (temp != null);
    }

    return -1;
  }

  /**
   * Function to know whether linked list is empty or no.
   * @return true if linked list is empty
   */
  public boolean isEmpty() {
    return (firstList.getElmt() == null);
  }

  /**
   * Procedure to add element to linked list.
   * @param elmt : added element
   */
  public void add(T elmt) {
    if (isEmpty()) {
      firstList.setElmt(elmt);
      lastList = firstList;
    } else {
      lastList.setNext(new List<T>(elmt));
      lastList = lastList.getNext();
    }
  }

  /**
   * Procedure to remove element from linked list.
   * @param elmt : desire removed element
   */
  public void remove(T elmt) {
    int idx = find(elmt);

    List<T> temp = firstList;
    if (idx != -1) {
      if (getIdx() == 1) {
        firstList.setElmt(null);
        lastList.setElmt(null);
      } else if (idx == 0) {
        firstList = firstList.getNext();
      } else if (idx == (getIdx() - 1)) {
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.getNext();
        }
        temp.setNext(null);
        lastList = temp;
      } else {
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.getNext();
        }
        temp.setNext((temp.getNext()).getNext());
      }
    }
  }

  /**
   * Function to get element from expected index.
   * @param idx : index of element
   * @return element from expected index
   */
  public T get(int idx) {
    List<T> temp = firstList;
    for (int i = 0; i < idx; i++) {
      temp = temp.getNext();
    }

    return temp.getElmt();
  }

  /**
   * Function to count the number of elements.
   * @return number of elements
   */
  public int getIdx() {
    int idx = 0;
    List<T> p = firstList;

    while (p != null) {
      idx++;
      p = p.getNext();
    }

    return idx;
  }
}