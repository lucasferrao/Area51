
const server = '';
//quando inicia a página faz
window.onload = function () {
    //chama a função para atualizar os users

    //refreshUser(); //adicionar função de validação ao formulário
    validator();


    document.getElementById("formLogin").onsubmit = function (e) {
        //validação do formulário ao submeter
        console.log("ola");
        validator();
    };

    const btn_login = document.getElementById("btn_login")
    btn_login.addEventListener("click", function() {
        const username = document.getElementById("id_officer_login").value;
        const password = document.getElementById("login_password").value;

        console.log(username);
        console.log(password);

        fetch('', {
            //fetch(`${url}/signin`, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            method: 'POST',
            body: `username=${username}&password=${password}`
        }).then(function (response) {
            if (!response.ok) {
                console.log(response.status); //=> number 100–599
                console.log(response.statusText); //=> String
                console.log(response.headers); //=> Headers
                console.log(response.url); //=> String
            } else {
                document.getElementById("id_officer_login").reset(); //limpeza dos dados do form
                const valor = permissoes(`${username}`);
                console.log(valor);
                if(valor) {
                    window.location.replace("")
                }
                else {}
            }
        }).then(function (result) {
            console.log(result);
        }).catch(function (err) {
            alert("Erro no login!" + err); console.error(err);
        });
    });


    /*function permissoes(username) {
        async function fetchAsync() {
            //const username = document.getElementById("id_officer_login").value;
            let txt = [];
            const response = await fetch('');
            const user_profile = await response.json();
            let i=0;
            console.log(this.email);
            for (const user of user_profile) {
                if(user.email == email) {
                    sessionStorage.token = user.email;
                    console.log(sessionStorage.token);
                    if(user.id_login_type == 4) {
                        txt[i] = 1;
                        console.log(user.id_login_type);
                        console.log(user.email);
                        console.log(txt[i]);
                        swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'Login efetuado com sucesso!',
                            text: 'Bem-vindo administrador ' + user.user_profile_name,
                            showConfirmButton: false,
                            timer: 3000
                        })
                            .then(() => {
                                window.location.replace("../view/Statistics.html")} )
                    }
                    else {
                        if(user.id_login_type != 4) {
                            swal.fire({
                                position: 'center',
                                type: 'success',
                                title: 'Login efetuado com sucesso!',
                                text: 'Bem-vindo utilizador ' + user.user_profile_name,
                                showConfirmButton: false,
                                timer: 3000
                            })
                                .then(() => {
                                    window.location.replace("../view/index.html")} )
                        }
                        else{
                            txt[i] = 0;
                            i++;
                        }
                    }
                }
            }
            console.log(txt);


        }
        //chama a função fetchAsync()
        fetchAsync().then(data => console.log("ok")).catch(reason => console.log(reason.message));

    }*/
}