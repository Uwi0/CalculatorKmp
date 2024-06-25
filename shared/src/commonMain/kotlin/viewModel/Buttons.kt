class Buttons {
    val buttons: List<List<String>> = listOf(
        listOf("C", "±", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=")
    )
    
    fun buttonColor(key: String): String {
        val LightGray = "0xFFD4D4D2"
        val DarkLiver = "0xFF505050"
        val VividGamboge = "0xFFFF9500"
        val buttonColors = mapOf(
            "C" to LightGray, "±" to LightGray, "%" to LightGray, "÷" to VividGamboge,
            "×" to VividGamboge, "-" to VividGamboge, "+" to VividGamboge, "=" to VividGamboge,
            "0" to DarkLiver, "1" to DarkLiver, "2" to DarkLiver, "3" to DarkLiver,
            "4" to DarkLiver, "5" to DarkLiver, "6" to DarkLiver, "7" to DarkLiver,
            "8" to DarkLiver, "9" to DarkLiver, "." to DarkLiver
        )
    
        return buttonColors[key] ?: "0"
    }
}