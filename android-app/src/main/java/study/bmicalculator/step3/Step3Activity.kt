package study.bmicalculator.step3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import study.bmicalculator.R
import study.bmicalculator.databinding.ActivityStep3Binding

class Step3Activity : AppCompatActivity(), BmiContract.View {
    private val presenter: BmiContract.Presenter = BmiPresenter(this, BmiModel())

    private val binding: ActivityStep3Binding by lazy { ActivityStep3Binding.inflate(layoutInflater) }

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
            presenter.calculateBmi()
        }
    }

    override fun getHeight(): Double = binding.editTextHeight.text.toString().toDouble()

    override fun getWeight(): Double = binding.editTextWeight.text.toString().toDouble()

    override fun showResult(bmi: Double, status: String) {
        binding.textViewResult.text = "BMI: %.1f (%s)".format(bmi, status)
    }
}
