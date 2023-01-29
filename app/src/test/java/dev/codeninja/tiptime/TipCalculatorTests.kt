package dev.codeninja.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
	@Test
	fun calculate_20_percent_tip_no_round_up() {
		val amount = 10.00
		val tip = 20.00
		val expectedTip = NumberFormat.getCurrencyInstance().format(2)
		val actualTip = calculateTip(amount, tip, false)
		assertEquals(expectedTip, actualTip)
	}
}