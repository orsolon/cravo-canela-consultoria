function fazerGet(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}


function inserirDadosNaTela(pedido) {
    console.log(pedido);
    coluna = document.createElement("td");
    trIdPedido = document.createElement("tr");
    trDataPedido = document.createElement("tr");
    trHorarioPedido = document.createElement("tr");
    trQuantAnimal = document.createElement("tr");
    trHorarioBusca = document.createElement("tr");
    trHorarioEntrega = document.createElement("tr");
    trStatus = document.createElement("tr");
    trPrecoInicial = document.createElement("tr");
    trPrecoFinal = document.createElement("tr");
    trDesconto = document.createElement("tr");
    trTempoExecucao = document.createElement("tr");
    trFormaPagto = document.createElement("tr");
    trCliente = document.createElement("tr");
    trItens = document.createElement("tr");

    trIdPedido.innerHTML = "Id do pedido: " + pedido.idPedido;
    trDataPedido.innerHTML = "Data do pedido: " + pedido.dataPedido;
    trHorarioPedido.innerHTML = "Horário: " + pedido.horarioPedido;
    trQuantAnimal.innerHTML = "Qt Animais: " + pedido.quantAnimal;
    trHorarioBusca.innerHTML = "Horário de Busca: " + pedido.horarioBusca;
    trHorarioEntrega.innerHTML = "Horário de Retirada: " + pedido.horarioEntrega;
    trStatus.innerHTML = "Status Pedido: " + pedido.status;
    trPrecoInicial.innerHTML = "Preço Inicial: R$ " + pedido.precoInicial;
    trPrecoFinal.innerHTML = "Preço Final: R$ " + pedido.precoFinal;
    trDesconto.innerHTML = "Desconto: R$ " + pedido.desconto;
    trTempoExecucao.innerHTML = "Tempo de execução" + pedido.tempoExecucao;
    trFormaPagto.innerHTML = "Forma de Pgto" + pedido.formaPagto;

    
    coluna.appendChild(trIdPedido);
    coluna.appendChild(trDataPedido);
    coluna.appendChild(trHorarioPedido);
    coluna.appendChild(trQuantAnimal);
    coluna.appendChild(trHorarioBusca);
    coluna.appendChild(trHorarioEntrega);
    coluna.appendChild(trStatus);
    coluna.appendChild(trPrecoInicial);
    coluna.appendChild(trPrecoFinal);
    coluna.appendChild(trDesconto);
    coluna.appendChild(trTempoExecucao);
    coluna.appendChild(trFormaPagto);
    coluna.appendChild(trCliente);
    coluna.appendChild(trItens);


    return coluna;
}

function main() {

    /*let data1 = fazerGet("http://127.0.0.1:5000/clientes");
    clientes = JSON.parse(data1);
    console.log(clientes);

    clientes.forEach(element => {
        if(element.idCliente === 1){
            console.log(element);
        }
    });*/

   
    let data = fazerGet("http://127.0.0.1:5000/pedidos");
    pedidos = JSON.parse(data);
    console.log(pedidos);

    let tabela = document.getElementById("Pedido");
    pedidos.forEach(element => {
        if(element.idPedido === 1){
            let coluna = inserirDadosNaTela(element);
            tabela.appendChild(coluna);
        }
        

    });
    
}

main();