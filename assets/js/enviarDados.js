
function fazPost(url, body) {
    console.log("Body", body)
    
    let request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(body));
    console.log("Body: " + JSON.stringify(body))
    request.onload = function () {
        console.log(this.responseText)
    }

    return request.responseText;
    
}

function cadastrarUsuario() {
    
    let url = "http://127.0.0.1:5000/clientes";
    let nome = document.getElementById('nome').value;
    let email = document.getElementById('email').value;
    let senha = document.getElementById('senha').value;
    let cpf = document.getElementById('cpf').value;
    let tel = document.getElementById('tel').value;
    let mensagem = document.querySelector('p');
    
    if(nome === '' || email === '' || senha === '' || cpf === ''|| tel === ''){
        event.preventDefault();
        mensagem.textContent = "Preencher todos os campos por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Usuário cadastrado com sucesso! Continue cadastrar seu endereço por favor!";
        
    }
  
    let body = {
        "nome": nome,
        "email": email,
        "senha": senha,
        "cpf": cpf,
        "telefone1": tel,
        "telefone2": null
    }

    fazPost (url, body);
}