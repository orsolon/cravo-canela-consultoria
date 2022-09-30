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

function cadastrarPet() {
    // Mapear o ID do cliente para salvar o endereço:
    let meuCliente = ultimoCliente();

    // Salvar os dados do animal:
    event.preventDefault();
    let urlAnimal = "http://127.0.0.1:5000/animais";
    let nomePet = document.getElementById('nomePet').value;
    let raca = document.getElementById('raca').value;
    let peso = document.getElementById('peso').value;
    let animal = document.getElementById('animal').value
    let porte = document.getElementById('porte').value;
    let mensagem = document.querySelector('p');

    if(nomePet === '' || raca === '' || peso === ''){
        event.preventDefault();
        mensagem.textContent = "Campos Nome, Raça e Peso são obrigatórios. Preencha por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Animal cadastrado com sucesso! Clicar Login para executar o acesso!";
        setTimeout(function(){
            window.location.href = 'minhaconta.html';
       }, 2000);
    }
  
    let body = {
        "nome": nomePet,
        "raca": raca,
        "peso": peso,
        "tipo": animal,
        "porte": porte,
        "cliente":{
            "idCliente": meuCliente
        }
    }

    fazerPost (urlAnimal, body);
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