package calc

import main.calc.Calc
import org.testng.annotations.Test

class CalcTest {

    @Test
    fun firstTest() {
        val calc = Calc()
        val result = calc.add("I", "I")
        assert(result == "II")
    }

    @Test
    fun secondTest() {
        val calc = Calc()
        val result = calc.add("I", "II")
        assert(result == "III")
    }

    @Test
    fun thirdTest() {
        val calc = Calc()
        val result = calc.add("II", "I")
        assert(result == "III")
    }

    @Test
    fun fourthTest() {
        val calc = Calc()
        val result = calc.add("I", "III")
        assert(result == "IV")
    }

    @Test
    fun fifthTest() {
        val calc = Calc()
        val result = calc.add("II", "II")
        assert(result == "IV")
    }

    @Test
    fun sixthTest() {
        val calc = Calc()
        val result = calc.add("III", "I")
        assert(result == "IV")
    }

    @Test
    fun seventhTest() {
        val calc = Calc()
        val result = calc.add("II", "III")
        assert(result == "V")
    }

    @Test
    fun eigththTest() {
        val calc = Calc()
        val result = calc.add("III", "II")
        assert(result == "V")
    }
    @Test
    fun test10() {
        val calc = Calc()
        val result = calc.add("I", "IV")
        assert(result == "V")
    }

    @Test
    fun test11() {
        val calc = Calc()
        val result = calc.add("IV", "I")
        assert(result == "V")
    }

    @Test
    fun test12() {
        val calc = Calc()
        val result = calc.add("I", "V")
        assert(result == "VI")
    }

    @Test
    fun test13() {
        val calc = Calc()
        val result = calc.add("V", "I")
        assert(result == "VI")
    }

    @Test
    fun test14() {
        val calc = Calc()
        val result = calc.add("II", "IV")
        assert(result == "VI")
    }

    @Test
    fun test15() {
        val calc = Calc()
        val result = calc.add("III", "III")
        assert(result == "VI")
    }

    @Test
    fun test16() {
        val calc = Calc()
        val result = calc.add("IV", "II")
        assert(result == "VI")
    }

    @Test
    fun test17() {
        val calc = Calc()
        val result = calc.add("V", "I")
        assert(result == "VI")
    }

    @Test
    fun test18() {
        val calc = Calc()
        val result = calc.add("II", "V")
        assert(result == "VII")
    }
    @Test
    fun test19() {
        val calc = Calc()
        val result = calc.add("IV", "IV")
        assert(result == "VIII")
    }
    @Test
    fun test20() {
        val calc = Calc()
        val result = calc.add("IV", "III")
        assert(result == "VII")
    }
    @Test
    fun test21() {
        val calc = Calc()
        val result = calc.add("IV", "V")
        assert(result == "IX")
    }
    @Test
    fun test22() {
        val calc = Calc()
        val result = calc.add("V", "IV")
        assert(result == "IX")
    }
    @Test
    fun test23() {
        val calc = Calc()
        val result = calc.add("V", "V")
        assert(result == "X")
    }

}
