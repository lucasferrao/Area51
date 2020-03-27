const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
window.onload = async function ()
{
    //alert("pagina carregada com sucesso, verifique os seus dados pessoais.")
    refreshRegistoOcorrencias();
    validator();
    const registoOcorrencias = document.getElementById('registoOcorrencias');
    registoOcorrencias.addEventListener('submit', function (e) {
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
                saveRegistoOcorrencias();
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
function saveRegistoOcorrencias()
{
    //store data in the date
    var data = {};
    data.id_occurrence = document.getElementById("id_occurrence").value;
    data.date = document.getElementById("mytext").value;
    data.mytext = document.getElementById("mytext").value;
    data.myTextArea = document.getElementById("myTextArea").value;
    data.id_recluse = document.getElementById("id_recluse").value;
    data.id_officer = document.getElementById("id_officer").value;
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
                refreshRegistoOcorrencias();
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

function refreshRegistoOcorrencias() {
    async function fetchAsync() {
        const renderRegistoOcorrencias = document.getElementById("result");
        let txt = "";
        const response = await fetch(server,);
        const RegistoOcorrencias = await response.json();
        //results table

        txt += "<table class='table' style='padding:10px; width:70%; margin:0% 15% 0% 15%'>";
        txt += "<thead style='background-color:#607d8b; color:white '>";
        txt += "<tr><th>ID do Recluso</th><th>Nome</th><th>Data de nascimento</th><th>Sexo</th><th>Causa</th><th>Doenças</th><th>Cela</th></tr></thead><tbody>";
        //tab creation
        for (const RegistoOcorrencia of RegistoOcorrencias) {
            txt += "<tr><td style='text-align:right'>" + RegistoOcorrencia.id_occurrence + "</td><td>" + RegistoOcorrencia.occurrence_description + "</td><td>" +
                RegistoOcorrencia.occurrence_subject + "</td></tr>" + "</td><td>" + RegistoOcorrencia.occurrence_date  + "</td><td>" + "</td><td>" + RegistoOcorrencia.id_recluse  + "</td><td>" + "</td><td>" + Dadorecluse.id_officer  + "</td><td>";
        }
        txt += "</tbody></table>";
        renderRegistoOcorrencias.innerHTML = txt;
    }
    fetchAsync().then(data => console.og("ok")).catch(reason => console.log(reason.message));
}
