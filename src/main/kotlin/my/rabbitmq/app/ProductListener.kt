package my.rabbitmq.app

import io.micronaut.configuration.rabbitmq.annotation.Queue
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener
import java.util.*


@RabbitListener
class ProductListener {

    private val messageLengths: MutableList<String> = Collections.synchronizedList(ArrayList())

    @Queue("product")
    fun receive(data: String) {
        messageLengths.add(data)
        println("Kotlin received ${data.length} bytes from RabbitMQ")
    }
}