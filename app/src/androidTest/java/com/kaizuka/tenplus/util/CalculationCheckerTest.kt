package com.kaizuka.tenplus.util

import android.content.ContentValues.TAG
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber
import java.util.Timer

@Suppress("TestFunctionName", "NonAsciiCharacters")
@RunWith(AndroidJUnit4::class)
class CalculationCheckerTest {
    @Test
    fun カッコなし計算式の計算結果が正しいこと() {
        val calculationChecker = CalculationChecker()
        val ansText = listOf('1', '+', '2', '+', '3', '+', '4', '+', '5')
        val result = calculationChecker.cal(ansText)==15

        Timber.tag(TAG).d("asnText = $ansText, result = $result")
        Assert.assertTrue(result)
    }

    @Test
    fun カッコつき計算() {
        val calculationChecker = CalculationChecker()
        val ansText = listOf('(', '1', '+', '2', ')', '*', '3', '+', '4')
        val result = calculationChecker.cal(ansText)
        val message= "asnText = $ansText, result = $result"
        Assert.assertEquals(message,13, result)
    }

    companion object {
        private const val TAG = "CalculationCheckerTest"
    }

}