/**
 * smo_slider (smooth_slider)
 * jQueryプラグイン
 * よくあるスライドショー．．．
 */
;(function ($, window, undefined) {
  "use strict";
  var Modernizr = window.Modernizr;

  $.SmoSlider = function (options, element) {
    this.$el = $(element);
    this._init(options);
  };

  $.SmoSlider.defaults = {
    speed: 500,
    easing: 'ease'
  };

  $.SmoSlider.prototype = {
    _init: function (options) {

    },
    _config: function () {

    },
    _initEvents: function () {

    },
    _navigate: function (direction) {

    },
    _slide: function () {

    },
    _toggleNavControls: function () {

    },
    _jump: function (position) {

    },
    destroy: function () {

    }
  };

  var logError = function (message) {
    if (window.console) {
      window.console.error(message);
    }
  };

  $.fn.SmoSlider = function(options) {
    if (typeof options === 'string') {
      var args = Array.prototype.slice.call(arguments, 1);
      this.each(function() {
        var instance = $.data(this, 'smoSlider');
        if (!instance) {
          logError("cannnot call smoSlider" + options);
          return;
        }
        if (!$.isFunction(instance[options]) || options.charAt(0) === "_") {
          logError("no such method" + options);
          return;
        }
        instance[options].apply(instance, args);
      });
    } else {
      this.each(function() {
        var instance = $.data(this, 'smoSlider');
        if (instance) {
          instance._init();
        } else {
          instance = $.data(this, 'moSlider', new $.SmoSlider(options, this));
        }
      })
    }
    return this;
  };
})(jQuery, window);