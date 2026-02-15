package study.bmicalculator.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BmiPresenterTest {

    private var resultStatus = ""

    private val fakeView = object : BmiContract.View {
        private var _height = 0.0
        private var _weight = 0.0

        fun setHeight(value: Double) { _height = value }
        fun setWeight(value: Double) { _weight = value }

        override fun getHeight(): Double = _height
        override fun getWeight(): Double = _weight
        override fun showResult(bmi: Double, status: String) {
            resultStatus = status
        }
    }

    private val model = BmiModel()
    private val presenter = BmiPresenter(fakeView, model)

    @Test
    fun `키 170cm 몸무게 50kg를 입력하면 저체중을 표시한다`() {
        fakeView.setHeight(170.0)
        fakeView.setWeight(50.0)

        presenter.calculateBmi()

        assertThat(resultStatus).isEqualTo("저체중")
    }

    @Test
    fun `키 170cm 몸무게 60kg를 입력하면 정상을 표시한다`() {
        fakeView.setHeight(170.0)
        fakeView.setWeight(60.0)

        presenter.calculateBmi()

        assertThat(resultStatus).isEqualTo("정상")
    }

    @Test
    fun `키 170cm 몸무게 90kg를 입력하면 비만을 표시한다`() {
        fakeView.setHeight(170.0)
        fakeView.setWeight(90.0)

        presenter.calculateBmi()

        assertThat(resultStatus).isEqualTo("비만")
    }
}
