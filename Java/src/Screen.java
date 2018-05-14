import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Attributes/objects that want to be shown in the screen.
 */
public class Screen extends JPanel {
  private static final long serialVersionUID = 1L;
  private BufferedImage aquarium;
  private BufferedImage mainMenu;
  private BufferedImage foodie;
  private BufferedImage diamond;
  private BufferedImage eggos1;
  private BufferedImage eggos2;
  private BufferedImage eggos3;
  private BufferedImage papan;
  private BufferedImage scroll;
  private BufferedImage ikanb;
  private BufferedImage ikanb1;
  private BufferedImage ikanb2;
  private BufferedImage ikanbflip;
  private BufferedImage ikanb1flip;
  private BufferedImage ikanb2flip;
  private BufferedImage ikanlaper;
  private BufferedImage ikanlaper1;
  private BufferedImage ikanlaper2;
  private BufferedImage ikanlaperflip;
  private BufferedImage ikanlaper1flip;
  private BufferedImage ikanlaper2flip;
  private BufferedImage piranhaLeft;
  private BufferedImage piranhaRight;
  private BufferedImage piranhaSickLeft;
  private BufferedImage piranhaSickRight;
  private BufferedImage pir;
  private BufferedImage snail0;
  private BufferedImage snail1;
  private BufferedImage youlose;
  private BufferedImage youwin;
  private BufferedImage coin;
  private BufferedImage background;
  
  /**
   * This method initiates each attribute with the corresponding image.
   */
  public Screen() {
    try {
      aquarium = ImageIO.read(getClass().getResourceAsStream("image/aquarium1.jpg"));
      mainMenu = ImageIO.read(getClass().getResourceAsStream("image/MainMenu.png"));
      diamond = ImageIO.read(getClass().getResourceAsStream("image/Diamond.png"));
      foodie = ImageIO.read(getClass().getResourceAsStream("image/foodie.png"));
      eggos1 = ImageIO.read(getClass().getResourceAsStream("image/eggos1.png"));
      eggos2 = ImageIO.read(getClass().getResourceAsStream("image/eggos2.png"));
      eggos3 = ImageIO.read(getClass().getResourceAsStream("image/eggos3.png"));
      papan = ImageIO.read(getClass().getResourceAsStream("image/papan.png"));
      scroll = ImageIO.read(getClass().getResourceAsStream("image/scroll.png"));
      ikanb = ImageIO.read(getClass().getResourceAsStream("image/ikanb.png"));
      ikanb1 = ImageIO.read(getClass().getResourceAsStream("image/ikanb1.png"));
      ikanb2 = ImageIO.read(getClass().getResourceAsStream("image/ikanb2.png"));
      ikanbflip = ImageIO.read(getClass().getResourceAsStream("image/ikanbflip.png"));
      ikanb1flip = ImageIO.read(getClass().getResourceAsStream("image/ikanb1flip.png"));
      ikanb2flip = ImageIO.read(getClass().getResourceAsStream("image/ikanb2flip.png"));
      ikanlaper = ImageIO.read(getClass().getResourceAsStream("image/ikanlaper.png"));
      ikanlaper1 = ImageIO.read(getClass().getResourceAsStream("image/ikanlaper1.png"));
      ikanlaper2 = ImageIO.read(getClass().getResourceAsStream("image/ikanlaper2.png"));
      ikanlaperflip = ImageIO.read(getClass().getResourceAsStream("image/ikanlaperflip.png"));
      ikanlaper1flip = ImageIO.read(getClass().getResourceAsStream("image/ikanlaper1flip.png"));
      ikanlaper2flip = ImageIO.read(getClass().getResourceAsStream("image/ikanlaper2flip.png"));
      piranhaLeft = ImageIO.read(getClass().getResourceAsStream("image/PiranhaLeft.png"));
      piranhaRight = ImageIO.read(getClass().getResourceAsStream("image/PiranhaRight.png"));
      piranhaSickLeft = ImageIO.read(getClass().getResourceAsStream("image/PiranhaSickLeft.png"));
      piranhaSickRight = ImageIO.read(getClass().getResourceAsStream("image/PiranhaSickRight.png"));
      pir = ImageIO.read(getClass().getResourceAsStream("image/pir.png"));
      snail0 = ImageIO.read(getClass().getResourceAsStream("image/snail0.png"));
      snail1 = ImageIO.read(getClass().getResourceAsStream("image/snail1.png"));
      youlose = ImageIO.read(getClass().getResourceAsStream("image/youlose.png"));
      youwin = ImageIO.read(getClass().getResourceAsStream("image/YOUWIN.png"));
      coin = ImageIO.read(getClass().getResourceAsStream("image/coin.png"));
      background = ImageIO.read(getClass().getResourceAsStream("image/aquarium.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * This method displays all the images that have been initiated to the screen.
   */
  public void paint(Graphics g) {
    if (Main.mainmenu == true) {
      g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
      g.drawImage(mainMenu, 0, 0, null);
    } else if (Main.lose) {
      g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
      g.drawImage(youlose, 0, 0, null);
    } else if (Main.win) {
      g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
      g.drawImage(youwin, 0, 0, null);
    } else {
      g.drawImage(aquarium, 0, 0, this.getWidth(), this.getHeight(), null);
      int snaily = (int)(Main.snail.getX() * (1366 / 100) - snail0.getWidth() / 2);
      int snaily2 = (int)(Main.snail.getY() * (768 / 100) - snail0.getHeight() / 2);
      if (Main.snail.getDirection() == Direction.RIGHT) {
        g.drawImage(snail0, snaily, snaily2, snail0.getWidth(), snail0.getHeight(), null);
      } else {
        g.drawImage(snail1, snaily, snaily2, snail1.getWidth(), snail1.getHeight(), null);
      }
      int i = 0;
      while (!Main.ListCoin.isEmpty() && i < Main.ListCoin.getIdx()) {
        int diamond1 = (int)(Main.ListCoin.get(i).getX() * (1366 / 100) - (diamond.getWidth() / 2));
        int diamond2 = (int)(Main.ListCoin.get(i).getY() * (768 / 100) - (diamond.getHeight() / 2));
        if (Main.ListCoin.get(i).getValue() >= 1000) {
          g.drawImage(diamond, diamond1, diamond2, diamond.getWidth(), diamond.getHeight(), null);
          i++;
        } else {
          int koin1 = (int)(Main.ListCoin.get(i).getX() * (1366 / 100) - (coin.getWidth() / 2));
          int koin2 = (int)(Main.ListCoin.get(i).getY() * (768 / 100) - (coin.getHeight() / 2));
          g.drawImage(coin, koin1, koin2, coin.getWidth(), coin.getHeight(), null);
          i++;
        }
      }
      i = 0;
      while (!Main.ListFood.isEmpty() && i < Main.ListFood.getIdx()) {
        if (Main.ListFood.get(i) != null) {
          int food = (int)(Main.ListFood.get(i).getX() * (1366 / 100));
          int food2 = (int)(Main.ListFood.get(i).getY() * (768 / 100) - (foodie.getHeight() / 2));
          g.drawImage(foodie, food, food2, foodie.getWidth(), foodie.getHeight(), null);
        }
        i++;
      }
      i = 0;
      while (!Main.ListGuppy.isEmpty() && i < Main.ListGuppy.getIdx()) {
        int ikan =  (int)(Main.ListGuppy.get(i).getX() * (1300 / 100));
        int ikan2 = (int)(Main.ListGuppy.get(i).getY() * (700 / 100));
        if (Main.ListGuppy.get(i).getDirection() == Direction.RIGHT) {
          if (!Main.ListGuppy.get(i).getIsFull()) {
            if (Main.ListGuppy.get(i).getPhase() == 1) {
              g.drawImage(ikanlaper2flip, ikan, ikan2, 
                  ikanlaper2flip.getWidth(), ikanlaper2flip.getHeight(), null);
            } else if (Main.ListGuppy.get(i).getPhase() == 2) {
              g.drawImage(ikanlaper1flip, ikan, ikan2, 
                  ikanlaper1flip.getWidth(), ikanlaper1flip.getHeight(), null);              
            } else {
              g.drawImage(ikanlaperflip, ikan, ikan2,
                  ikanlaperflip.getWidth(), ikanlaperflip.getHeight(), null);
            }
          } else {
            if (Main.ListGuppy.get(i).getPhase() == 1) {
              g.drawImage(ikanb2flip, ikan, ikan2,
                  ikanb2flip.getWidth(), ikanb2flip.getHeight(), null);
            } else
              if (Main.ListGuppy.get(i).getPhase() == 2) {
                g.drawImage(ikanb1flip, ikan, ikan2,
                    ikanb1flip.getWidth(), ikanb1flip.getHeight(), null);
              } else {
                g.drawImage(ikanbflip, ikan, ikan2,
                    ikanbflip.getWidth(), ikanbflip.getHeight(), null);               
              }
          }
        } else {
          if (!Main.ListGuppy.get(i).getIsFull()) {
            if (Main.ListGuppy.get(i).getPhase() == 1) {
              g.drawImage(ikanlaper2, ikan, ikan2, 
                  ikanlaper2.getWidth(), ikanlaper2.getHeight(), null);
            } else 
              if (Main.ListGuppy.get(i).getPhase() == 2) {
                g.drawImage(ikanlaper1, ikan, ikan2,
                    ikanlaper1.getWidth(), ikanlaper1.getHeight(), null);               
              } else  {
                g.drawImage(ikanlaper, ikan, ikan2, 
                    ikanlaper.getWidth(), ikanlaper.getHeight(), null);
              }
          } else {
            if (Main.ListGuppy.get(i).getPhase() == 1) {
              g.drawImage(ikanb2, ikan, ikan2, ikanb2.getWidth(), ikanb2.getHeight(), null);
            } else
              if (Main.ListGuppy.get(i).getPhase() == 2) {
                g.drawImage(ikanb1, ikan, ikan2, 
                    ikanb1.getWidth(), ikanb1.getHeight(), null);               
              } else {
                g.drawImage(ikanb, ikan, ikan2,
                    ikanb.getWidth(), ikanb.getHeight(), null);               
              }
          }
        }
        i++;
      }

      i = 0;
      while (!Main.ListPiranha.isEmpty() && i < Main.ListPiranha.getIdx()) {
        if (Main.ListPiranha.get(i).getDirection() == Direction.RIGHT) {
          if (!Main.ListPiranha.get(i).getIsFull()) {
            g.drawImage(piranhaSickRight, (int)(Main.ListPiranha.get(i).getX() * 1366 / 100 
                - piranhaSickRight.getWidth() / 2), (int)(Main.ListPiranha.get(i).getY() * 768 / 100
                - piranhaSickRight.getHeight() / 2), piranhaRight.getWidth(), 
                piranhaRight.getHeight(), null);
          } else {
            g.drawImage(piranhaRight, (int)(Main.ListPiranha.get(i).getX() * 1366 / 100 
                - piranhaRight.getWidth() / 2), (int)(Main.ListPiranha.get(i).getY() * 768 / 100
                - piranhaRight.getHeight() / 2), piranhaRight.getWidth(), 
                piranhaRight.getHeight(), null);
          }
        } else {
          if (!Main.ListPiranha.get(i).getIsFull()) {
            g.drawImage(piranhaSickLeft, (int)(Main.ListPiranha.get(i).getX() * 1366 / 100
                - piranhaSickLeft.getWidth() / 2), (int)(Main.ListPiranha.get(i).getY() * 768 / 100
                - piranhaSickLeft.getHeight() / 2), piranhaRight.getWidth(), 
                piranhaRight.getHeight(), null);
          } else {
            g.drawImage(piranhaLeft, (int)(Main.ListPiranha.get(i).getX() * 1366 / 100
                - piranhaLeft.getWidth() / 2), (int)(Main.ListPiranha.get(i).getY() * 768 / 100 
                - piranhaLeft.getHeight() / 2), piranhaRight.getWidth(), 
                piranhaRight.getHeight(), null);
          }
        }
        i++;
      }
      g.drawImage(papan, 760, -25, papan.getWidth(), papan.getHeight(), null);
      g.drawImage(papan, 960, -25, papan.getWidth(), papan.getHeight(), null);
      g.drawImage(papan, 1160, -25, papan.getWidth(), papan.getHeight(), null);
      g.drawImage(scroll, 0, 0, scroll.getWidth(), scroll.getHeight(), null);
      g.drawImage(ikanb2, 800, 75, ikanb2.getWidth(), ikanb2.getHeight(), null);
      g.drawImage(pir, 970, 75, pir.getWidth(), pir.getHeight(), null);
      if (Main.egg == 0) {
        g.drawImage(eggos1, 1217, 87, eggos1.getWidth(), eggos1.getHeight(), null);
      } else if (Main.egg == 1) {
        g.drawImage(eggos2, 1217, 87, eggos1.getWidth(), eggos2.getHeight(), null);
      } else {
        g.drawImage(eggos3, 1217, 87, eggos1.getWidth(), eggos3.getHeight(), null);
      }
      Graphics2D g2 = (Graphics2D)g;
      Graphics2D g5 = (Graphics2D)g;
      Graphics2D g6 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g5.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g6.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Font fontmoney = new Font("Monospaced", Font.BOLD, 38);
      Font fontmoneyred = new Font("Monospaced", Font.BOLD, 38);
      g2.setFont(fontmoney);
      g6.setFont(fontmoneyred);
      if (Main.moneyLess) {
        g6.setColor(Color.RED);
        g6.drawString("MONEY", 110, 61);
        g6.drawString(Coins.money.toString(), 120, 100);
        Main.moneyLess = false;
        g6.setColor(Color.BLACK);
      } else {
        g2.drawString("MONEY", 110, 61);
        g2.drawString(Coins.money.toString(), 120, 100);
      }
      Font fontpiranha = new Font("Monospaced", Font.BOLD, 20);
      g2.setFont(fontpiranha);
      g2.drawString("1000", 1024, 170);
      Font fontguppy = new Font("Monospaced", Font.BOLD, 20);
      g2.setFont(fontguppy);
      g2.drawString("500", 833, 170);
      Font fonteggos = new Font("Monospaced", Font.BOLD, 20);
      g2.setFont(fonteggos);
      g2.drawString(Main.eggPrice.toString(), 1221, 170);
      Font fontpressX = new Font("Plain", Font.BOLD, 14);
      g5.setFont(fontpressX);
      g5.drawString("Press X to exit", 107, 124);
    }
  }
}