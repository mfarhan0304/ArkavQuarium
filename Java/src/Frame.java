import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * This class implements the frame of the game. It inherits JFrame class, interface MouseListener
 * and interface KeyListener
 * @author Funtastic4
 * @version 1.0
 */
public class Frame extends JFrame implements MouseListener, KeyListener {
  /**
  * This constructs a frame and set the size of the frame to 1366x768
  * the title to Akravquarium and call the init() method.
  */
  public Frame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1366, 768);
    // setExtendedState(JFrame.MAXIMIZED_BOTH);
    setTitle("Arkavquarium");
    init();
  }

  /**
  * This method is used to initialize the window.
  */
  public void init() {
    setLocationRelativeTo(this);
    this.addMouseListener(this);
    this.addKeyListener(this);
  }

  /**
   * This returns the mouse input.
   * @return the mouse input
   */
  public ArrayList<Integer> getInputMouse() {
    return inputMouse;
  }

  /**
   * This sets the mouse input to the input parameter.
   * @param inputMouse the mouse input
   */
  public void setInputMouse(ArrayList<Integer> inputMouse) {
    this.inputMouse = inputMouse;
  }

  /**
   * This returns the mouse's axis position.
   * @return the mouse's axis position
   */
  public int getMouseX() {
    return mouseX;
  }

  /**
   * This sets the mouse's axis position to the input parameter.
   * @param mouseX the mouse's axis position
   */
  public void setMouseX(int mouseX) {
    this.mouseX = mouseX;
  }

  /**
   * This returns the mouse's ordinate position.
   * @return the mouse's ordinate position
   */
  public int getMouseY() {
    return mouseY;
  }

  /**
   * This sets the mouse's ordinate position.
   * @param mouseY the mouse's ordinate position
   */
  public void setMouseY(int mouseY) {
    this.mouseY = mouseY;
  }

  /**
   * Implements method from MouseListener interface.
   */
  public void mousePressed(MouseEvent e) {
    inputMouse.add(1);
    mouseX = e.getX();
    mouseY = e.getY();
  }

  /**
   * Implements method from MouseListener interface.
   */
  public void mouseReleased(MouseEvent e) {}

  /**
   * Implements method from MouseListener interface.
   */
  public void mouseEntered(MouseEvent e) {}

  /**
   * Implements method from MouseListener interface.
   */
  public void mouseExited(MouseEvent e) {}

  /**
   * Implements method from MouseListener interface.
   */
  public void mouseClicked(MouseEvent e) {}

  /**
   * Implements method from KeyListener inerface.
   */
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    inputKey.add(1);
    keyChar = e.getKeyChar();
  }

  /**
   * Implements method from KeyListener inerface.
   */
  public void keyReleased(KeyEvent e) {}

  /**
   * Implements method from KeyListener inerface.
   */
  public void keyTyped(KeyEvent e) {
    System.out.println(e.getKeyChar());
  }

  /**
   * This return the input key.
   * @return inputKey
   */
  public ArrayList<Integer> getInputKey() {
    return inputKey;
  }

  /**
   * This set the inputKey.
   * @param inputKey the input key of frame.
   */
  public void setInputKey(ArrayList<Integer> inputKey) {
    this.inputKey = inputKey;
  }

  /**
   * This return the keyChar from typed key.
   * @return keyChar
   */
  public char getKeyChar() {
    return keyChar;
  }

  private static final long serialVersionUID = 1L;
  private ArrayList<Integer> inputKey = new ArrayList<Integer>();
  private ArrayList<Integer> inputMouse = new ArrayList<Integer>();
  private int mouseX;
  private int mouseY;
  private char keyChar;

}
