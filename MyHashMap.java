import java.uti.*;

public class MyHashmap {
  private int size = 10;
  private List<List<String>> dataContainer = new ArrayList<>(new ArraList<>(size));

  private put(Integer key, String Value) {

    int hash = getHash(key);
    int index = hash % size;
    if (index < size) {
      List<String> data = dataContainer.getItem(index);
      if (data != null) data.add(value);
      else {
        List<String> temp = new ArrayList<String>();
        temp.add(value);
        dataContainer.addItem(temp, index);
      }
    }
  }

  private int getHash(Integer key) {}
}
