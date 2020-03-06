package com.kevinjanvier.democomplaints.starts;

import com.rabbitmq.client.Channel;
import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AxomConfig {

    @Bean
    public SpringAMQPMessageSource complaintEvents(Serializer serializer) {
        System.out.println("Serializer : " + serializer.toString());

        return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {

            @RabbitListener(queues = "ComplaintEvents")
            @Override
            public void onMessage(Message message, Channel channel) {
                System.out.println("Event Received: {}" +message.getBody().toString());
                super.onMessage(message, channel);
            }
        };
    }
}
//