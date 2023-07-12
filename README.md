# Ktor Android Http Client Example
Simple implementation of Ktor Http Client for Android with Kotlin Serialization. The project is using the free api from [quotable.io](https://github.com/lukePeavey/quotable) for providing data.

## What is a Ktor?
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

implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
implementation("io.ktor:ktor-client-android:1.5.0")
implementation("io.ktor:ktor-client-serialization:1.5.0")
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
implementation("io.ktor:ktor-client-logging-jvm:1.5.0")
```

#### 2. build.gradle.kts(root)
- Add plugin `id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"`
```kotlin
id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
```

#### 3. Create the Http Android Client
```kotlin
private const val TIME_OUT = 6000

val httpClientAndroid = HttpClient(Android) {

    install(JsonFeature) {

        serializer = KotlinxSerializer(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
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
        parameter("key", "value")
        if (method != HttpMethod.Get) contentType(ContentType.Application.Json)
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

## Build-tool
You need to have [Android Studio Flamingo or above](https://developer.android.com/studio/preview) to build this project.
