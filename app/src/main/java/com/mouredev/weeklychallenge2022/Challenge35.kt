package com.mouredev.weeklychallenge2022

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main() {
    println("pikachu ataca a square y este recibe ${getDamage(PokemonType.ELECTRIC, PokemonType.WATER, 60, 80)} de daño")
}

enum class PokemonType {
    WATER, FIRE, PLANT, ELECTRIC
}

fun getDamage(target: PokemonType, opponent: PokemonType, attack: Int, defence: Int): Double {
    if (!IntRange(1, 100).contains(attack)) {
        return 0.0
    }
    if (!IntRange(1, 100).contains(defence)) {
        return 0.0
    }
    return 50 * (attack.toDouble() / defence.toDouble()) * getEffectivity(target, opponent)
}

fun getEffectivity(target: PokemonType, opponent: PokemonType): Double {
    return when(target) {
        PokemonType.ELECTRIC -> when(opponent) {
            PokemonType.ELECTRIC -> 0.5
            PokemonType.FIRE -> 1.0
            PokemonType.PLANT -> 0.5
            PokemonType.WATER -> 2.0
        }
        PokemonType.FIRE -> when(opponent) {
            PokemonType.ELECTRIC -> 1.0
            PokemonType.FIRE -> 0.5
            PokemonType.PLANT -> 2.0
            PokemonType.WATER -> 0.5
        }
        PokemonType.PLANT -> when(opponent) {
            PokemonType.ELECTRIC -> 1.0
            PokemonType.FIRE -> 0.5
            PokemonType.PLANT -> 0.5
            PokemonType.WATER -> 2.0
        }
        PokemonType.WATER -> when(opponent) {
            PokemonType.ELECTRIC -> 1.0
            PokemonType.FIRE -> 2.0
            PokemonType.PLANT -> 0.5
            PokemonType.WATER -> 0.5
        }
    }
}
