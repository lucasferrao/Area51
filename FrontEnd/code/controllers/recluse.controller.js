const server = '';
window.onload = function ()
{
    alert("pagina carregada com sucesso, verifique os seus dados pessoais.")
    refreshRecluse();
    validator();
    document.getElementById("formUser").onsubmit= function(e){
        //form validation
        validator();
    }
}
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
    //debugging
    //send data to server via POST and PUT
    fetch(server,
        {
            headers:
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
/*

function refreshRecluse() {
    async function fetchAsync() {
        const renderRecluse = document.getElementById("result");
        let txt = "";
        const response = await fetch(server,);
        const recluses = await response.json();


        //results table

        txt += "<table class='table' style='padding:10px; width:70%; margin:0% 15% 0% 15%'>";
        txt += "<thead style='background-color:#607d8b; color:white '>";
        txt += "<tr><th>Nome</th><th>Email</th><th>Morada</th><th>Palavra-Passe</th></tr></thead><tbody>";

        //tab creation
        for (const recluse of recluses) {
            txt += "<tr><td style='text-align:right'>" + recluse.mobile_number + "</td><td>" + recluse.nif + "</td><td>" +
                recluse.nib + "</td></tr>" + "</td><td>" + recluse.is_active + "</td><td>" + "</td><td>" + recluse.id_manager + "</td><td>" + "</td><td>" + recluse.id_user_profile + "</td><td>";
        }
        txt += "</tbody></table>";
        renderRecluse.innerHTML = txt;
    }
    fetchAsync().then(data => console.log("ok")).catch(reason => console.log(reason.message));
}
*/