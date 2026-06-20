package com.example.testeableapp

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {

    //Prueba 1
    @Test
    fun agregarItemAlPedido() {

        val viewModel = RestaurantViewModel()

        viewModel.addItem(1)

        assertEquals(
            1,
            viewModel.quantities.value[1]
        )
    }

    //Prueba 2
    @Test
    fun incrementarYDecrementarCantidad() {

        val viewModel = RestaurantViewModel()

        viewModel.addItem(1)

        viewModel.incrementItem(1)

        assertEquals(
            2,
            viewModel.quantities.value[1]
        )

        viewModel.decrementItem(1)

        assertEquals(
            1,
            viewModel.quantities.value[1]
        )
    }

    //Prueba 3
    @Test
    fun eliminarItemAlDecrementarDesdeUno() {

        val viewModel = RestaurantViewModel()

        viewModel.addItem(1)

        viewModel.decrementItem(1)

        assertFalse(
            viewModel.quantities.value.containsKey(1)
        )
    }

    //Prueba 4
    @Test
    fun calcularTotalCorrectamente() {

        val viewModel = RestaurantViewModel()

        viewModel.addItem(1)

        assertEquals(
            5.50,
            viewModel.total.value,
            0.01
        )
    }
}


