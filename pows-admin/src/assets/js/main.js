jQuery(function ($) {

  // Preloader
  let preloader = $('.preloader');
  $(window).load(function () {
    preloader.remove();
  });

  // #main-slider
  let slideHeight = $(window).height();
  $('#home-slider .item').css('height', slideHeight);

  $(window).resize(function () {
    'use strict';
      $('#home-slider .item').css('height', slideHeight);
  });

  // Scroll Menu
  $(window).on('scroll', function () {
    if ($(window).scrollTop() > slideHeight) {
      $('.main-nav').addClass('navbar-fixed-top');
      $('#home').css('marginTop', 80);

    } else {
      $('.main-nav').removeClass('navbar-fixed-top');
      $('#home').css('marginTop', 0);
    }
  });

  // Navigation Scroll
  $(window).scroll(function () {
    Scroll();
  });

  $('.navbar-collapse ul li a').on('click', function () {
    $('html, body').stop().animate({
      scrollTop: $(this.hash).offset().top - 80
    }, 1000, 'swing');
    return false;
  });

  // User define function

  function Scroll() {
    let contentTop = [];
    let contentBottom = [];
    let winTop = $(window).scrollTop();
    let rangeTop = 200;
    // let rangeBottom = 500;
    $('.navbar-collapse').find('.scroll a').each(
      function () {
        contentTop.push($($(this).attr('href')).offset().top);
        contentBottom.push($($(this).attr('href')).offset().top
          + $($(this).attr('href')).height() + 80);
      });
    $.each(contentTop, function (i) {
      if (winTop > contentTop[i] - rangeTop) {
        $('.navbar-collapse li.scroll').removeClass('active').eq(i)
          .addClass('active');
      }
    })
  }
  $('#tohash').on('click', function () {
    $('html, body').animate({
      scrollTop: $(this.hash).offset().top - 0
    }, 1000, 'swing');
    return false;
  });

  $('#to-toppage').on('click', function () {
    $('html, body').animate({
      scrollTop: $(this.hash).offset().top - 80
    }, 1000);
    return false;
  });

  // Initiat WOW JS
  new WOW().init();
  // smoothScroll
  smoothScroll.init();

  // Progress Bar
  $('#about-us').bind('inview', function (event, visible) {
    if (visible) {
      $.each($('div.progress-bar'), function () {
        $(this).css('width', $(this).attr('aria-valuetransitiongoal') + '%');
      });
      $(this).unbind('inview');
    }
  });

  // Countdown
  $('#features').bind('inview',
    function (event, visible) {
      if (visible) {
        $(this).find('.timer').each(function () {
          let $this = $(this);
          $({
            Counter: 0
          }).animate({
            Counter: $this.text()
          }, {
            duration: 2000,
            easing: 'swing',
            step: function () {
              $this.text(Math.ceil(this.Counter));
            }
          });
        });
        $(this).unbind('inview');
      }
    });

  // Google Map
  // let latitude = $('#google-map').data('latitude')
  // let longitude = $('#google-map').data('longitude')
  // function initialize_map() {
  // 	let myLatlng = new google.maps.LatLng(latitude, longitude);
  // 	let mapOptions = {
  // 		zoom : 14,
  // 		scrollwheel : false,
  // 		center : myLatlng
  // 	};
  // 	let map = new google.maps.Map(document.getElementById('google-map'),
  // 			mapOptions);
  // 	let contentString = '';
  // 	let infowindow = new google.maps.InfoWindow({
  // 		content : '<div class="map-content"><ul class="address">'
  // 				+ $('.address').html() + '</ul></div>'
  // 	});
  // 	let marker = new google.maps.Marker({
  // 		position : myLatlng,
  // 		map : map
  // 	});
  // 	google.maps.event.addListener(marker, 'click', function() {
  // 		infowindow.open(map, marker);
  // 	});
  // }
  // google.maps.event.addDomListener(window, 'load', initialize_map);

});
