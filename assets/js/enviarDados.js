
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

function cadastrarUsuario() {
    event.preventDefault();
    let url = "";
    let nome = document.getElementById('nome').value;
    let tel = document.getElementById('tel').value;
    let cpf = document.getElementById('cpf').value;
    let email = document.getElementById('email').value;
    let senha = document.getElementById('senha').value;
  
    let body = {
        "nome": nome,
        "telefone_1": tel,
        "cpf": cpf,
        "email": email,
        "senha": senha
    }

    fazPost (url, body) ;

    setTimeout(function(){
        window.location.href = 'cadastroEndereco.html';
   }, 1000); 
    
}