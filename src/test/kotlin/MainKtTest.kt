import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

        @Test
        fun calculatingTheCommission_paymentSystem_Vkpay() {
            val sum = 100000
            val sumPastTransfer = 0
            val paymentSystem: PaymentSystem = PaymentSystem.VkPay

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(0, result)
        }

        @Test
        fun calculatingTheCommission_paymentSystem_Visa() {
            val sum = 100000
            val sumPastTransfer = 0
            val paymentSystem: PaymentSystem = PaymentSystem.Visa

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(3500, result)
        }

        @Test
        fun calculatingTheCommission_paymentSystem_MasterCard() {
            val sum = 100000
            val sumPastTransfer = 0
            val paymentSystem: PaymentSystem = PaymentSystem.MasterCard

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(2600, result)
        }

        @Test
        fun calculatingTheCommission_paymentSystem_Maestro() {
            val sum = 100000
            val sumPastTransfer = 0
            val paymentSystem: PaymentSystem = PaymentSystem.Maestro

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(2600, result)
        }

        @Test
        fun calculatingCommission_paymentSystem_Mir() {
            val sum = 100000
            val sumPastTransfer = 0
            val paymentSystem: PaymentSystem = PaymentSystem.Mir

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(3500, result)
        }

        @Test
        fun calculatingCommission_default() {
            val sum = 100000


            val result = calculatingCommission(
                sum = sum
            )

            assertEquals(0, result)
        }

        @Test
        fun calculatingCommission_MasterCard_sumPastTrans() {
            val sum = 100000
            val sumPastTransfer = 100000
            val paymentSystem: PaymentSystem = PaymentSystem.MasterCard

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(0, result)
        }

        @Test
        fun calculatingCommission_Mir_bigSum() {
            val sum = 1000000
            val sumPastTransfer = 100000
            val paymentSystem: PaymentSystem = PaymentSystem.Mir

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(7500, result)
        }

        @Test
        fun calculatingCommission_Maestro_sumPastTransfer() {
            val sum = 100000
            val sumPastTransfer = 75000000
            val paymentSystem: PaymentSystem = PaymentSystem.Maestro

            val result = calculatingCommission(
                sum = sum,
                sumPastTransfer = sumPastTransfer,
                paymentSystem = paymentSystem
            )

            assertEquals(2600, result)
        }
    }

