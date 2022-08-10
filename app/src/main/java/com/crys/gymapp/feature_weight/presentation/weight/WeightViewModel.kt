package com.crys.gymapp.feature_weight.presentation.weight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crys.gymapp.feature_weight.di.WeightValidator
import com.crys.gymapp.feature_weight.domain.model.Weight
import com.crys.gymapp.feature_weight.domain.use_case.AddWeightUseCase
import com.crys.gymapp.feature_weight.domain.use_case.DeleteWeightUseCase
import com.crys.gymapp.feature_weight.domain.use_case.GetWeightUseCase
import com.crys.gymapp.feature_weight.utils.WeightConsts.GRAMS_IN_KILOGRAM
import com.crys.gymapp.utils.validation.FieldValidator
import com.crys.gymapp.utils.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val addWeightUseCase: AddWeightUseCase,
    private val getWeightUseCase: GetWeightUseCase,
    private val deleteWeightUseCase: DeleteWeightUseCase,
    private val dateProvider: DateProvider,
    @WeightValidator private val weightValidator: FieldValidator
) : ViewModel() {

    private var curWeight: Weight? = null

    private val _todayWeight = MutableLiveData<Double?>()
    val todayWeight: LiveData<Double?> = _todayWeight

    private val _weightValidation = MutableLiveData<ValidationResult>()
    val weightValidation: LiveData<ValidationResult> = _weightValidation

    fun onCreate() {
        getTodayWeight()
    }

    private fun getTodayWeight() {
        viewModelScope.launch {
            curWeight = getWeightUseCase(dateProvider.getTodayDate())
            _todayWeight.value = curWeight?.weightInGrams?.toDouble()?.div(GRAMS_IN_KILOGRAM)
        }
    }

    fun onWeightChange(weight: String) {
        _weightValidation.value = weightValidator.validate(weight)
    }

    fun onSendWeightButtonClicked(weight: Double) {
        viewModelScope.launch {
            addWeightUseCase(Weight((weight * GRAMS_IN_KILOGRAM).toLong(), dateProvider.getTodayDate()))
        }
        getTodayWeight()
    }

    fun onDeleteTodayItemClicked() {
        viewModelScope.launch {
            curWeight?.let {
                deleteWeightUseCase(it)
                getTodayWeight()
            }
        }
    }
}