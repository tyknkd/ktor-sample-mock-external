Sample Ktor app with test using mock external services for different port on localhost based on [Ktor docs](https://ktor.io/docs/testing.html#external-services).

[YouTrack Issue is here.](https://youtrack.jetbrains.com/issue/KTOR-6880/Mock-external-services-for-a-localhost-port-throws-InvalidTestRequestException)

Throws exception:
```shell
io.ktor.server.testing.client.InvalidTestRequestException: Can not resolve request to http://localhost:8081. Main app runs at localhost:80, localhost:443 and external services are http://localhost
	at app//io.ktor.server.testing.client.DelegatingTestClientEngine.execute(DelegatingTestClientEngine.kt:56)
	at app//io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2.invokeSuspend(HttpClientEngine.kt:99)
	at app//kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at app//kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
	at app//kotlinx.coroutines.internal.LimitedDispatcher$Worker.run(LimitedDispatcher.kt:115)
	at app//kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:100)
	at app//kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:584)
	at app//kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:793)
	at app//kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:697)
	at app//kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:684)
```
Log:
```shell
2024-03-28 07:43:46.886 [Test worker @coroutine#1] TRACE i.k.c.p.c.ContentNegotiation - Adding Accept=application header for http://localhost:8081/myroute
2024-03-28 07:43:46.909 [Test worker @coroutine#1] TRACE i.k.c.p.c.ContentNegotiation - Converted request body using io.ktor.serialization.kotlinx.KotlinxSerializationConverter@5bcde458 for http://localhost:8081/myroute
2024-03-28 07:43:46.910 [Test worker @coroutine#1] TRACE i.ktor.client.plugins.HttpPlainText - Adding Accept-Charset=UTF-8 to http://localhost:8081/myroute
2024-03-28 07:43:46.915 [Test worker @coroutine#1] TRACE i.k.c.plugins.defaultTransformers - Transformed with default transformers request body for http://localhost:8081/myroute from class io.ktor.http.content.TextContent
2024-03-28 07:43:46.953 [Test worker @coroutine#1] TRACE i.k.client.plugins.HttpCallValidator - Processing exception io.ktor.server.testing.client.InvalidTestRequestException: Can not resolve request to http://localhost:8081. Main app runs at localhost:80, localhost:443 and external services are http://localhost for request http://localhost:8081/myroute
```