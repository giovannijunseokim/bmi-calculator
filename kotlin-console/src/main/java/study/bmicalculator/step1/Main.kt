package study.bmicalculator.step1

fun main() {
    val controller = BmiController(
        model = BmiModel(),
        view = BmiView(),
    )
    controller.run()
}
