package com.example.testeableapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Assert.*

class RestaurantOrderTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    //Prueba UI 1
    @Test
    fun mensajePedidoVacioVisibleAlInicio() {

        composeTestRule
            .onNodeWithTag("appTitle")
            .assertIsDisplayed()
    }

    //PRUEBA UI 2:
    @Test
    fun todosLosItemsDelMenuVisibles() {

        composeTestRule
            .onNodeWithTag("menuItemName_1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("menuItemName_2")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("menuItemName_3")
            .assertIsDisplayed()
    }

    //Prueba UI 3
    @Test
    fun totalGeneralSeActualiza() {

        composeTestRule
            .onNodeWithTag("addButton_1")
            .performClick()

        composeTestRule
            .onNodeWithTag("totalValue")
            .assertIsDisplayed()
    }

    //Prueba UI adicional 1
    @Test
    fun tituloPrincipalVisible() {

        composeTestRule
            .onNodeWithTag("appTitle")
            .assertIsDisplayed()
    }

    //Prueba UI adicional 2
    @Test
    fun subtituloVisible() {

        composeTestRule
            .onNodeWithTag("appSubtitle")
            .assertIsDisplayed()
    }

    //Test adicional 1
    @Test
    fun pedidoIniciaVacio() {

        val viewModel = RestaurantViewModel()

        assertTrue(
            viewModel.isEmpty.value
        )
    }

    //Test adicional 2
    @Test
    fun decrementarReduceCantidad() {

        val viewModel = RestaurantViewModel()

        viewModel.addItem(1)
        viewModel.addItem(1)

        viewModel.decrementItem(1)

        assertEquals(
            1,
            viewModel.quantities.value[1]
        )
    }
}