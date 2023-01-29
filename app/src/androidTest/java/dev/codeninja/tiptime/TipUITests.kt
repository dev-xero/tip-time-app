package dev.codeninja.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import dev.codeninja.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun calculate_20_percent_tip() {
		composeTestRule.setContent {
			TipTimeTheme {
				TipTimeScreen()
			}
		}
		composeTestRule.onNodeWithText("Cost of Service")
			.performTextInput("10")
		composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
		val expectedTip = NumberFormat.getCurrencyInstance().format(2)
		composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
			"No node with this text was found."
		)
	}

}