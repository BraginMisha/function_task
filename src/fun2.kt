/*Написать программу, реализующую шифровку и расшифровку сообщения с помощью шифра Виженера.*/

fun main() {
    val originalMessage = promptInput("Введите текст: ")
    val keyword = promptInput("Введите ключ: ")
    val encryptedMessage = encrypt(originalMessage, keyword)
    val decryptedMessage = decrypt(encryptedMessage, keyword)

    println("\nЗашифрованное сообщение: $encryptedMessage")
    println("Расшифрованное сообщение: $decryptedMessage")
}

fun promptInput(message: String): String {
    print(message)
    return readLine() ?: ""
}

fun encrypt(message: String, keyword: String): String {
    val encryptedChars = message.mapIndexed { index, char ->
        val keywordChar = keyword[index % keyword.length]
        val shift = keywordChar.toInt() - 'A'.toInt()
        shiftChar(char, shift)
    }
    return encryptedChars.joinToString("")
}

fun decrypt(message: String, keyword: String): String {
    val decryptedChars = message.mapIndexed { index, char ->
        val keywordChar = keyword[index % keyword.length]
        val shift = keywordChar.toInt() - 'A'.toInt()
        shiftChar(char, -shift)
    }
    return decryptedChars.joinToString("")
}

fun shiftChar(char: Char, shift: Int): Char {
    val startOffset = if (char.isUpperCase()) 'A'.toInt() else 'a'.toInt()
    val shiftedChar = (char.toInt() - startOffset + shift + 26) % 26 + startOffset
    return shiftedChar.toChar()
}