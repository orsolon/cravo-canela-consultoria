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

function cadastrarEndereco() {
    
    let url = "";
    let cep = document.getElementById('cep').value;
    let rua = document.getElementById('rua').value;
    let numero = document.getElementById('numero').value;
    let complemento = document.getElementById('complemento').value;
    let bairro = document.getElementById('bairro').value;
    let cidade = document.getElementById('cidade').value;
    let estado = document.getElementById('estado').value;

    if(cep === '' || rua === '' || numero === '' || bairro === ''|| cidade === '' || estado === ''){
        event.preventDefault();
        mensagem.textContent = "Campos CEP, Rua, Número, Bairro, Cidade e Estado são obrigatórios. Preencha por favor!";
        
    }
    else{
        event.preventDefault();
        mensagem.textContent = "Endereço cadastrado com sucesso! Continue cadastrar seu animal por favor!";
        
    }
  
    let body = {
        "cep": cep,
        "rua": rua,
        "numero": numero,
        "complemento": complemento,
        "bairro": bairro,
        "cidade": cidade,
        "estado": estado,
        "cliente"{
            "idCliente": null
        }
    }

    fazPost (url, body);
    
    setTimeout(function(){
        window.location.href = 'cadastroPet.html';
   }, 1000); 
}