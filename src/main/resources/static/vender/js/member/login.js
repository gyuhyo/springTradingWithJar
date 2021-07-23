$(function() {
   $(".loginBtn").click(() => {
      let postUserData = JSON.stringify({email:$(".lEmail").val(), password: $(".lPass").val()});
      $.ajax({
         url: "//localhost:8081/member/doLogin",
         type: "post",
         dataType: "json",
         contentType: "application/json; charset=utf-8",
         data: postUserData,
         success: (result) => {
            if (result != null) {
               location.reload();
            }
         }
      });
   });
});