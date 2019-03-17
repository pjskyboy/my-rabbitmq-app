package my.rabbitmq.app

import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.impl.DefaultCredentialsProvider
import io.micronaut.context.annotation.Value
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import mu.KotlinLogging
import javax.inject.Singleton

private val logger = KotlinLogging.logger {}
@Singleton
class ConnectionFactoryInterceptor() : BeanCreatedEventListener<ConnectionFactory> {

    @Value("\${amqp.username:guest}")
    private lateinit var username: String
    @Value("\${amqp.password:guest}")
    private lateinit var password : String
    override fun onCreated(event: BeanCreatedEvent<ConnectionFactory>?): ConnectionFactory {
        val connectionFactory = event!!.bean
        logger.info("username=$username password=$password")
        connectionFactory.setCredentialsProvider(DefaultCredentialsProvider(username, password))
        return connectionFactory
    }
}