
/*Камень-Ножницы-Бумага (три события)
Создать консольную игру "Камень-Ножницы-Бумага" (три события). На консоль выводится выбор компьютера (случайное значение) и выбор игрока. Для ускорения ввода выбора игрока можно условиться, что, например, 1 - это камень, 2 - ножницы, 3 - бумага. Выполненное задание представить в виде ссылки на GitHub

Победитель определяется по следующим правилам:

Бумага побеждает камень («бумага обёртывает камень»).
Камень побеждает ножницы («камень затупляет или ломает ножницы»).
Ножницы побеждают бумагу («ножницы разрезают бумагу»).
Если игроки показали одинаковый знак, то засчитывается ничья и игра переигрывается.*/

import kotlin.random.Random

fun main() {
    println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
    val playerChoice = readLine()?.toIntOrNull()
    val computerChoice = Random.nextInt(1, 4)

    if (playerChoice != null && playerChoice in 1..3) {
        val result = getResult(playerChoice, computerChoice)
        displayResult(playerChoice, computerChoice, result)
    } else {
        println("Некорректный ввод")
    }
}

fun getResult(playerChoice: Int, computerChoice: Int): String {
    return when {
        playerChoice == computerChoice -> "Ничья"
        (playerChoice == 1 && computerChoice == 2) || (playerChoice == 2 && computerChoice == 3) || (playerChoice == 3 && computerChoice == 1) -> "Игрок победил"
        else -> "Компьютер победил"
    }
}

fun displayResult(playerChoice: Int, computerChoice: Int, result: String) {
    val playerHand = getHand(playerChoice)
    val computerHand = getHand(computerChoice)

    println("Игрок выбрал: $playerHand")
    println("Компьютер выбрал: $computerHand")
    println("Результат: $result")
}

fun getHand(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> ""
    }
}