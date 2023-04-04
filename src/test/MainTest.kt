import org.junit.Assert.assertEquals
import org.junit.Test
class MyTest {
    @Test
    fun testAddition() {
        val a = 2
        val b = 3
        val expected = 5
        val actual = add(a, b) assertEquals (expected, actual)
    }
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    org.junit.runner.JUnitCore.runClasses(MyTest::class.java)
}
