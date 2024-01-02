package di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun commonInitKoin(
    platformSpecific: Module = module { },
): KoinApplication = startKoin {
    modules(
        appModule() + platformSpecific,
    )
}