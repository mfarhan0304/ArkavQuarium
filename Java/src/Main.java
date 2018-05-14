/**
 * This class implements main program
 * @author Funtastic4
 * @version 1.0
 */

import java.util.Random;

public class Main {
  public static LinkedList<Coins> ListCoin = new LinkedList<Coins>();
  public static LinkedList<Food> ListFood = new LinkedList<Food>();
  public static LinkedList<Guppy> ListGuppy = new LinkedList<Guppy>();
  public static LinkedList<Piranha> ListPiranha = new LinkedList<Piranha>();
  public static Snail snail = new Snail();
  public static boolean mainmenu = true;
  public static int egg;
  public static Integer eggPrice;
  public static boolean lose = false;
  public static boolean win = false;
  public static boolean moneyLess = false;

  /**
   * Main program.
   * @param args the args
   * @throws InterruptedException throw Interrupted Exception
   */
  public static void main(String[] args) throws InterruptedException {
    boolean getCoin = false;
    Screen s = new Screen();
    Random rand = new Random();
    Frame f = new Frame();
    f.add(s);
    f.setVisible(true);
    boolean running = true;
    while (running) {
      while (mainmenu) {
        if (f.getInputMouse().size() != 0) {
          if ((f.getMouseX() < 490 && f.getMouseX() > 251) 
              && (f.getMouseY() < 533 && f.getMouseY() > 395)) {
            System.out.println("Masuk");
            mainmenu = false;
            Coins.money = 5000;
            egg = 0;
            eggPrice = 10000;
            ListCoin = new LinkedList<Coins>();
            ListFood = new LinkedList<Food>();
            ListGuppy = new LinkedList<Guppy>();
            ListPiranha = new LinkedList<Piranha>();
            Guppy guppy = new Guppy();
            ListGuppy.add(guppy);
          } else if ((f.getMouseX() < 1160 && f.getMouseX() > 921) 
              && (f.getMouseY() < 533 && f.getMouseY() > 395)) {
            System.exit(0);
          } else if ((f.getMouseX() < 841 && f.getMouseX() > 579) 
              && (f.getMouseY() < 561 && f.getMouseY() > 419)) {
            ListCoin = new LinkedList<Coins>();
            ListFood = new LinkedList<Food>();
            ListGuppy = new LinkedList<Guppy>();
            ListPiranha = new LinkedList<Piranha>();
            ReadWrite rw = new ReadWrite();
            rw.readStateGuppy(ListGuppy, "guppyState.txt");
            rw.readStateCoins(ListCoin, "coinsState.txt");
            rw.readStateFood(ListFood, "foodState.txt");
            rw.readStatePiranha(ListPiranha, "piranhaState.txt");
            Coins.money = rw.readStateMoney("moneyState.txt");
            egg = rw.readStateEgg("eggState.txt");
            eggPrice = rw.readStateEggPrice("eggPriceState.txt");
            mainmenu = false;
          }
        }
        f.getInputMouse().clear();
        s.repaint();
        Thread.sleep(100);
      }
      while (lose) {
        if ((f.getMouseX() < 1173 && f.getMouseX() > 964) 
            && (f.getMouseY() < 568 && f.getMouseY() > 470)) {
          System.exit(0);
        } else if ((f.getMouseX() < 520 && f.getMouseX() > 118) 
            && (f.getMouseY() < 568 && f.getMouseY() > 470)) {
          Coins.money = 50000;
          egg = 0;
          eggPrice = 10000;
          lose = false;
          ListCoin = new LinkedList<Coins>();
          ListFood = new LinkedList<Food>();
          ListGuppy = new LinkedList<Guppy>();
          ListPiranha = new LinkedList<Piranha>();
          Guppy guppy = new Guppy();
          ListGuppy.add(guppy);
        }
        f.getInputMouse().clear();
        s.repaint();
        Thread.sleep(100);
      }
      while (win) {
        if (f.getInputMouse().size() != 0) {
          if ((f.getMouseX() < 1178 && f.getMouseX() > 965) 
              && (f.getMouseY() < 557 && f.getMouseY() > 458)) {
            System.exit(0);
          } else if ((f.getMouseX() < 567 && f.getMouseX() > 174) 
              && (f.getMouseY() < 557 && f.getMouseY() > 458)) {
            Coins.money = 50000;
            egg = 0;
            eggPrice += 10000;
            win = false;
            ListCoin = new LinkedList<Coins>();
            ListFood = new LinkedList<Food>();
            ListGuppy = new LinkedList<Guppy>();
            ListPiranha = new LinkedList<Piranha>();
          }
        }
        f.getInputMouse().clear();
        s.repaint();
        Thread.sleep(100);
      }
      int j = 0;
      if (f.getInputKey().size() != 0) {
        if (f.getKeyChar() == 'c') {
          Coins coin = new Coins(rand.nextInt(100), 0, 100);
          ListCoin.add(coin);
        } else if (f.getKeyChar() == 'x') {
          mainmenu = true;
        } else if (f.getKeyChar() == 's') {
          ReadWrite rw = new ReadWrite();
          rw.writeStateEgg(egg, "eggState.txt");
          rw.writeStateEggPrice(eggPrice, "eggPriceState.txt");
          rw.writeStateGuppy(ListGuppy, "guppyState.txt");
          rw.writeStateCoins(ListCoin, "coinsState.txt");
          rw.writeStateFood(ListFood, "foodState.txt");
          rw.writeStatePiranha(ListPiranha, "piranhaState.txt");
          rw.writeStateMoney(Coins.money, "moneyState.txt");
        }
        f.getInputKey().clear();
      }
      if (f.getInputMouse().size() != 0) {
        if ((f.getMouseX() < 932 && f.getMouseX() > 774) 
            && (f.getMouseY() < 196 && f.getMouseY() > 116)) {
          if (Coins.money >= 500) {
            Coins.money -= 500;
            Guppy guppy = new Guppy();
            ListGuppy.add(guppy);
          } else {
            moneyLess = true;
          }
        } else if ((f.getMouseX() < 1136 && f.getMouseX() > 974) 
            && (f.getMouseY() < 196 && f.getMouseY() > 116)) {
          if (Coins.money >= 1000) {
            Coins.money -= 1000;
            Piranha piranha = new Piranha();
            ListPiranha.add(piranha);
          } else {
            moneyLess = true;
          }
        } else if ((f.getMouseX() < 1328 && f.getMouseX() > 1173) 
            && (f.getMouseY() < 196 && f.getMouseY() > 116)) {
          if (Coins.money >= eggPrice) {
            Coins.money -= eggPrice;
            egg++;
            eggPrice += 5000;
          } else {
            moneyLess = true;
          }
        } else {
          if (!ListCoin.isEmpty()) {
            int i = 0;
            while (i < ListCoin.getIdx() && !getCoin) {
              if (Math.abs(ListCoin.get(i).getX() - f.getMouseX() / 13.66) <= 3 
                  && Math.abs(ListCoin.get(i).getY() - f.getMouseY() / 7.68) <= 6) {
                Coins.money += ListCoin.get(i).getValue();
                ListCoin.remove(ListCoin.get(i));
                getCoin = true;
              }
              i++;
            }
          }
          if (!getCoin) {
            if (Coins.money >= 20) {
              Coins.money -= 20;
              Food food = new Food(f.getMouseX() / 13.66, f.getMouseY() / 7.68);
              ListFood.add(food);
            } else {
              moneyLess = true;
            }
          }
          getCoin = false;
        }
        f.getInputMouse().clear();
      }
      while (!ListCoin.isEmpty() && j < ListCoin.getIdx()) {
        ListCoin.get(j).lifeCycle();
        j++;
      }
      j = 0;
      while (!ListPiranha.isEmpty() && j < ListPiranha.getIdx()) {
        ListPiranha.get(j).lifeCycle(ListGuppy, ListCoin, ListPiranha);
        j++;
      }
      j = 0;
      while (!ListGuppy.isEmpty() && j < ListGuppy.getIdx()) {
        ListGuppy.get(j).lifeCycle(ListFood, ListCoin, ListGuppy);
        j++;
      }
      j = 0;
      while (!ListFood.isEmpty() && j < ListFood.getIdx()) {
        ListFood.get(j).lifeCycle(ListFood);
        j++;
      }
      snail.lifeCycle(ListCoin);
      if (ListGuppy.isEmpty() && ListPiranha.isEmpty() && ListCoin.isEmpty() && Coins.money < 500) {
        lose = true;
      }
      if (egg == 3) {
        win = true;
      }
      s.repaint();
      Thread.sleep(100);
    }
  }
}