$(document).ready(function() {
​
  var id = $("#id").val();
​
  $.ajax({
    url: '/users/' + id,
    type: 'GET',
    success: function(data) {
​
      $('#first').val(data.firstName);
      $('#last').val(data.lastName);
      $('#username').val(data.username);
      $('#birth').val(data.birth);
    },
    error: function() {
      alert("Error while retrieving User!");
    }
  });
​
  $('#save').click(function(event){
​
    if ( !validateForm() ){
       return;
    }
​
    var id = $("#id").val();
    var first = $("#first").val();
    var last = $("#last").val();
    var username = $("#username").val();
    var birth = $("#birth").val();
​
    $.ajax({
      url: '/users/' + id,
      /*
       * Create a JSON Object with the Form information.
       */
      data: JSON.stringify({
             'idUser': id,
             'firstName': first,
             'lastName': last,
             'username': username,
             'birth': birth
      }),
      type: 'PUT',
      contentType: 'application/json',
      success: function(data) {
        /* alert("The User was updated successfully!"); */
        $(location).attr("href","/list/update");
      },
      error: function() {
        alert("Error while updating User!");
      }
    });
  });
​
  validateForm = function() {
​
    var first = $("#first").val();
    var last = $("#last").val();
    var username = $("#username").val();
​
    if (first.trim()=== "") {
​
      alert("Please, type the First Name!");
​
      $( "#first" ).focus();
      return false;
    }
​
    if (last.trim()=== "") {
​
      alert("Please, type the Last Name!");
​
      $( "#last" ).focus();
      return false;
    }
​
    if (username.trim()=== "") {
​
      alert("Please, type the Username!");
​
      $( "#username" ).focus();
      return false;
    }
​
    return true;
  };
});