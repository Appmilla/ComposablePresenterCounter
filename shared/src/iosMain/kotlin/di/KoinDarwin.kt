package di

import counter.CounterViewModel
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.bind
import org.koin.dsl.module

@BetaInteropApi
fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null, null)
}

@BetaInteropApi
fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}

inline fun <reified T : Any> Module.singleInstance(instance: T) {
    single(createdAtStart = true) { instance } bind T::class
}

inline fun <reified T : Any> Module.factoryInstance(instance: T) {
    factory { instance } bind T::class
}

fun initKoin(): KoinApplication {
    val iosDependenciesModule = module {
        single { CounterViewModel() }
    }
    return commonInitKoin(iosDependenciesModule)
}

@Suppress("unused") // Called from Swift
object KotlinDependencies : KoinComponent {
    fun getCounterViewModel() = getKoin().get<CounterViewModel>()
}
