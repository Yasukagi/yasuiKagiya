package com.yasukagi.comparator;

import com.yasukagi.dao.Game;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReleaseDiscountCompTest {

  private Game game1 = mock(Game.class);
  private Game game2 = mock(Game.class);

  private DateTime today;
  private ReleaseDiscountComp releaseDiscountComp;
  @Before
  public void setUp() {
    //基準となる日
    today = new DateTime(2016, 6, 6, 0, 0);

    //テスト対象クラスの生成
    releaseDiscountComp = new ReleaseDiscountComp(today);
  }

  @Test
  public void compareSamePriority() {
    //リリース日と割引率の設定
    when(game1.getReleaseDate()).thenReturn(new DateTime(2016, 6, 1, 0, 0));
    when(game1.getDiscountRate()).thenReturn(new BigDecimal("0.80"));

    when(game2.getReleaseDate()).thenReturn(new DateTime(2016, 6, 1, 0, 0));
    when(game2.getDiscountRate()).thenReturn(new BigDecimal("0.80"));
    assertThat(releaseDiscountComp.compare(game1, game2), is(0));
  }
}