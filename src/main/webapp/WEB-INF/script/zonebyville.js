$(document).ready(function () {
    
    $("#ville").change(function () {
             $('#zone').find('option').remove();
                    $('#zone').append('<option>Choisir une zone</option>'); 
                   

                    let cid = $('#ville').val();
                    let data = {
                        operation: "zone",
                        id: cid
                    };

                    $.ajax({
                        url: "ZoneByVilleController",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#zone').append('<option value="' + value.id + '">' + value.name + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#zone').append('<option>zone introuvable</option>');
                        },
                        cache: false
                    });
                });
 });
                

