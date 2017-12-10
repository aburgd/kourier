---
title: Courier - kourier
---

[kourier](../../index.html) / [player](../index.html) / [Courier](.)

# Courier

`class Courier`

The class containing the static methods for generating a player Courier

### Constructors

| [&lt;init&gt;](-init-.html) | `Courier(randomSeed: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>The class containing the static methods for generating a player Courier |

### Functions

| [skillTag](skill-tag.html) | `fun skillTag(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Static method that chooses three skills from the [SKILLS](#) constant |
| [specialAssign](special-assign.html) | `fun specialAssign(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`<br>Static method that generates random integers within the range from 1 to 7 (incl), and assigns those values to the 7 keys of SPECIAL |
| [traitPick](trait-pick.html) | `fun traitPick(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Static method that chooses two traits from the [TRAITS](#) constant |

