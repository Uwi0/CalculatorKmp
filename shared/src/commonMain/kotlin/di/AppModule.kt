package di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.module
import viewModel.CalculatorViewModel

fun  appModule() = module {
        viewModelOf(::CalculatorViewModel)
}
    