package study.bmicalculator.step4

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BmiViewModelTest {

    private lateinit var viewModel: BmiViewModel

    @BeforeEach
    fun setUp() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun postToMainThread(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean = true
        })
        viewModel = BmiViewModel()
    }

    @AfterEach
    fun tearDown() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @Test
    fun `키 170cm 몸무게 50kg이면 저체중임을 보여준다`() {
        viewModel.calculateBmi("170.0", "50.0")

        assertThat(viewModel.result.value?.status).isEqualTo("저체중")
    }

    @Test
    fun `키 170cm 몸무게 60kg이면 정상임을 보여준다`() {
        viewModel.calculateBmi("170.0", "60.0")

        assertThat(viewModel.result.value?.status).isEqualTo("정상")
    }

    @Test
    fun `키 170cm 몸무게 70kg이면 과체중임을 보여준다`() {
        viewModel.calculateBmi("170.0", "70.0")

        assertThat(viewModel.result.value?.status).isEqualTo("과체중")
    }

    @Test
    fun `키 170cm 몸무게 90kg이면 비만임을 보여준다`() {
        viewModel.calculateBmi("170.0", "90.0")

        assertThat(viewModel.result.value?.status).isEqualTo("비만")
    }

    @Test
    fun `빈 값을 입력하면 에러를 표시한다`() {
        viewModel.calculateBmi("", "")

        assertThat(viewModel.error.value).isTrue()
    }
}
