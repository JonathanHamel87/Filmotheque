$(document).ready(function(){
   $(".ligneFilm").on("click", function(){
       let idFilm = $(this).find(".idFilm").text();
       window.location.href = "/detail/"+idFilm;
   });

   $(".btUpdate, .btDelete").on("click", function(e){
       e.stopPropagation();
   });
});