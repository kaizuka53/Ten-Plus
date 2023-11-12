package com.kaizuka.tenplus.util

import timber.log.Timber

class CalculationChecker() {

    fun cal(ansText: List<Char>): Int {
        val ans =answer(ansText.changeCharToInt())
        Timber.tag(TAG).d("text=($ansText), ans = $ans)")
        return ans
    }

    private fun List<Char>.changeCharToInt(): List<Int> {
        val ansCharList = this
        val ansIntList = mutableListOf<Int>()
        for (i in ansCharList.indices) {
            when (ansCharList[i]) {
                '+' -> ansIntList.add(OPERATE_PLUS)
                '-' -> ansIntList.add(OPERATE_MINUS)
                '*' -> ansIntList.add(OPERATE_MULTIPLY)
                '/' -> ansIntList.add(OPERATE_DIVIDE)
                '(' -> ansIntList.add(OPERATE_BRA)
                ')' -> ansIntList.add(OPERATE_KET)
                else -> ansIntList.add(ansCharList[i].digitToInt())
            }
        }
        Timber.tag(TAG).d("ansInt = $ansIntList, ansText = $ansCharList")
        return ansIntList
    }

    private fun answer(ansText: List<Int>): Int {
        val minBra = findMinBra(ansText)
        val maxBra = findMaxKet(ansText)
        return if (minBra == -1 && maxBra == -1) {
            calWithoutBrackets(ansText)
        } else if (minBra == -1 || maxBra == -1) {
            throw Exception("括弧の数が合っていません")
        } else {
            val nextText = ansText.subList(minBra + 1, maxBra)
            if (nextText.size == 1) {
                nextText[0]
            } else {
                answer(nextText)
            }
        }
    }

    private fun calWithoutBrackets(ansText: List<Int>): Int {
        var ans = ansText[0]
        var indicator=0
        while (indicator<ansText.size) {
            if (indicator % 2 == 0) {
                indicator++
                continue
            }
            when (ansText[indicator]) {
                OPERATE_PLUS -> {
                    ans += ansText[indicator + 1]
                }
                OPERATE_MINUS -> {
                    ans -= ansText[indicator + 1]
                }
                OPERATE_MULTIPLY -> {
                    ans += multiplyAndDiv(indicator,ansText).second
                    indicator=multiplyAndDiv(indicator,ansText).first
                }
                OPERATE_DIVIDE -> {
                    ans += multiplyAndDiv(indicator,ansText).second
                    indicator=multiplyAndDiv(indicator,ansText).first
                }
            }
            indicator++
        }

        return ans
    }

    private fun multiplyAndDiv(indicator: Int, ansText: List<Int>):Pair<Int,Int> {
        var num=ansText[indicator-1]
        var div=1
        var i=indicator
        while (indicator<ansText.size) {
            i++
            if (indicator % 2 == 0) continue
            when (ansText[indicator]) {
                OPERATE_MULTIPLY -> {
                    num *= ansText[i + 1]
                }
                OPERATE_DIVIDE -> {
                    div *= ansText[i + 1]
                }
                else -> {
                    break
                }
            }
        }
        return indicator to (num/div)
    }

    private fun findMinBra(ansText: List<Int>): Int {
        for (i in ansText.indices) {
            if (ansText[i] == OPERATE_BRA) {
                return i
            }
        }
        return -1
    }

    private fun findMaxKet(ansText: List<Int>): Int {
        for (i in ansText.indices.reversed()) {
            if (ansText[i] == OPERATE_KET) {
                return i
            }
        }
        return -1
    }

    companion object {
        private const val TAG = "CalculationChecker"
        private const val OPERATE_PLUS = Int.MAX_VALUE
        private const val OPERATE_MINUS = Int.MAX_VALUE - 1
        private const val OPERATE_MULTIPLY = Int.MAX_VALUE - 2
        private const val OPERATE_DIVIDE = Int.MAX_VALUE - 3
        private const val OPERATE_BRA = Int.MAX_VALUE - 4
        private const val OPERATE_KET = Int.MAX_VALUE - 5
    }

}