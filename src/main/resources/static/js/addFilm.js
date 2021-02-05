$(".addCategorie").on("click", function(){
    showModal("Categorie");
});

$(document).on("click", ".btAddCategorie", function(){
    var nom = $("[name='nomCategorie']").val();
    if (nom !== ""){
        $.ajax({
            url: '/addCategorie',
            type: 'POST',
            data: 'label='+nom,
            success: function (data) {
                $(".categorieSelect option").remove();
                for (var i = 0; i < data.length; i++){
                    if (data[i]["label"] == nom){
                        $(".categorieSelect").append("<option value='"+data[i]["idCategorie"]+"' selected>"+data[i]["label"]+"</option>");
                    }else{
                        $(".categorieSelect").append("<option value='"+data[i]["idCategorie"]+"'>"+data[i]["label"]+"</option>");
                    }
                }
                hideModal();
            }
        });
    }
});

$(document).on("click", ".btAddParticipant", function(){
    var nom = $("[name='nomParticipant']").val();
    var prenom = $("[name='prenomParticipant']").val();
    if (nom !== "" && prenom !== ""){
        $.ajax({
            url: '/addParticipant',
            type: 'POST',
            data: {
                nom: nom,
                prenom: prenom
            },
            success: function () {
                window.location.reload();
            }
        });
    }
});

$(".addRealisateur, .addActeur").on("click", function(){
    showModal("Participant");
});

$(document).on("click", ".btCancel", function(){
    hideModal();
});

function showModal(model){
    $.ajax({
        url: '/showPopup/'+model,
        type: 'GET',
        success: function (data) {
            $(".blackFilter").fadeIn();
            $(".popin").html(data);
        }
    });
}

function hideModal(){
    $(".blackFilter").fadeOut();
    setTimeout(function (){$(".popin").html("");}, 500);
}