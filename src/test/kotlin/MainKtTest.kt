import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculatingCommission() {
        val amount = 10_000_00
        val previousBuyingSum = 300_00
        for (card in PaymentSystem.values()) {
            val result = calculatingCommission(
                amount = amount,
                previousBuyingSum = previousBuyingSum,
                typeOfCard = card
            )
            println("$card $result")

            val hope = when (card) {
                PaymentSystem.VkPay -> 0
                PaymentSystem.Visa, PaymentSystem.Mir -> 7500
                PaymentSystem.Maestro, PaymentSystem.MasterCard -> 0
            }
            assertEquals(hope, result)
        }
        val result = calculatingCommission(amount, previousBuyingSum, PaymentSystem.VkPay)
        assertEquals(0, result)

    }

    @Test
    fun calculateWithCommission() {

        val result = calculatingCommission(
            amount = 100_000_00,
            previousBuyingSum = 76_000_00,
            typeOfCard = PaymentSystem.Maestro
        )
        println(result)
        assertEquals(62000, result)
    }

    @Test
    fun limits() {
        val amount = 10_000_00
        val previousBuyingSum = 300_00
        for (card in PaymentSystem.values()) {
            val result = limits(
                amount = amount,
                previousBuyingSum = previousBuyingSum,
                typeOfCard = card
            )
            println(result)
            assertEquals("Перевод возможен", result)
        }

        for (card in PaymentSystem.values()) {
            val result = limits(
                amount = 150_000_00,
                previousBuyingSum = 690_000_00,
                typeOfCard = card
            )
            println(result)
            assertEquals("Перевод не возможен", result)
        }
    }
}

