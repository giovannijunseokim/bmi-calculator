package study.bmicalculator.step4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import study.bmicalculator.R
import study.bmicalculator.databinding.ActivityStep4Binding

class Step4Activity : AppCompatActivity() {
    private val binding: ActivityStep4Binding by lazy { ActivityStep4Binding.inflate(layoutInflater) }
    private val viewModel: BmiViewModel by viewModels()

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
            val height = binding.editTextHeight.text.toString()
            val weight = binding.editTextWeight.text.toString()
            viewModel.calculateBmi(height, weight)
        }

        viewModel.result.observe(this) { (bmi, status) ->
            binding.textViewResult.text = "BMI: %.1f (%s)".format(bmi, status)
        }

        viewModel.error.observe(this) { error ->
            if (error) binding.textViewResult.text = "키와 몸무게를 올바르게 입력해 주세요."
        }
    }
}
