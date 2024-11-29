package com.example.api_notificacao.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.api_notificacao.entities.Pedido;

@Component
public class PedidoListener {
    
    private Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado-gerar-notificacao")
    public void ouvirEEnviarNotificacao(Pedido pedido){

        logger.info("Pedido notificado: {}" , pedido.toString());
    }
}
