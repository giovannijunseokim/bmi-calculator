package study.bmicalculator.step1

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.offset
import org.junit.jupiter.api.Test

class BmiModelTest {

    private val model = BmiModel()

    @Test
    fun `키 170cm 몸무게 70kg를 입력하면 BMI 24,22를 반환한다`() {
        val bmi = model.calculateBmi(170.0, 70.0)
        assertThat(bmi).isCloseTo(24.22, offset(0.01))
    }

    @Test
    fun `키 180cm 몸무게 80kg를 입력하면 BMI 24,69를 반환한다`() {
        val bmi = model.calculateBmi(180.0, 80.0)
        assertThat(bmi).isCloseTo(24.69, offset(0.01))
    }

    @Test
    fun `BMI가 18,5 미만이면 저체중을 반환한다`() {
        assertThat(model.classifyBmi(18.4)).isEqualTo("저체중")
    }

    @Test
    fun `BMI가 18,5 이상 23 미만이면 정상을 반환한다`() {
        assertThat(model.classifyBmi(18.5)).isEqualTo("정상")
        assertThat(model.classifyBmi(22.9)).isEqualTo("정상")
    }

    @Test
    fun `BMI가 23 이상 25 미만이면 과체중을 반환한다`() {
        assertThat(model.classifyBmi(23.0)).isEqualTo("과체중")
        assertThat(model.classifyBmi(24.9)).isEqualTo("과체중")
    }

    @Test
    fun `BMI가 25 이상이면 비만을 반환한다`() {
        assertThat(model.classifyBmi(25.0)).isEqualTo("비만")
        assertThat(model.classifyBmi(30.0)).isEqualTo("비만")
    }
}
