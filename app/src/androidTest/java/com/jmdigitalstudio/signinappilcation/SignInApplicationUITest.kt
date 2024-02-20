package com.jmdigitalstudio.signinappilcation

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.jmdigitalstudio.signinappilcation.ui.theme.SignInAppilcationTheme
import org.junit.Rule
import org.junit.Test

class SignInApplicationUITest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pageNavigationsTest() {
        composeTestRule.setContent {
            SignInAppilcationTheme {
                SignInAppMain()
            }
        }

        // Verify initial screen is SignInApp
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.application_title)).assertExists()

        // Perform navigation to LoginScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.sign_in)).performClick()

        // Verify navigation to LoginScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.login_page)).assertExists()

        // Simulate pressing back
        Espresso.pressBack()

        // Perform navigation to LogoutScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.sign_out)).performClick()

        // Verify navigation to LogoutScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.logout_page)).assertExists()

        // Simulate pressing back
        Espresso.pressBack()

        // Perform navigation to LogoutScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.admin)).performClick()

        // Verify navigation to LogoutScreen
        composeTestRule.onNodeWithText(getInstrumentation().targetContext.getString(R.string.admin_page)).assertExists()
    }
}