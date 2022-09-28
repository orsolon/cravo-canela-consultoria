function fazPost(url, body) {
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
    event.preventDefault();
    let url = "";
    let nomePet = document.getElementById('nomePet').value;
    let raca = document.getElementById('raca').value;
    let peso = document.getElementById('peso').value;
    let select = document.getElementById('animal')
    let opcaoAnimal = select.options[select.selectedIndex].value;
    let selectP = document.getElementById('porte');
    let opcaoPorte = selectP.options[select.selectedIndex].value;

    if(nomePet === '' || raca === '' || peso === ''){
        event.preventDefault();
        mensagem.textContent = "Campos Nome, Raça e Peso são obrigatórios. Preencha por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Animal cadastrado com sucesso! Clicar Login para executar o acesso!";
        
    }
  
    let body = {
        "nome": nomePet,
        "raca": raca,
        "peso": peso,
        "tipo": opcaoAnimal,
        "porte": opcaoPorte,
        "cliente":{
            "idCliente": null
        }
    }

    fazPost (url, body) 
}