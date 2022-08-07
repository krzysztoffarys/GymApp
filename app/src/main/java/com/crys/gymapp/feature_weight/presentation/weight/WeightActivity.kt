package com.crys.gymapp.feature_weight.presentation.weight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.crys.gymapp.R
import com.crys.gymapp.databinding.ActivityWeightBinding
import com.crys.gymapp.utils.text.DecimalNumberFormattingTextWatcher
import com.crys.gymapp.utils.extensions.handleValidationResult
import com.crys.gymapp.utils.extensions.hide
import com.crys.gymapp.utils.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightBinding
    private val viewModel by viewModels<WeightViewModel>()

    @Inject
    lateinit var decimalNumberFormattingTextWatcher: DecimalNumberFormattingTextWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        subscribeToObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun onNullWeight() = with(binding) {
        saveWeightButton.show()
        weightTextInputLayout.show()
        weightTextView.hide()
    }

    private fun onTodayWeight(weight: Double) = with(binding) {
        saveWeightButton.hide()
        weightTextInputLayout.hide()
        weightTextView.show()
        weightTextView.text = getString(R.string.your_today_weight, weight)
    }

    private fun setupView() = with(binding) {
        saveWeightButton.setOnClickListener {
            viewModel.onSendWeightButtonClicked(weight = binding.weightEditText.text.toString().toDouble())
        }
        backImageView.setOnClickListener { finish() }
        weightEditText.addTextChangedListener(decimalNumberFormattingTextWatcher)
        weightEditText.doAfterTextChanged { viewModel.onWeightChange(it.toString()) }
    }

    private fun subscribeToObservers() {
        viewModel.todayWeight.observe(this) { todayWeight ->
            if (todayWeight == null) {
                onNullWeight()
            } else {
                onTodayWeight(todayWeight)
            }
        }
        viewModel.weightValidation.observe(this) {
            binding.weightTextInputLayout.handleValidationResult(it)
        }
    }
}