package com.kakapo.calculator.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import viewModel.CalculatorViewModel

val appModule = module {
    viewModel{ CalculatorViewModel() }
}