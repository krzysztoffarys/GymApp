package com.crys.gymapp.feature_weight.di

import com.crys.gymapp.feature_weight.utils.WeightConsts.WEIGHT_MAX_VALUE
import com.crys.gymapp.utils.text.DecimalNumberFormattingTextChangeHandler
import com.crys.gymapp.utils.text.DecimalNumberFormattingTextWatcher
import com.crys.gymapp.utils.text.DecimalNumberParser
import com.crys.gymapp.utils.validation.FieldValidator
import com.crys.gymapp.utils.validation.MinimumLengthValidator
import com.crys.gymapp.utils.validation.NonNullNonEmptyValidator
import com.crys.gymapp.utils.validation.validationOf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object WeightActivityModule {


    @Provides
    fun provideWeightTextWatcher(decimalNumberParser: DecimalNumberParser): DecimalNumberFormattingTextWatcher {
        val textChangeHandler = DecimalNumberFormattingTextChangeHandler(decimalNumberParser, WEIGHT_MAX_VALUE)
        return DecimalNumberFormattingTextWatcher(textChangeHandler)
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object WeightViewModelModule {

    @WeightValidator
    @Provides
    fun provideWeightValidator(): FieldValidator = validationOf(
        NonNullNonEmptyValidator,
        MinimumLengthValidator(1)
    )
}

@Qualifier
annotation class WeightValidator