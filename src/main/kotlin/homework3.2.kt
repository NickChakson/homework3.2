fun main() {

    val cardType: String = typeCard()
    var transfer: Double
    print("Сумма предыдущих переводов в этом месяце (в рублях): ")
    val transferCent = readln().toDouble() * 100
    transfer = transferCent
    print("Укажите размер перервода(в рублях): ")
    val amount = readln().toDouble() * 100
    paySystem(cardType, transfer, amount)

}

fun paySystem(cardTypeFun: String, transferFun: Double, amountFun: Double) {
    when (cardTypeFun) {
        "Mastercard", "Maestro" -> {
            val tax: Double
            val amountFunRub: Double = amountFun / 100
            if (transferFun < 7500000) {
                tax = 0.0
                val taxRub = tax / 100.0
                val amountFunAfterTax = (amountFun - tax) / 100.0
                println("Осуществлён перевод на сумму: $amountFunRub руб., комиссия: $taxRub руб.")
                print("Итого поступления на счёт: $amountFunAfterTax руб.")
            } else {
                tax = 0.006 * amountFun + 2000
                val taxRub = tax / 100.0
                val amountFunAfterTax = (amountFun - tax) / 100.0
                println("Осуществлён перевод на сумму: $amountFunRub руб., комиссия: $taxRub руб.")
                print("Итого поступления на счёт: $amountFunAfterTax руб.")
            }
        }
        "Visa", "МИР" -> {
            val tax: Double = if (amountFun * 0.075 < 3500) 3500.0 else amountFun * 0.075
            val taxRub = tax / 100.0
            val amountFunRub: Double = amountFun / 100
            val amountFunAfterTax = (amountFun - tax) / 100.0
            println("Осуществлён перевод на сумму: $amountFunRub руб., комиссия: $taxRub руб.")
            print("Итого поступления на счёт: $amountFunAfterTax руб.")

        }
        "VK Pay" -> {
            val tax = 0.0
            val taxRub = tax / 100.0
            val amountFunRub: Double = amountFun / 100
            val amountFunAfterTax = (amountFun - tax) / 100.0
            println("Осуществлён перевод на сумму: $amountFunRub руб., комиссия: $taxRub руб.")
            print("Итого поступления на счёт: $amountFunAfterTax руб.")
        }


    }

}

fun typeCard(): String {
    println("Укажите платёжную систему")
    println("1. Mastercard")
    println("2. Maestro")
    println("3. Visa")
    println("4. МИР")
    println("5. VK Pay")
    return when (readln()) {
        "1" -> "Mastercard"
        "2" -> "Maestro"
        "3" -> "Visa"
        "4" -> "МИР"
        "5" -> "VK Pay"
        else -> "Ошибка"
    }

}