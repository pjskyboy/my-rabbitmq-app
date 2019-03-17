package my.rabbitmq.app

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("animals")
interface ProductClient {

    @Binding("product")
    fun send(data: String)
}