package study.bmicalculator.step3

class BmiModel {
    fun calculateBmi(height: Double, weight: Double): Double {
        val heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }

    fun classifyBmi(bmi: Double): String {
        return when {
            bmi < 18.5 -> "저체중"
            bmi < 23.0 -> "정상"
            bmi < 25.0 -> "과체중"
            else -> "비만"
        }
    }
}