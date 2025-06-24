import express from "express";
import fetch from "node-fetch";

const app = express();
const port = 3000;

// Servindo arquivos estáticos da pasta "public"
app.use(express.static("public"));

// Rota para a página principal
app.get("/", (req, res) => {
    res.send(`
        <!DOCTYPE html>
        <html lang="pt-BR">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Pizzaria Supreme</title>
            <link rel="stylesheet" href="../css/estilo.css">
        </head>
        <body>
            <div class="container">
                <h1>Bem-vindo à Pizzaria Supreme!</h1>
                <p>Acesse <a href="/ordens">/ordens</a> para visualizar os pedidos.</p>
            </div>
        </body>
        </html>
    `);
});

// Rota para exibir as ordens de pedido
app.get("/ordens", async (req, res) => {
    try {
        const response = await fetch("http://localhost/Pizzaria_Supreme/backend/listar_pedidos.php");
        const pedidos = await response.json();

        let html = `
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Ordens de Pedido - Pizzaria Supreme</title>
                <link rel="stylesheet" href="../css/estilo.css">
            </head>
            <body>
                <div class="container">
                    <h1>Ordens de Pedido</h1>
                    <div class="cardapio">
        `;

        if (pedidos.length > 0) {
            pedidos.forEach(pedido => {
                html += `
                    <div class="pizza-item">
                        <h3>Pedido #${pedido.pedido_id}</h3>
                        <p><strong>Cliente:</strong> ${pedido.usuario_nome}</p>
                        <p><strong>Pizza:</strong> ${pedido.pizza_nome}</p>
                        <p><strong>Descrição:</strong> ${pedido.pizza_descricao}</p>
                        <p><strong>Preço:</strong> R$ ${parseFloat(pedido.pizza_preco).toFixed(2).replace('.', ',')}</p>
                        <p><strong>Endereço:</strong> ${pedido.rua}, ${pedido.complemento || ''}, ${pedido.bairro}, ${pedido.cep}</p>
                    </div>
                `;
            });
        } else {
            html += `<p class="no-pedidos">Não há pedidos registrados no momento.</p>`;
        }

        html += `
                    </div>
                </div>
            </body>
            </html>
        `;

        res.send(html);
    } catch (error) {
        res.status(500).send(`<p>Erro ao carregar ordens de pedido: ${error.message}</p>`);
    }
});

// Iniciar o servidor
app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
