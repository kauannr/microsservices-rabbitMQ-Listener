package com.example.api_notificacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.api_notificacao.entities.ItemPedido;
import com.example.api_notificacao.entities.Pedido;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void enviarNotificacaoViaEmail(Pedido pedido) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom("sistemastafftrack@gmail.com");
        email.setTo(pedido.getEmailParaNotificar());
        email.setSubject("Pedido de compra");
        email.setText(this.gerarMensagem(pedido));

        javaMailSender.send(email);
    }

    public String gerarMensagem(Pedido pedido) {

        StringBuilder stringBuilder = new StringBuilder();

        for (ItemPedido itemPedido : pedido.getItensDoPedido()) {
            stringBuilder.append("Produto: "+itemPedido.getProduto().getNome() + "\n");
            stringBuilder.append("Valor: "+String.valueOf(itemPedido.getProduto().getValor()) + "\n" );
            stringBuilder.append("Quantidade: "+itemPedido.getQuantidade() + "\n");
            stringBuilder.append("Subtotal: "+itemPedido.getSubTotal() + "\n\n");
        }

        String mensagem = "Olá " + pedido.getCliente() + ", "
                + " seu pedido cod " + pedido.getId().toString()
                + " no valor total de " + String.valueOf(pedido.getValorTotal())
                + " foi realizado com sucesso!\n\n"
                + "Status: " + pedido.getStatusPedido().toString() + "\n\n"
                + "Data: " + pedido.getInstantePedido() + "\n\n"
                + "Itens da compra:\n" + stringBuilder.toString();

        return mensagem;
    }
}
