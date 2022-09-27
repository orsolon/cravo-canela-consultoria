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
  
    let body = {
        "nome": nomePet,
        "raca": raca,
        "peso": peso,
        "tipo": opcaoAnimal,
        "porte": opcaoPorte
    }

    fazPost (url, body) 
}