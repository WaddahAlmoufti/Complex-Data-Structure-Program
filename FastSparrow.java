package comp2402a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastSparrow implements CapnStackSparrow {

  protected ArrayList<Integer> ds;

  protected ArrayList<Long> sum;

  protected ArrayList<Integer> higher;

  public FastSparrow() {
    ds = new ArrayList<>();
    sum = new ArrayList<>();
    higher = new ArrayList<>();
  }

  public void push(Integer x) {

    if (sum.isEmpty()) {
      sum.add((long) x);
    } else {
      sum.add((long) x + sum.get(size() - 1));
    }

    if (higher.isEmpty()) {
      higher.add(x);
    } else {
      if (x >= higher.get(size() - 1)) {
        higher.add(x);
      } else {
        higher.add(higher.get(size() - 1));
      }
    }

    ds.add(x);

  }

  public Integer pop() {
    if (size() <= 0) {
      return null;
    } else {

      sum.remove(size() - 1);
      higher.remove(size() - 1);

    }
    return ds.remove(size() - 1);
  }

  public Integer max() {

    if (size() <= 0) {
      return null;
    }
    return higher.get(size() - 1);

  }

  public long ksum(int k) {
    if (k == 0) {
      return 0;
    }

    if (k > size()) {
      return 0;
    }

    if (k == size()) {
      return sum.get((size()) - 1);
    }

    return (sum.get((size()) - 1)) - (sum.get((size()) - 1 - k));
  }

  public long ksumalt(int k) {
    if (k == 0) {
      return 0;
    }

    if (k == size()) {
      return sum.get((size()) - 1);
    }

    return (sum.get((size()) - 1)) - (sum.get((size()) - 1 - k));
  }

  public int size() {

    return ds.size();
  }

  public long sumget(int k) {
    if (k >= 0) {
      return sum.get(k);
    } else {
      return 0;
    }
  }

  public List<Integer> subList(int start, int last) {
    List<Integer> sub = ds.subList(start, last);
    return sub;
  }

  public void clear() {
    ds.clear();
    sum.clear();
    higher.clear();
  }

  public Iterator<Integer> iterator() {
    return ds.iterator();
  }
}