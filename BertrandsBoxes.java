import java.util.*;
import java.util.Random;

public class BertrandsBoxes {
  private int number = 10000;

  private int coinSilver = 0;
  private int coinGold = 0;

  public void doExperiment(List<Box> boxes) {

    for (int i = 0; i < number; i++) {
      Random random = new Random();
      Box box = boxes.get(random.nextInt(10 % 3));
      Coin coinType = box.getCoin();
      String type = coinType.getType();
      if (type.equals("Gold")) coinGold++;
      else coinSilver++;
    }
  }

  public int getProbabilityGold() {
    return coinGold / number;
  }

  public int getProbabilitySilver() {
    return coinSilver / number;
  }

  public static void main(String[] args) {
    List<Box> boxes = new ArrayList(3);
    Coin gold = new Coin("Gold");
    Coin silver = new Coin("Silver");
    Box a = new Box(gold, gold);
    Box b = new Box(gold, silver);
    Box c = new Box(silver, silver);

    boxes.add(a);
    boxes.add(b);
    boxes.add(c);
    BertrandsBoxes myObject = new BertrandsBoxes();
    myObject.doExperiment(boxes);
    System.out.println(" Gold outCome" + myObject.getProbabilityGold());
    System.out.println(" Silver outCome" + myObject.getProbabilitySilver());
  }

  static class Box {
    Coin a;
    Coin b;

    public Box(Coin a, Coin b) {
      this.a = a;
      this.b = b;
    }

    public Coin getCoin() {

      Random random = new Random();
      if (random.nextInt(10) % 2 == 0) {
        return a;
      } else {
        return b;
      }
    }
  }

  static class Coin {
    String type;

    public Coin(String type) {
      this.type = type;
    }

    public String getType() {
      return this.type;
    }
  }
}
