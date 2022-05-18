import PaymentSystem.*

const val MIN_COMMISSION = 35_00
const val MIN_TRANSFER_WITHOUT_COMMISSION = 300_00
const val MAX_TRANSFER_WITHOUT_COMMISSION = 75_000_00


fun main() {
    val card = Mir
    val amount = 10_000_00
    val previousBuyingSum = 300_00
    println(limits(amount, previousBuyingSum, card))
    println("Комиссия составляет: ${calculatingCommission(amount, previousBuyingSum, card)} копеек.")
}

fun calculatingCommission(
    amount: Int,
    previousBuyingSum: Int = 0,
    typeOfCard: PaymentSystem = VkPay
): Int = when (typeOfCard) {
    VkPay -> 0
    Visa, Mir -> {
        val commission = amount * 0.0075
        if (commission < MIN_COMMISSION) MIN_COMMISSION else commission.toInt()
    }
    Maestro, MasterCard -> {
        val commission = amount * 0.006 + 20_00
        if (previousBuyingSum in MIN_TRANSFER_WITHOUT_COMMISSION..
            MAX_TRANSFER_WITHOUT_COMMISSION
        ) 0
        else commission.toInt()
    }
}

fun limits(
    amount: Int,
    previousBuyingSum: Int,
    typeOfCard: PaymentSystem,
): String {
    val transferInMonth = previousBuyingSum + amount
    return when (typeOfCard) {
        VkPay -> {
            val maxSumTransferInDay = 15_000_00
            val maxSumTransferInMonth = 40_000_00
            if (maxSumTransferInDay > amount ||
                maxSumTransferInMonth > transferInMonth
            ) "Перевод возможен"
            else "Перевод не возможен"
        }
        Visa, Mir, MasterCard, Maestro -> {
            val maxSumTransferInDay = 150_000_00
            val maxSumTransferInMonth = 600_000_00
            if (maxSumTransferInDay > amount ||
                maxSumTransferInMonth > transferInMonth
            ) "Перевод возможен"
            else "Перевод не возможен"
        }
    }
}