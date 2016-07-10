package com.yasukagi.comparator;

import com.yasukagi.dao.Game;
import com.yasukagi.utils.Configure;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Comparator;

/**
 * {@link com.yasukagi.dao.Game}のリストをリリース日と割引率を見てソートするComparator
 * (現在日時とリリース日の誤差日数 * 重み1) + (割引率 * 重み2) の高い順にソートする
 * 重みは設定ファイルで編集可能とすることで，チューニング可能になっている
 *
 * 重みが両者とも1の場合，
 * リリース日 : 割引率 = 100 : 1の関係となる (100日の誤差と割引率1%の違いが等価)
 * なので，割引率の重みは基本的に高めに設定するべき
 */
public class ReleaseDiscountComp implements Comparator<Game> {

  private static final Configure config = new Configure("sort_algorithm.properties");
  private final DateTime today;

  /**
   * 今日の日付を引数に渡す．
   * リリース日と比較するために，基準となる日付が必要
   * @param today 今日(リリース日との基準となる日)
   */
  public ReleaseDiscountComp(DateTime today) {
    super();
    this.today = today;
  }

  @Override
  public int compare(Game o1, Game o2) {
    //TODO : 優先度付の処理を別クラスに切り出しても良いかもしれない
    int dayDiff1 = Days.daysBetween(today, new DateTime(o1.getReleaseDate())).getDays();
    double discountRate1 = o1.getDiscountRate().doubleValue();
    Double priority1 = dayDiff1 * config.getDoubleConfig("release.weight") + discountRate1 * config.getIntConfig("discount.weight");

    int dayDiff2 = Days.daysBetween(today, new DateTime(o2.getReleaseDate())).getDays();
    double discountRate2 = o2.getDiscountRate().doubleValue();
    Double priority2 = dayDiff2 * config.getDoubleConfig("release.weight") + discountRate2 * config.getIntConfig("discount.weight");

    return priority1.compareTo(priority2);
  }
}
