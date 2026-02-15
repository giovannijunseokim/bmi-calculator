package study.bmicalculator.step3

class BmiPresenter(
    private val view: BmiContract.View,
    private val model: BmiModel,
) : BmiContract.Presenter {
    override fun calculateBmi() {
        val height = view.getHeight()
        val weight = view.getWeight()

        val bmi = model.calculateBmi(height, weight)
        val status = model.classifyBmi(bmi)

        view.showResult(bmi, status)
    }
}
