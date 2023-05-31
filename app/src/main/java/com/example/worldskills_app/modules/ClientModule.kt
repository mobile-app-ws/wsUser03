package com.example.worldskills_app.modules

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val clientModule = module {
    factory {
        HttpClient(CIO){
            install(Logging)
            defaultRequest {
                url("https://medic.madskill.ru/")
            }
            install(ContentNegotiation){
                json(Json)
            }
        }
    }
    single {
        Json {
            prettyPrint = true
            isLenient = true
        }
    }
}