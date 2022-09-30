//Obter todos os clientes no banco de dados
function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function inserirDadosNaTela(usuario) {
    console.log(usuario);
    lista = document.createElement("ul");
    tdID = document.createElement("li");
    tdNome = document.createElement("li");
    //tdEmail = document.createElement("li");
    //tdCpf = document.createElement("li");
    //tdTelefone1 = document.createElement("li");
    tdPulaLinha = document.createElement("h2");
    //tdIdEndereco = document.createElement("td");

    tdID.innerHTML = "ID: " + usuario.idCliente;
    tdNome.innerHTML = "Nome: " + usuario.nome;
    //tdEmail.innerHTML = "Email: " + usuario.email;
    //tdCpf.innerHTML = "CPF: " + usuario.cpf;
    //tdTelefone1.innerHTML = "Telefone: " + usuario.telefone1;
    tdPulaLinha.innerHTML = "";
    //tdIdEndereco.innerHTML = usuario.listaEndereco;

    lista.appendChild(tdID);
    lista.appendChild(tdNome);
    //lista.appendChild(tdEmail);
    //lista.appendChild(tdCpf);
    //lista.appendChild(tdTelefone1);
    lista.appendChild(tdPulaLinha);
    //linha.appendChild(tdIdEndereco);

    return lista;
}

function dadosCliente() {
    let data = fazerGet("http://127.0.0.1:5000/clientes");
    usuarios = JSON.parse(data);
    console.log(usuarios);

    let tabela = document.getElementById("usuarios");
    usuarios.forEach(element => {
        let lista = inserirDadosNaTela(element);
        tabela.append(lista);
       
    });
    
}



dadosCliente();
