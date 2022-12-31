package comp2402a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class WhatTheFast extends FastSparrow implements WhatTheDeque {

  public FastSparrow front;

  public FastSparrow back;

  public WhatTheFast() {
    front = new FastSparrow();

    back = new FastSparrow();
  }

  public void balance() {
    int n = front.size() + back.size();

    if (((3 * front.size() < back.size() && front.size() > 0)) || ((front.size() == 0) && back.size() >= 2)) {
      int s = n / 2 - front.size();

      ArrayList<Integer> l1 = new ArrayList();
      ArrayList<Integer> l2 = new ArrayList();

      l1.addAll(back.subList(0, s));
      Collections.reverse(l1);

      for (int i : front) {
        l1.add(i);
      }

      l2.addAll(back.subList(s, back.size()));
      front.clear();

      for (int i = 0; i < l1.size(); i++) {
        front.push(l1.get(i));
      }

      back.clear();
      for (int i = 0; i < l2.size(); i++) {
        back.push(l2.get(i));
      }

    }
    if (((3 * back.size() < front.size()) && back.size() > 0) || (back.size() == 0 && front.size() >= 2)) {
      int s = front.size() - n / 2;
      ArrayList<Integer> l1 = new ArrayList();
      ArrayList<Integer> l2 = new ArrayList();

      l1.addAll(front.subList(s, front.size()));
      l2.addAll(front.subList(0, s));
      Collections.reverse(l2);

      for (int i : back) {
        l2.add(i);
      }

      front.clear();

      for (int i = 0; i < l1.size(); i++) {
        front.push(l1.get(i));
      }

      back.clear();
      for (int i = 0; i < l2.size(); i++) {
        back.push(l2.get(i));
      }
    }
  }

  public void addFirst(Integer x) {
    balance();
    front.push(x);
  }

  public void addLast(Integer x) {
    balance();
    back.push(x);
  }

  public Integer removeFirst() {
    if (front.size() <= 0 && back.size() <= 0) {
      return null;
    }

    if (front.size() <= 0 && back.size() > 0) {
      balance();
      if (back.size() == 1 && front.size() <= 0) {
        return back.pop();
      }

      else {
        balance();
        return front.pop();
      }
    }

    else {
      balance();
      return front.pop();
    }

  }

  public Integer removeLast() {
    if (back.size() <= 0 && front.size() <= 0) {
      return 0;
    }

    else if (back.size() <= 0 && front.size() > 0) {
      balance();
      if (front.size() == 1 && back.size() <= 0) {
        return front.pop();
      }

      else {
        balance();
        return back.pop();
      }
    } else {
      balance();
      return back.pop();
    }

  }

  public Integer max() {

    if (back.max() == null && front.max() == null) {
      return null;
    }

    if (back.max() == null && front.max() != null) {
      return front.max();
    }

    if (back.max() != null && front.max() == null) {
      return back.max();
    }

    if (front.max() > back.max()) {
      return front.max();
    } else {
      return back.max();
    }

  }

  public long ksumFirst(int k) {

    if (k < front.size()) {
      return front.ksumalt(k);
    } else {
      return front.ksumalt((front.size())) + back.sumget(k - front.size() - 1);
    }

  }

  public long ksumLast(int k) {
    if (k < back.size()) {
      return back.ksumalt(k);
    } else {
      return back.ksumalt((back.size())) + front.sumget(k - back.size() - 1);
    }
  }

  public int size() {
    return front.size() + back.size();
  }

  public Iterator<Integer> iterator() {
    ArrayList Iterator01 = new ArrayList();
    for (int i = 0; i < front.size(); i++) {
      Iterator01.add(front.subList(0, front.size()).get((front.size() - i) - 1));
    }

    for (int j : back.subList(0, back.size())) {
      Iterator01.add(j);
    }
    return (Iterator01.iterator());
  }
}