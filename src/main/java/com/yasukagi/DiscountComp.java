package com.yasukagi;

import com.yasukagi.dao.Game;

import java.util.Comparator;

/**
 * {@link com.yasukagi.dao.Game}のリストを割引率の高い順にソートするComparator
 */
public class DiscountComp implements Comparator<Game> {

  @Override
  public int compare(Game o1, Game o2) {
    return o1.getDiscountRate().compareTo(o2.getDiscountRate());
  }
}
