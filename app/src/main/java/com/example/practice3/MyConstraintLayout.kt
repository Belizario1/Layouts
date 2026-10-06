package com.example.practice3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/* ---------------------------------------------------------------
   EJERCICIO 1 (3 ptos)
   Caja roja centrada y cuatro cajas en las esquinas (forma de "X")
---------------------------------------------------------------- */
@Preview(showBackground = true)
@Composable
fun ConstraintExample1() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxMagenta, boxYellow, boxGreen) = createRefs()

        // Roja: centrada en el padre
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        // Azul: arriba-izquierda de la roja
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                }
        )
        // Magenta: arriba-derecha de la roja
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                }
        )
        // Amarilla: abajo-izquierda de la roja
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                }
        )
        // Verde: abajo-derecha de la roja
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                }
        )
    }
}

/* ---------------------------------------------------------------
   EJERCICIO 2 (8 ptos)
   Siete cajas en forma de cruz/zigzag alrededor de la roja central
---------------------------------------------------------------- */
@Preview(showBackground = true)
@Composable
fun ConstraintExample2() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxGreen,
            boxMagenta, boxCyan, boxBlack) = createRefs()

        // Roja: centro de la pantalla
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        // Azul: arriba-izquierda de la roja
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                }
        )
        // Amarilla: arriba-derecha de la roja
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                }
        )
        // Verde: encima del hueco entre azul y amarilla (alineada con la roja)
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxBlue.top)
                    start.linkTo(boxRed.start)
                    end.linkTo(boxRed.end)
                }
        )
        // Magenta: abajo-izquierda de la roja
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                }
        )
        // Cyan: abajo-derecha de la roja
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                }
        )
        // Negra: debajo del hueco entre magenta y cyan (alineada con la roja)
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    top.linkTo(boxMagenta.bottom)
                    start.linkTo(boxRed.start)
                    end.linkTo(boxRed.end)
                }
        )
    }
}

/* ---------------------------------------------------------------
   EJERCICIO 3 (9 ptos)
   Igual que el ejercicio 1, pero con 3 cajitas (cyan, negra, negra)
   formando una escalera diagonal entre la azul y la magenta
---------------------------------------------------------------- */
@Preview(showBackground = true)
@Composable
fun ConstraintExample3() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxMagenta, boxYellow, boxGreen,
            smallCyan, smallBlack1, smallBlack2) = createRefs()

        // Roja: centrada
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                }
        )

        // Escalera diagonal: cyan -> negra -> negra (cada una ~1/3 de la roja)
        // Cyan: pegada al borde derecho de la azul, alineada abajo con ella
        Box(
            modifier = Modifier
                .size(33.dp)
                .background(Color.Cyan)
                .constrainAs(smallCyan) {
                    start.linkTo(boxBlue.end)
                    bottom.linkTo(boxBlue.bottom)
                }
        )
        // Negra 1: a la derecha y encima de la cyan
        Box(
            modifier = Modifier
                .size(33.dp)
                .background(Color.Black)
                .constrainAs(smallBlack1) {
                    start.linkTo(smallCyan.end)
                    bottom.linkTo(smallCyan.top)
                }
        )
        // Negra 2: a la derecha y encima de la negra 1
        Box(
            modifier = Modifier
                .size(33.dp)
                .background(Color.Black)
                .constrainAs(smallBlack2) {
                    start.linkTo(smallBlack1.end)
                    bottom.linkTo(smallBlack1.top)
                }
        )
    }
}