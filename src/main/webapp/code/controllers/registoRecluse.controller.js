const serverNewRecluse = '/Area51/newRecluse';
//
 $(document).ready(function()
//$(document).ready(async function()
{
    //alert("pagina carregada com sucesso, verifique os seus dados pessoais.")
    refreshRecluse();
    validator();
    const formUser = document.getElementById('formUser');
    formUser.addEventListener('submit', function (e) {
        e.preventDefault();

        //document.getElementById("formUser").onsubmit= function(e){
        //form validation
        validator();
    });
});
//validation function
function validator()
{
    //validation function executer
    let validar = new validar (document.querySelector('form[name="formUser"]'), function (err, res)
        {
            if (res)
            {
                saveRecluse();
            }
        },
        {
            //check if password is valid
            rules:
                {
                    password: function(value)
                    {
                        return(value === document.getElementById("password").value);
                    }
                },


        });
}

//function save
function saveRecluse()
{
    //store data in the date
    var data = {};
    data.name = document.getElementById("name").value;
    data.address = document.getElementById("address").value;
    data.birth = document.getElementById("birth").value;
    data.contacts = document.getElementById("contacts").value;
    data.disease = document.getElementById("disease").value;
    data.cause = document.getElementById("cause").value;
    data.f = document.getElementById("f").value;
    data.m = document.getElementById("m").value;
    console.log(data);
    //debugg
            //headeing
            //send data to server via POST and PUT
            fetch(server,
                  {rs:
                {
                    'Content-Type': 'application/json'
                },
            method: 'POST',
            body: JSON.stringify(data)
        })

        .then(function (response)
        {
            if (!response.ok)
            {
                console.log(response.status); //=> number 100–599
                console.log(response.statusText); //=> String
                console.log(response.headers); //=> Headers
                console.log(response.url); //=> String

                if (response.status === 409)
                {
                    alert("Duplicated ID");
                }
                else
                {
                    throw Error(response.statusText);
                }
            }
            else
            {
                document.getElementById("formUser").reset(); //reset form data

                alert("submitted with success");
                refreshRecluse();
            }
        }).then(function (result)
    {
        console.log(result);
    }).catch(function (err)
    {
        alert("Submission error");
        console.error(err);
    });
}

function refreshRecluse() {
    async function fetchAsync() {
        const renderRecluse = document.getElementById("result");
        let txt = "";
        const response = await fetch(server,);
        const recluses = await response.json();
        //results table

        txt += "<table class='table' style='padding:10px; width:70%; margin:0% 15% 0% 15%'>";
        txt += "<thead style='background-color:#607d8b; color:white '>";
        txt += "<tr><th>Nome</th><th>Morada</th><th>Data de nascimento</th><th>Contactos</th><th>Doenças</th><th>Causa</th><th>Sexo</th></tr></thead><tbody>";

        //tab creation
        for (const recluse of recluses) {
            txt += "<tr><td style='text-align:right'>" + recluse.id_recluse + "</td><td>" + recluse.recluse_name + "</td><td>" +
                recluse.data_de_nascimento + "</td></tr>" + "</td><td>" + recluse.gênero + "</td><td>" + "</td><td>" + recluse.doença + "</td><td>" + "</td><td>" + recluse.causas + "</td><td>";
        }
        txt += "</tbody></table>";
        renderRecluse.innerHTML = txt;
    }
    fetchAsync().then(data => console.log("ok")).catch(reason => console.log(reason.message));
}
