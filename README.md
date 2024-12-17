# rabbitMQ-API-notificacao

# Sobre a API

Este microsserviço faz parte do projeto de mensageria utilizando o rabbitMQ, e se comunica com mais dois microsserviços: o de criação do pedido (https://github.com/kauannr/rabbitMQ-API-pedido) e o de processamento do pedido (https://github.com/kauannr/rabbitMQ-API-processamento).
A funcionalidade dessa API, como o nome sugere, é fazer a notificação para o cliente após a realização e processamento do pedido. Aqui temos a utilização da API do JavaMail configurado para o Gmail do google, e, após a mensagem gerada pela API de pedidos chegar na fila de mensagens que o serviço de notificação está "escutando", pegamos o email do cliente e o notificamos sobre seu pedido.

# Exemplo de notificação em um dispositivo móvel
![Exemplo de Pedido Aprovado](https://github.com/kauannr/rabbitMQ-API-notificacao/raw/9ad158ca5c43f3a92141092c2d5f8dd5b2ea6931/assets/1733371859217.jpeg)
