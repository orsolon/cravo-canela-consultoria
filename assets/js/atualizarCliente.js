//const id = document.getElementById('altera').value;

function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function consultarClientePeloID(){
    let id = document.getElementById('altera').value;
    let dados = fazerGet("http://127.0.0.1:5000/clientes/"+id);
    console.log("Retonar dados do cliente no Back!!!");
    cliente = JSON.parse(dados);
    console.log(cliente);

    liNome = document.getElementById("li1");
    liEmail = document.getElementById("li2");
    liCpf = document.getElementById("li3");
    liTelefone1 = document.getElementById("li4");

    liNome.innerHTML = "Nome: " + cliente.nome;
    liEmail.innerHTML = "E-mail: " + cliente.email;
    liCpf.innerHTML = "CPF: " + cliente.cpf;
    liTelefone1.innerHTML = "Telefone: " + cliente.telefone1;

}

function fazerPut(url, body) {
    console.log("Body", body)
    
    let request = new XMLHttpRequest();
    request.open("PUT", url, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(body));
    console.log("Body: " + JSON.stringify(body))
    request.onload = function () {
        console.log(this.responseText)
    }

    return request.responseText;
    
}

function atualizarCliente() {
    let id = document.getElementById('altera').value;
    let url = "http://127.0.0.1:5000/clientes";
    let nome = document.getElementById('li1').value;
    let email = document.getElementById('email').value;
    let cpf = document.getElementById('cpf').value;
    let tel = document.getElementById('tel').value;
    let senha = document.getElementById('senha').value;
    let mensagem = document.querySelector('p');
    
    if(nome === '' || email === '' || cpf === ''|| tel === '' || senha === ''){
        event.preventDefault();
        mensagem.textContent = "Preencher todos os campos por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Os dados do cliente atulizados com sucesso!!!";
        /*setTimeout(function(){
            window.location.href = 'dadosCliente.html';
       }, 2000);*/
        
    }
  
    let body = {
        "idCliente":id,
        "nome": nome,
        "email": email,
        "senha": senha,
        "cpf": cpf,
        "telefone1": tel,
    }

    fazerPut (url, body);
    window.location.reload();
}