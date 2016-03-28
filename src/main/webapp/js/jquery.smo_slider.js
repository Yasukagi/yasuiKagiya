/**
 * smo_slider (smooth_slider)
 * jQueryプラグイン
 * よくあるスライドショー．．．
 * usage:
 * $(selector).smoSlider([options]);
 *
 * options : {
 * speed : 500,
 * easing : 'ease'
 * }
 */
;(function ($, window, undefined) {
  "use strict";
  var Modernizr = window.Modernizr;

  /**
   * SmoSliderを初期化する
   * @param options オプションパラメータ
   * @param element 選択している要素．jQueryオブジェクトで保持する
   * @constructor
   */
  $.SmoSlider = function (options, element) {
    this.$el = $(element);
    this._init(options);
  };

  /**
   * オプション指定が無い場合のデフォルト値
   * speed: スライドするスピード．値が小さいほうが早い
   * easing: アニメーションの変化． ease、linear、ease-in、ease-out、ease-in-outなど設定
   * @type {{speed: number, easing: string}}
   */
  $.SmoSlider.defaults = {
    speed: 500,
    easing: 'ease'
  };

  /**
   *
   * @type {{_init: $.SmoSlider._init, _config: $.SmoSlider._config, _initEvents: $.SmoSlider._initEvents, _navigate: $.SmoSlider._navigate, _slide: $.SmoSlider._slide, _toggleNavControls: $.SmoSlider._toggleNavControls, _jump: $.SmoSlider._jump, destroy: $.SmoSlider.destroy}}
   */
  $.SmoSlider.prototype = {
    _init: function (options) {
      //デフォルト値と設定したオプションの再帰的マージ
      this.options = $.extend(true, {}, $.SmoSlider.defaults, options);
      this._config();
      this._initEvents();
    },
    _config: function () {
      this.$list = this.$el.children('ul');
      this.$items = this.$list.children('li');
      this.itemsCount = this.$items.length;
      this.support = Modernizr.csstransitions && Modernizr.csstransforms;
      this.support3d = Modernizr.csstransform3d;

      var transProperties = {
        'WebkitTransition' : { transitionEndEvent : 'webkitTransitionEnd', transformName : '-webkit-transform' },
        'MozTransition' : { transitionEndEvent : 'transitionend', transformName : '-moz-transform' },
        'OTransition' : { transitionEndEvent : 'oTransitionEnd', transformName : '-o-transform' },
        'msTransition' : { transitionEndEvent : 'MSTransitionEnd', transformName : '-ms-transform' },
        'transition' : { transitionEndEvent : 'transitionend', transformName : 'transform' }
      };
      if (this.support) {
        this.transEndEventName = transProperties[ Modernizr.prefixed( 'transition' ) ].transitionEndEvent + '.smoSlider';
        this.transformName = transProperties[ Modernizr.prefixed( 'transition' ) ].transformName;
      }

      this.current = 0;
      this.old = 0;
      this.isAnimating = false;
      this.$list.css('width', 100 * this.itemsCount + '%');

      if (this.support) {
        this.$list.css('transition', this.transformName + ' ' + this.options.speed + 'ms' + ' ' + this.options.easing);
      }

      this.$items.css('width', 100 / this.itemsCount + '%');

      if (this.itemsCount > 1) {
        this.$navPrev = $('<span class="smo-slider-prev"></span>');
        this.$navNext = $('<span class="smo-slider-next"></span>');
        //<タグ/>をセレクタに与えると，タグを新たに生成する
        $('<nav/>').append(this.$navPrev, this.$navNext).appendTo(this.$el);

        var dots = '';
        for (var i = 0; i < this.itemsCount; ++i) {
          var dot = i === this.current ? '<span class="smo-slider-current"></span>' : '<span></span>';
          dots += dot;
        }
        var navDots = $('<div class="smo-slider-dots"/>').append(dots).appendTo(this.$el);
        this.$navDots = navDots.children('span');
      }

    },
    _initEvents: function () {
      var self = this;
      if (this.itemsCount > 1) {
        this.$navPrev.on('click.smoSlider', $.proxy(this._navigate, this, 'previous'));
        this.$navNext.on('click.smoSlider', $.proxy(this._navigate, this, 'next'));
        this.$navDots.on('click.smoSlider', function() {self._jump($(this).index());});
      }
    },
    _navigate: function (direction) {
      if (this.isAnimating) {
        return false;
      }

      this.isAnimating = true;

      this.old = this.current;
      if (direction === 'next') {
        this.current < this.itemsCount -1 ? ++this.current : this.current = 0;
      }
      if (direction === 'previous') {
        this.current > 0 ? --this.current : this.current = this.itemsCount -1;
      }

      this._slide();
    },
    _slide: function () {
      this.$navDots.eq(this.old).removeClass('smo-slider-current').end().eq(this.current).addClass('smo-slider-current');

      var translateVal = -1 * this.current * 100 / this.itemsCount;
      if (this.support) {
        this.$list.css('transform', this.support3d ?
        'translate3d(' + translateVal + '%, 0,0)' :
        'translate(' + translateVal + '%)');
      } else {
        this.$list.css('margin-left', -1 * this.current * 100 + '%');
      }

      var transitionendfn = $.proxy(function() {
        this.isAnimating = false;
      }, this);

      if (this.support) {
        this.$list.on(this.transEndEventName, $.proxy(transitionendfn, this));
      } else {
        transitionendfn.call();
      }
    },
    _jump: function (position) {
      if (position === this.current || this.isAnimating) {
        return false;
      }
      this.isAnimating = true;
      this.old = this.current;
      this.current = position;
      this._slide();
    },

    destroy: function () {
      if (this.itemsCount > 1) {
        this.$navPrev.parent().remove();
        this.$navDots.parent().remove();
      }
      this.$list.css('width', 'auto');
      if (this.support) {
        this.$list.css('transition', 'none');
      }
      this.$items.css('width', 'auto');
    }
  };
  /**
   * ログ出力メソッド
   * @param message 出力したいメッセージ
   */
  var logError = function (message) {
    if (window.console) {
      window.console.error(message);
    }
  };

  /**
   * プラグイン定義
   * @param options オプションパラメータ．スライダーの振る舞いを変更する．設定値はdefaultsオブジェクトを参照
   * @returns {$.fn.smoSlider}
   * @constructor
   */
  $.fn.smoSlider = function(options) {
    this.each(function() {
      var instance = $.data(this, 'smoSlider');
      if (instance) {
        instance._init();
      } else {
        $.data(this, 'smoSlider', new $.SmoSlider(options, this));
      }
    });
    return this;
  };
})(jQuery, window);