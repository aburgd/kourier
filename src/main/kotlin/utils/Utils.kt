/**
 * Contains classes for validations and printing
 */
package utils

import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.person.Person
import io.codearte.jfairy.producer.person.PersonProperties.*
import player.Courier
import java.util.HashSet
import java.util.Random

val fairy: Fairy = Fairy.create()
val genders: Array<String> = arrayOf("male", "female", "nonbinary", "agender", "androgyne", "bigender", "pangender", "transmasculine", "transfeminine")
val fairyGenders: Array<String> = arrayOf("male", "female")

fun ClosedRange<Int>.random(): Int {
    return Random().nextInt(endInclusive) + start
}

/**
 * Add a `print` function to `Array<String?>` to displays skills and traits
 */
fun Array<String?>.print() {
    for (item: String? in this) {
        println(item)
    }
}

/**
 * Adds a `print` function to `MutableMap<String, Int>` to display SPECIAL stats
 */
fun MutableMap<String, Int>.print() {
    for (entry: MutableMap.MutableEntry<String, Int> in this) {
        println("${entry.key}: ${entry.value}")
    }
}

/**
 * A class for validating SPECIAL stats
 */
class SPECIALUtils {
    companion object {
        private val player: Courier = Courier(Random().nextLong())
        /**
         * Rolls a `MutableMap<String, Int>` of SPECIAL stats (Strength, Perception, Endurance, etc)
         * @return `MutableMap<String, Int>` of SPECIAL stats
         */
        fun rollSPECIAL(): MutableMap<String, Int> {
            var special: MutableMap<String, Int> = player.specialAssign()
            var isValid: Boolean = isValidSPECIAL(special)
            if (!isValid) {
                while (!isValid) {
                    special = player.specialAssign()
                    isValid = isValidSPECIAL(special)
                }
            }
            return special
        }

        /**
         * Determines validity of a rolled SPECIAL `MutableMap<String, Int>`
         * @param [special] a `MutableMap<String, Int>`
         * @return `Boolean` valid [special] or not
         */
        fun isValidSPECIAL(special: MutableMap<String, Int>): Boolean {
            val allValues: Collection<Int> = special.values
            if (allValues.sum() == 40) return true
            return false
        }
    }
}

/**
 * A class for validating Traits
 */
class TraitsUtils {
    companion object {
        /**
         * Determines validity of a rolled `Array<String?>` of traits
         * @param [traits] an `Array<String?>` containing the randomly selected traits
         * @return `Boolean` valid [traits] or not
         */
        fun isValidTraits(traits: Array<String?>): Boolean {
            val hashCodes: HashSet<Int?> = hashSetOf()
            traits.forEach { trait: String? -> hashCodes.add(trait?.hashCode()) }
            if (hashCodes.size == traits.size) return true
            return false
        }
    }
}

/**
 * A class for validating Skills
 */
class SkillsUtils {
    companion object {
        /**
         * Determines validity of a rolled `Array<String?>` of skill
         * @param [skills] an `Array<String?>` containing the randomly selected skills
         * @return `Boolean` valid [skills] or not
         */
        fun isValidSkills(skills: Array<String?>): Boolean {
            val hashCodes: HashSet<Int?> = hashSetOf()
            skills.forEach { skill: String? -> hashCodes.add(skill?.hashCode()) }
            if (hashCodes.size == skills.size) return true
            return false
        }
    }
}

/**
 * Casts the given item to a long using its hashCode
 * @param item object type `Any` to make a new long
 * @return the new `Long` of the object's hashCode
 */
fun toLong(item: Any): Long {
    return Math.abs(item.hashCode().toLong())
}

/**
 * Generates a new seed from a `String` or array of `Strings`
 * @param items array of strings
 * @return the new seed
 */
fun randomSeed(vararg items: Any): Long {
    var newSeed: Long = 0L
    for (item: Any in items) {
        newSeed += toLong(item)
    }
    return newSeed
}

fun newCourier(gender: String): Person {
    val courier: Person
    when {
    // for traditionally masculine names
        gender.equals(genders[7]) || gender.equals(genders[0]) -> {
            courier = fairy.person(male(), minAge(16), maxAge(250))
            return courier
        }
    // for traditionally feminine names
        gender.equals(genders[8]) || gender.equals(genders[1]) -> {
            courier = fairy.person(female())
            return courier
        }
        else -> {
            val nameGender: String = courierNameGender(gender)
            courier = if (nameGender.equals(fairyGenders[1])) {
                fairy.person(female())
            } else {
                fairy.person(male())
            }
            return courier
        }
    }
}

fun courierNameGender(printedGender: String): String {
    return when {
        printedGender.equals(genders[7]) || printedGender.equals(genders[0]) -> "male"
        printedGender.equals(genders[8]) || printedGender.equals(genders[1]) -> "female"
        else -> fairyGenders[(0..1).random()]
    }
}

fun courierPrintedGender(): String {
    return genders[(0..genders.size).random()]
}
