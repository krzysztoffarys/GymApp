package com.crys.gymapp.feature_weight.di

import com.crys.gymapp.utils.text.DecimalNumberFormattingTextChangeHandler
import com.crys.gymapp.utils.text.DecimalNumberFormattingTextWatcher
import com.crys.gymapp.utils.text.DecimalNumberParser
import com.crys.gymapp.utils.text.StringConsts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object WeightModule {


    @Provides
    fun provideWeightTextWatcher(decimalNumberParser: DecimalNumberParser): DecimalNumberFormattingTextWatcher {
        val textChangeHandler = DecimalNumberFormattingTextChangeHandler(decimalNumberParser, StringConsts.PRICE_MAX_VALUE)
        return DecimalNumberFormattingTextWatcher(textChangeHandler)
    }


}

@Qualifier
annotation class WeightValidator