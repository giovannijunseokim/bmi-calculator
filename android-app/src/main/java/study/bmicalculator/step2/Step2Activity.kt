package study.bmicalculator.step2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import study.bmicalculator.R
import study.bmicalculator.databinding.ActivityStep2Binding

class Step2Activity : AppCompatActivity() {
    private val model = BmiModel()

    private val binding: ActivityStep2Binding by lazy { ActivityStep2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val padding = resources.getDimensionPixelSize(R.dimen.activity_padding)
            v.setPadding(
                systemBars.left + padding,
                systemBars.top + padding,
                systemBars.right + padding,
                systemBars.bottom + padding,
            )
            insets
        }

        binding.buttonCalculate.setOnClickListener {
            val height = readHeight()
            val weight = readWeight()

            val bmi = model.calculateBmi(height, weight)
            val status = model.classifyBmi(bmi)

            displayResult(bmi, status)
        }
    }

    private fun readHeight(): Double = binding.editTextHeight.text.toString().toDouble()

    private fun readWeight(): Double = binding.editTextWeight.text.toString().toDouble()

    private fun displayResult(bmi: Double, status: String) {
        binding.textViewResult.text = "BMI: %.1f (%s)".format(bmi, status)
    }
}
