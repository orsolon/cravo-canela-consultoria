function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function fazerLogin() {
    //Salvar os dads de login
    let emailCliente = document.getElementById('email').value;
    let senhaCliente = document.getElementById('senha').value;
    console.log(typeof email);
    let mensagem = document.querySelector('p');

    //Trazer os clientes do BD
    data = fazerGet("http://127.0.0.1:5000/clientes");
    usuarios = JSON.parse(data);
   

    //Validar o acesso do cliente:
    usuarios.forEach(element => {
        console.log(element);
        console.log(typeof element);
        email = element.email;
        senha = element.senha;
        if (email === emailCliente && senha === senhaCliente){
            mensagem.textContent = "LOGIN SUCESSO!";
            console.log(LOGOU);
        }
    

    });

    console.log("Feito Login");
}