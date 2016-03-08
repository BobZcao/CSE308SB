$(document).ready(function(){
  $('.header').load("header.html");
  $('.navigation').load("nav.html");
  $('.banner').load("banner.html");
  $('.searchbar').load("searchbar.html");
  $('.gallery').load("gallery.html");
  $('.footer').load("footer.html");
  $('.nav_afterlogin').load("nav_afterlogin.html");
  
  /*this part is the mem login panel. the corresponding panel is goint to be
   *loaded when you click each tab.
   */
  $('#on_hold').click(function(){
      $('.member_panel').load("member_panel/on_hold.html");
  });
  
  $('#checked_out').click(function(){
      $('.member_panel').load("member_panel/checked_out.html");
  });
  
  $('#balance').click(function(){
      $('.member_panel').load("member_panel/balance.html");
  });
  
  $('#borrowing_history').click(function(){
      $('.member_panel').load("member_panel/borrowing_history.html");
  });
  
  //this part scripts is for admin panel display
  //message panel will be displayed innitially
  $('.admin_panel').load("admin_panel/messages.html");
  $('.publisher_panel').load("publisher_panel/edit_book_description.html");
  $('#messages').click(function(){
      $('.admin_panel').load("admin_panel/messages.html");
  });
  
  $('#best_seller_list').click(function(){
      $('.admin_panel').load("admin_panel/best_seller_list.html");
  });
  
  $('#manage_users').click(function(){
      $('.admin_panel').load("admin_panel/manage_users.html");
  });
  
  $('#manage_books').click(function(){
      $('.admin_panel').load("admin_panel/manage_books.html");
  });
  $('#book_application').click(function(){
      $('.publisher_panel').load("publisher_panel/book_application.html");
  });
   $('#edit_book_description').click(function(){
      $('.publisher_panel').load("publisher_panel/edit_book_description.html");
  });
  
  
  //this part is loading the faculty panel display  
  $('.faculty_panel').load("faculty_panel/messages.html");
  
  $('#faculty_messages').click(function(){
      $('.faculty_panel').load("faculty_panel/messages.html");
  });
  
  $('#faculty_best_seller_list').click(function(){
      $('.faculty_panel').load("admin_panel/best_seller_list.html");
  });
  
  $('#faculty_manage_users').click(function(){
      $('.faculty_panel').load("faculty_panel/manage_users.html");
  });
  
  $('#faculty_manage_books').click(function(){
      $('.faculty_panel').load("faculty_panel/manage_books.html");
  });
  
  
});
