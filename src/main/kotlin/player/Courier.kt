/**
 * Contains the methods for generating the defining characteristics of a player's Courier
 */
package player

import java.util.*
import utils.random

/**
 * The class containing the methods for generating a player Courier
 */
class Courier(randomSeed: Long) {
    private val rand: Random = Random(randomSeed)

    private val SPECIAL: Map<String, Int> = mapOf(
            "Strength" to 5,
            "Perception" to 5,
            "Endurance" to 5,
            "Charisma" to 5,
            "Intelligence" to 5,
            "Agility" to 5,
            "Luck" to 5
    )

    private val SKILLS: Array<String> = arrayOf(
            "energy weapons", "melee weapons", "guns", "barter",
            "repair", "speech", "explosives", "unarmed", "medicine"
    )

    private val TRAITS: Array<String> = arrayOf(
            "built to destroy", "fast shot", "four eyes", "good natured", "heavy natured",
            "kamikaze", "loose cannon", "small frame", "trigger discipline", "wild wasteland"
    )

    /**
     * Method that chooses three skills from the [SKILLS] constant
     * @return an array of nullable strings containing the skills
     */
    fun skillTag(): Array<String?> {
        val playerSkills: Array<String?> = arrayOfNulls(3)
        for (skill: String? in playerSkills) {
            val randomSkill: Int = rand.nextInt(SKILLS.size)
            playerSkills[playerSkills.indexOf(skill)] = SKILLS[randomSkill]
        }
        return playerSkills
    }

    /**
     * Method that chooses two traits from the [TRAITS] constant
     * @return an array of nullable strings containing the traits
     */
    fun traitPick(): Array<String?> {
        val playerTraits: Array<String?> = arrayOfNulls(2)
        for (trait: String? in playerTraits) {
            val randomTrait: Int = rand.nextInt(TRAITS.size)
            playerTraits[playerTraits.indexOf(trait)] = TRAITS[randomTrait]
        }
        return playerTraits
    }

    /**
     * Method that generates random integers within the range from 1 to 7 (incl), and
     * assigns those values to the 7 keys of SPECIAL
     * @return a mutable map of string keys and integer values
     */
    fun specialAssign(): MutableMap<String, Int> {
        val playerSpecial: MutableMap<String, Int> = SPECIAL.toMutableMap() // copy the SPECIAL
        val iterate: MutableIterator<MutableMap.MutableEntry<String, Int>> = playerSpecial.iterator() // make an iterator
        while (iterate.hasNext()) {
            val currentPair: MutableMap.MutableEntry<String, Int> = iterate.next()
            currentPair.setValue((1..7).random()) // set the value to a random int from 1 to 7 incl
        }
        return playerSpecial
    }
}
