$(function() {

    // $(".clse-btn").click(function(){
    //     $(this).parents().children("#category-content").slideToggle();
    // });

    // 인기 순위
    $(".slide1 .ranklist").click(function(){
      $(this).children(".extends").addClass("extendsOn");
      $(".slide1 .ranklist").not($(this)).children(".extends").removeClass("extendsOn");

    });

    $(".slide2 .ranklist").click(function(){
      $(this).children(".extends").addClass("extendsOn");
      $(".slide2 .ranklist").not($(this)).children(".extends").removeClass("extendsOn");

    });

    $(".slide3 .ranklist").click(function(){
      $(this).children(".extends").addClass("extendsOn");
      $(".slide3 .ranklist").not($(this)).children(".extends").removeClass("extendsOn");

    });

    $(".slide4 .ranklist").click(function(){
      $(this).children(".extends").addClass("extendsOn");
      $(".slide4 .ranklist").not($(this)).children(".extends").removeClass("extendsOn");

    });

    $(".slide5 .ranklist").click(function(){
      $(this).children(".extends").addClass("extendsOn");
      $(".slide5 .ranklist").not($(this)).children(".extends").removeClass("extendsOn");

    });
    
    // 슬라이드
    var freeswiper = new Swiper(".myFreeSwiper", {
    slidesPerView: 6.2,
    spaceBetween: 0,
    freeMode: true,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },

  });

  // 책 추천 섹션

  var swiper = new Swiper(".mySwiperRecommend", {
    slidesPerView: 3,
    spaceBetween: 30,
    freeMode: true,
    pagination: {
      el: ".swiper-pagination",
      type: "fraction",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });

  var swiper = new Swiper(".mySwiperAuthor", {
    slidesPerView: 3,
    spaceBetween: 30,
    freeMode: true,
    pagination: {
      el: ".swiper-pagination",
      type: "fraction",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
  

  var swiper = new Swiper(".mySwiperRank", {
    slidesPerView: 3,
    spaceBetween: 5,
    freeMode: true,
    pagination: {
      el: ".swiper-pagination",
      type: "fraction",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });

  $(".bookshelf .c-btn").click(function(){
    let c = $('#category-content-a').html();
    $("#category-content").html(c);
  });


});