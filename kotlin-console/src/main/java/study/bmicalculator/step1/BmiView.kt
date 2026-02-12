package study.bmicalculator.step1

class BmiView {
    fun readHeight(): Double {
        print("키를 입력해 주세요 (cm): ")
        return readln().toDouble()
    }

    fun readWeight(): Double {
        print("몸무게를 입력해 주세요 (kg): ")
        return readln().toDouble()
    }

    fun displayResult(bmi: Double, status: String) {
        println("BMI: %.1f (%s)".format(bmi, status))
    }
}
