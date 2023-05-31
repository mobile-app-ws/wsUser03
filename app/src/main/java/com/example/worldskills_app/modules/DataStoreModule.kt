package com.example.worldskills_app.modules

import com.example.worldskills_app.data.DataStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModule = module {
    singleOf(::DataStore)
}