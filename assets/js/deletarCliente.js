function fazerDelete(url){
    let request = new XMLHttpRequest();
    request.open("DELETE", url, false);
    request.send();
    return request.responseText;
}

function deletarCliente(){
    let id = document.getElementById('idCliente').value;
    fazerDelete("http://127.0.0.1:5000/clientes/"+id);
    console.log("Cliente deletado");
    window.location.reload();

}

//exibirOpcao();
/*
function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}*/


/*
function inserirNaOpcao(usuario) {
    opcao = document.createElement("option");

    opID.inneHTML = usuario.idCliente;
    opNome.inneHTML = usuario.nome;

    opcao.appendChild(opID);
    opcao.appendChild(opNome);

    return opcao;
}*/

/*
function exibirOpcao() {

    let data = fazerGet("http://127.0.0.1:5000/clientes");
    usuarios = JSON.parse(data);
    console.log(usuarios);

    let selecao = document.getElementById("clientes");
    usuarios.forEach(element => {
            let opcao = element.nome;
            console.log(opcao);
            selecao.append('<option>' + opcao + '</option>');
        })

      
    });
    let usuario = fazerGet("http://127.0.0.1:5000/clientes/1");
    cliente = JSON.parse(usuario);
    let selecao = document.getElementById("clientes");
    let opcao = inserirNaOpcao(cliente);
    selecao.appendChild(opcao);
    
}
*/

