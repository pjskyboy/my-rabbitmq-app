package my.rabbitmq.app

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer
import java.io.IOException
import javax.inject.Singleton

@Singleton
internal class ChannelPoolListener : ChannelInitializer() {

    @Throws(IOException::class)
    override fun initialize(channel: Channel) {
        channel.exchangeDeclare("animals", BuiltinExchangeType.DIRECT, true) // <1>
        channel.queueDeclare("product", true, false, false, null) // <2>
        channel.queueBind("product", "animals", "product") // <3>
    }
}
