package di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val commonModule = module {
    single<CoroutineScope> { CoroutineScope(SupervisorJob() + Dispatchers.Main) }
}
