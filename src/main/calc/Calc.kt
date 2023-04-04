package main.calc

class Calc {
    fun add(first: String, second: String): String {
        val result = convert(first) + convert(second)
        if (result == "IIII") return "IV"
        if (result == "IIIII") return "V"
        if (result == "IIIIII") return "VI"
        if (result == "IIIIIII") return "VII"
        if (result == "IIIIIIII") return "VIII"
        if (result == "IIIIIIIII") return "IX"
        if (result == "IIIIIIIIII") return "X"
        return result
    }

    private fun convert(string: String): String {
        return when (string) {
            "IV" -> "IIII"
            "V" -> "IIIII"
            else -> string
        }
    }

    fun add2(first: String, second: String): String {
        var result = convert(first) + convert(second)
        result = result.replace("^IIIIIIIIII", "X")
        result = result.replace("^IIIIIIIII", "IX")
        result = result.replace("^IIIII", "V")
        result = result.replace("^IIII", "IV")
        return result
    }
}
