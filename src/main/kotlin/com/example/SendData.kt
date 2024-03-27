package com.example

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

class SendData {
    suspend fun postData(client: HttpClient): Boolean {
        @Serializable
        data class MyDataClass( val id: Int, val value: String)
        val myData = MyDataClass(id = 0, value = "some value")
        val response: HttpResponse = client.post {
            url {
                protocol = URLProtocol.HTTP
                host = "localhost:8081"
                path("myroute")
            }
            contentType(ContentType.Application.Json)
            setBody(myData)
        }
        return (response.bodyAsText() == "OK")
    }
}