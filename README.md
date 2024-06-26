# Ktor Android Http Client Example
Simple implementation of Ktor Http Client for Android with Kotlin Serialization. The project is using the free api from [thecocktaildb](https://www.thecocktaildb.com/) for providing data.

## What is Ktor?
[Ktor](https://ktor.io/docs/welcome.html) is an open-source framework built by JetBrains for building asynchronous servers and clients using Kotlin programming language.

## Implementation
#### 1. build.gradle.kts(app module)
- Add plugin `id("kotlinx-serialization")`
- Add Dependencies
```kotlin
plugins {
   ...
    id("kotlinx-serialization")
}

implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
implementation("io.ktor:ktor-client-android:2.3.11")
implementation("io.ktor:ktor-client-serialization:2.3.11")
implementation("io.ktor:ktor-client-logging:2.3.11")
implementation("io.ktor:ktor-client-content-negotiation:2.3.11")
implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.11")
```

#### 2. build.gradle.kts(root)
- Add plugin `id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"`
```kotlin
id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
```

#### 3. Create the Http Android Client
```kotlin
private const val NETWORK_TIME_OUT = 6_000L

val httpClientAndroid = HttpClient(Android) {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                useAlternativeNames = true
                ignoreUnknownKeys = true
                encodeDefaults = false
            }
        )
    }

    install(HttpTimeout) {
        requestTimeoutMillis = NETWORK_TIME_OUT
        connectTimeoutMillis = NETWORK_TIME_OUT
        socketTimeoutMillis = NETWORK_TIME_OUT
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    defaultRequest {
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }
}

```

## Other technologies used in the project
- [Koin](https://insert-koin.io/docs/reference/introduction/#:~:text=Koin%20is%20a%20pragmatic%20and,container%20and%20a%20pragmatic%20API) - Koin is a pragmatic and lightweight dependency injection framework for Kotlin developers
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html#asynchronous-flow) - Official Kotlin's tooling for performing asynchronous work.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - The ViewModel is designed to store and manage UI-related data in a lifecycle conscious way.
- [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#stateflow) - StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors.

