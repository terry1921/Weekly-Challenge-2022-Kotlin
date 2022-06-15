package com.mouredev.weeklychallenge2022

import kotlin.math.max
import kotlin.math.min

/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


fun main () {
    println("mcm: ${mcm(10,15)}")
}

fun mcm(num1: Int, num2: Int): Int {
    val a = max(num1, num2)
    val b = min(num1, num2)
    return a / mcd(num1, num2) * b
}

fun mcd(num1: Int, num2: Int): Int {
    var a = max(num1, num2)
    var b = min(num1, num2)
    var resultado = 0
    do {
        resultado = b
        b = a % b
        a = resultado
    } while (b != 0)
    println("mcd: $resultado")
    return resultado
}