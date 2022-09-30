let id = document.getElementById('altera').value;

function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function consultarClientePeloID(){
    let dados = fazerGet("http://127.0.0.1:5000/clientes/"+id);
    console.log("Retonar dados do cliente no Back!!!");
    cliente = JSON.parse(dados);
    console.log(cliente);

    nome = document.createElement('<input id="nome" class="nome" type="text" placeholder=" ' + cliente.nome +' "></input>');

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

function atualizarUsuario() {

    let url = "http://127.0.0.1:5000/clientes";
    let nome = document.getElementById('nome').value;
    let email = document.getElementById('email').value;
    let cpf = document.getElementById('cpf').value;
    let tel = document.getElementById('tel').value;
    let mensagem = document.querySelector('p');
    
    if(nome === '' || email === '' || cpf === ''|| tel === ''){
        event.preventDefault();
        mensagem.textContent = "Preencher todos os campos por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Usuário cadastrado com sucesso! Continue cadastrar seu endereço por favor!";
        /*setTimeout(function(){
            window.location.href = 'cadastroEndereco.html';
       }, 2000);*/
        
    }
  
    let body = {
        "idCliente":id,
        "nome": nome,
        "email": email,
        "cpf": cpf,
        "telefone1": tel,
    }

    fazerPut (url, body);
}