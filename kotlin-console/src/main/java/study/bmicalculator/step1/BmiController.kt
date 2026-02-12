package study.bmicalculator.step1

class BmiController(
    private val model: BmiModel,
    private val view: BmiView,
) {
    fun run() {
        val height = view.readHeight()
        val weight = view.readWeight()

        val bmi = model.calculateBmi(height, weight)
        val status = model.classifyBmi(bmi)

        view.displayResult(bmi, status)
    }
}
