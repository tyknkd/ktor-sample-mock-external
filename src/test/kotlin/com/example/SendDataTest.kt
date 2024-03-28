package com.example

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class SendDataTest {
    @Test
    fun testPostData() = testApplication {
        externalServices {
            hosts("http://localhost:8081") {
                install(io.ktor.server.plugins.contentnegotiation.ContentNegotiation) { json() }
                routing {
                    post("myroute") {
                        call.respondText("OK", status = HttpStatusCode.OK)
                    }
                }
            }
        }
        val testClient = createClient {
            install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) { json() }
        }
        val result = SendData().postData(testClient)
        assertTrue(result)
    }
}