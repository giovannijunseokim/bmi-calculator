package study.bmicalculator.step4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel(private val model: BmiModel = BmiModel()) : ViewModel() {

    data class BmiResult(val bmi: Double, val status: String)

    private val _result = MutableLiveData<BmiResult>()
    val result: LiveData<BmiResult> get() = _result

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    fun calculateBmi(heightText: String, weightText: String) {
        val height = heightText.toDoubleOrNull()
        val weight = weightText.toDoubleOrNull()

        if (height == null || weight == null) {
            _error.value = true
            return
        }

        val bmi = model.calculateBmi(height, weight)
        val status = model.classifyBmi(bmi)
        _result.value = BmiResult(bmi, status)
    }
}
