package study.bmicalculator.step3

interface BmiContract {
    interface View {
        fun getHeight(): Double
        fun getWeight(): Double
        fun showResult(bmi: Double, status: String)
    }

    interface Presenter {
        fun calculateBmi()
    }
}
