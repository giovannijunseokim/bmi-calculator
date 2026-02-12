package study.bmicalculator.step0

fun main() {
    // 입력
    val height = readHeight()
    val weight = readWeight()

    // 계산
    val bmi = calculateBmi(height, weight)

    // 표시
    val status = classifyBmi(bmi)
    displayResult(bmi, status)
}

private fun readHeight(): Double {
    print("키를 입력해 주세요 (cm): ")
    return readln().toDouble()
}

private fun readWeight(): Double {
    print("몸무게를 입력해 주세요 (kg): ")
    return readln().toDouble()
}

private fun calculateBmi(height: Double, weight: Double): Double {
    val heightInMeters = height / 100
    return weight / (heightInMeters * heightInMeters)
}

private fun classifyBmi(bmi: Double): String {
    return when {
        bmi < 18.5 -> "저체중"
        bmi < 23.0 -> "정상"
        bmi < 25.0 -> "과체중"
        else -> "비만"
    }
}

private fun displayResult(bmi: Double, status: String) {
    println("BMI: %.1f (%s)".format(bmi, status))
}