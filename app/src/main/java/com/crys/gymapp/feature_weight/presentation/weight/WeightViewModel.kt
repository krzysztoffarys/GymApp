package com.crys.gymapp.feature_weight.presentation.weight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crys.gymapp.feature_weight.domain.model.Weight
import com.crys.gymapp.feature_weight.domain.use_case.AddWeightUseCase
import com.crys.gymapp.feature_weight.domain.use_case.GetWeightUseCase
import com.crys.gymapp.feature_weight.utils.Consts.GRAMS_IN_KILOGRAM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val addWeightUseCase: AddWeightUseCase,
    private val getWeightUseCase: GetWeightUseCase,
    private val dateProvider: DateProvider
) : ViewModel() {

    private val _todayWeight = MutableLiveData<Double?>()
    val todayWeight: LiveData<Double?> = _todayWeight

    fun onResume() {
        viewModelScope.launch {
            _todayWeight.value =
                getWeightUseCase(dateProvider.getTodayDate())?.weightInGrams?.toDouble()?.div(GRAMS_IN_KILOGRAM)
        }
    }

    fun onSendWeightButtonClicked(weight: Double) {
        viewModelScope.launch {
            addWeightUseCase(Weight((weight * GRAMS_IN_KILOGRAM).toLong(), dateProvider.getTodayDate()))
        }
        onResume()
    }
}