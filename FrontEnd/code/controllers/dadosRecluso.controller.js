const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
window.onload = async function ()
{
    //alert("pagina carregada com sucesso, verifique os seus dados pessoais.")
    refreshDadosRecluse();
    validator();
    const dadosRecluso = document.getElementById('dadosRecluso');
    dadosRecluso.addEventListener('submit', function (e) {
        e.preventDefault();

        //document.getElementById("dadosRecluso").onsubmit= function(e){
        //form validation
        validator();
    });
}
//validation function
function validator()
{
    //validation function executer
    let validar = new validar (document.querySelector('form[name="formUser"]'), function (err, res)
        {
            if (res)
            {
                saveDadosRecluse();
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
function saveDadosRecluse()
{
    //store data in the date
    var data = {};
    data.id_recluse = document.getElementById("id_recluse").value;
    data.name = document.getElementById("name").value;
    data.birthdate = document.getElementById("birthdate").value;
    data.genre = document.getElementById("contacts").value;
    data.cause = document.getElementById("cause").value;
    data.disease = document.getElementById("disease").value;
    data.cell = document.getElementById("cell").value;
    console.log(data);
    //debugg
    headeing
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
                refreshDadosRecluse();
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

function refreshDadosRecluse() {
    async function fetchAsync() {
        const renderDadosRecluse = document.getElementById("result");
        let txt = "";
        const response = await fetch(server,);
        const Dadosrecluse = await response.json();
        //results table

        txt += "<table class='table' style='padding:10px; width:70%; margin:0% 15% 0% 15%'>";
        txt += "<thead style='background-color:#607d8b; color:white '>";
        txt += "<tr><th>ID do Recluso</th><th>Nome</th><th>Data de nascimento</th><th>Sexo</th><th>Causa</th><th>Doenças</th><th>Cela</th></tr></thead><tbody>";
        //tab creation
        for (const Dadorecluse of Dadosrecluse) {
            txt += "<tr><td style='text-align:right'>" + Dadorecluse.id_recluse + "</td><td>" + Dadorecluse.recluse_name + "</td><td>" +
                Dadorecluse.birthdate + "</td></tr>" + "</td><td>" + Dadorecluse.genre  + "</td><td>" + "</td><td>" + Dadorecluse.disease  + "</td><td>" + "</td><td>" + Dadorecluse.cause  + "</td><td>"+ "</td><td>" + Dadorecluse.cell  + "</td><td>";
        }
        txt += "</tbody></table>";
        renderDadosRecluse.innerHTML = txt;
}
fetchAsync().then(data => console.og("ok")).catch(reason => console.log(reason.message));
}
