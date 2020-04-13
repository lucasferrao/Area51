const reclusosServer = '/Area51/recluse';
window.onload = async function () {
    //alert("pagina carregada com sucesso, verifique os seus dados pessoais.")
    let urlParams = new URLSearchParams(window.location.search);
    let recluseId = urlParams.has('id') ? urlParams.get('id') : 1;

    refreshDadosRecluse(recluseId);
    validator();
    $("#aHistoricoVisitas").attr('href', 'visitsperRecluse.html?id=' + recluseId);

    const dadosRecluso = document.getElementById('dadosRecluso');
    dadosRecluso.addEventListener('submit', function (e) {
        e.preventDefault();

        //document.getElementById("dadosRecluso").onsubmit= function(e){
        //form validation
        validator();
    });
    preencherListaDeReclusos();
};

//validation function
function validator() {
    //validation function executer
    // let validar = new validar(document.querySelector('form[name="formUser"]'), function (err, res) {
    //         if (res) {
    //             saveDadosRecluse();
    //         }
    //     },
    //     {
    //         //check if password is valid
    //         rules:
    //             {
    //                 password: function (value) {
    //                     return (value === document.getElementById("password").value);
    //                 }
    //             },
    //
    //
    //     });
}

//function save
function saveDadosRecluse() {
    //store data in the date
    var data = {};
    data.id_recluse = $("#id_recluse").val();
    data.name = $("#recluse_name").val();
    data.birthdate = $("#recluse_birthdate").val();
    data.genre = $("#recluse_genre").val();
    data.cause = $("#recluse_cause").val();
    data.disease = $("#recluse_disease").val();
    data.cell = $("#recluse_cell").val();
    console.log(data);
    //debugg
    // headeing
    //send data to reclusosServer via POST and PUT
    fetch(reclusosServer,
        {
            rs:
                {
                    'Content-Type': 'application/json'
                },
            method: 'POST',
            body: JSON.stringify(data)
        })

        .then(function (response) {
            if (!response.ok) {
                console.log(response.status); //=> number 100–599
                console.log(response.statusText); //=> String
                console.log(response.headers); //=> Headers
                console.log(response.url); //=> String

                if (response.status === 409) {
                    alert("Duplicated ID");
                } else {
                    throw Error(response.statusText);
                }
            } else {
                document.getElementById("formUser").reset(); //reset form data

                alert("submitted with success");
                refreshDadosRecluse();
            }
        }).then(function (result) {
        console.log(result);
    }).catch(function (err) {
        alert("Submission error");
        console.error(err);
    });
}

function refreshDadosRecluse(id) {
    async function fetchAsync() {
        const response = await fetch(reclusosServer + "?id=" + id,);
        const data = await response.json();
        console.log(data);

        $("form #id_recluse").val(data.id_recluse);
        $("form #name").val(data.recluse_name);
        $("form #birthdate").val(data.birthdate);
        $("form #genre").val(data.genre);
        $("form #cause").val(data.cause);
        $("form #disease").val(data.disease);
        $("form #cell").val(data.cell);
    }

    fetchAsync().then(data => console.log("ok")).catch(reason => console.log(reason.message));
}

async function preencherListaDeReclusos() {
    let response = await fetch(reclusosServer);
    let idsReclusos = await response.json();

    let text = "";
    for(let i = 0; i < idsReclusos.length; i++) {
        let id = idsReclusos[i];
        text += '<li><a href="?id=' + id + '">Recluso ' + id + '</a></li>'
    }
    $("#listaDeReclusos").html(text);
}