function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function fazerPost(url, body) {
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

function cadastrarEndereco() {
    // Mapear o ID do cliente para salvar o endereço:
    let meuCliente = ultimoCliente();

    let urlEndereco = "http://127.0.0.1:5000/enderecos";
    let cep = document.getElementById('cep').value;
    let rua = document.getElementById('rua').value;
    let numero = document.getElementById('numero').value;
    let complemento = document.getElementById('complemento').value;
    let bairro = document.getElementById('bairro').value;
    let cidade = document.getElementById('cidade').value;
    let estado = document.getElementById('estado').value;
    let mensagem = document.querySelector('p');

    if(cep === '' || rua === '' || numero === '' || bairro === ''|| cidade === '' || estado === ''){
        event.preventDefault();
        mensagem.textContent = "Campos CEP, Rua, Número, Bairro, Cidade e Estado são obrigatórios. Preencha por favor!";
        setTimeout(function(){
            window.location.href = 'cadastroPet.html';
       }, 2000);
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Endereço cadastrado com sucesso! Continue cadastrar seu animal por favor!";
        setTimeout(function(){
            window.location.href = 'cadastroPet.html';
       }, 2000);

    }
  
    let body = {
        "cep": cep,
        "rua": rua,
        "numero": numero,
        "complemento": complemento,
        "bairro": bairro,
        "cidade": cidade,
        "estado": estado,
        "cliente": {
            "idCliente": meuCliente
        }
    }

    fazerPost (urlEndereco, body);
}

function ultimoCliente() {
    let data = fazerGet("http://127.0.0.1:5000/clientes");
    usuarios = JSON.parse(data);
    
    let contador = -1;
    
    usuarios.forEach(element => {
        contador = contador + 1;

    });
    let idCliente = usuarios[contador].idCliente;
    console.log("O ID do último cliente na lista:")
    console.log(idCliente);
    return idCliente;
}

ultimoCliente();
console.log(typeof ultimoCliente());