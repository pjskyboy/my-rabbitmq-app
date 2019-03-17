package my.rabbitmq.app

import io.micronaut.runtime.Micronaut
import javax.inject.Inject

object Application {

    @Inject
    private lateinit var productClient : ProductClient

    @Inject
    private lateinit var productListener : ProductListener

    @JvmStatic
    fun main(args: Array<String>) {
        val ctx = Micronaut.build()
                .packages("my.rabbitmq.app")
                .mainClass(Application.javaClass)
                .start()

        productClient = ctx.getBean(ProductClient::class.java)
        productClient.send("quickstart")
    }
}