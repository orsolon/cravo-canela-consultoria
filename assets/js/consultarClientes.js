//Obter todos os clientes no banco de dados
function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function inserirDadosNaTela(usuario) {
    console.log(usuario);
    linha = document.createElement("tr");
    tdNome = document.createElement("td");
    tdEmail = document.createElement("td");
    tdCpf = document.createElement("td");
    tdTelefone1 = document.createElement("td");
    tdIdEndereco = document.createElement("td");

    tdNome.innerHTML = usuario.nome;
    tdEmail.innerHTML = usuario.email;
    tdCpf.innerHTML = usuario.cpf;
    tdTelefone1.innerHTML = usuario.telefone1;
    tdIdEndereco.innerHTML = usuario.listaEndereco;

    linha.appendChild(tdNome);
    linha.appendChild(tdEmail);
    linha.appendChild(tdCpf);
    linha.appendChild(tdTelefone1);
    linha.appendChild(tdIdEndereco);

    return linha;
}

function main() {
    let data = consultarClientes("http://127.0.0.1:5000/clientes");
    usuarios = JSON.parse(data);
    console.log(usuarios);

    let tabela = document.getElementById("tabela");
    usuarios.forEach(element => {
        let linha = inserirDadosNaTela(element);
            tabela.appendChild(linha);

    });
    
}

main();