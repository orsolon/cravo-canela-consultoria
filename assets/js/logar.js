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

function logar() {
    event.preventDefault();
    let url = "";
    let email = document.getElementById('email').value;
    let senha = document.getElementById('senha').value;
  
    let body = {
        "email": email,
        "senha": senha
    }

    fazPost (url, body) 
}