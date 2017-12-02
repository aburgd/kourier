@file:JvmName("Kourier")

/**
 * @author Alec Burgdorf <aeburgd at gmail dot com>
 * @version 0.1.0
 */

package kourier

import player.Courier
import utils.print
import java.util.*

fun main(args: Array<String>) {
    val stdin: Scanner = Scanner(System.`in`)

    print("Mojave Express Courier Application\n")

    print("Name: ")
    val playerName: String = stdin.nextLine()
    print("Age: ")
    val playerAge: String = stdin.nextInt().toString()
    print("Gender: ")
    val playerGender: String = stdin.next()
    println()

    val randomSeed: Long = utils.randomSeed(playerName, playerAge, playerGender)
    val newPlayer: Courier = Courier(randomSeed)

    val playerSpecial: MutableMap<String, Int> = utils.SPECIALUtils.rollSPECIAL()
    var playerSkills: Array<String?> = newPlayer.skillTag()
    var playerTraits: Array<String?> = newPlayer.traitPick()

    val validSpecial: Boolean = utils.SPECIALUtils.isValidSPECIAL(playerSpecial)
    var validSkills: Boolean = utils.SkillsUtils.isValidSkills(playerSkills)
    var validTraits: Boolean = utils.TraitsUtils.isValidTraits(playerTraits)

    println("SPECIAL")
    println("-------")
    if (validSpecial) {
        playerSpecial.print()
    }
    println("Valid: $validSpecial")
    println()

    println("Skills")
    println("------")
    if (validSkills) {
        playerSkills.print()
    } else {
        while (!validSkills) {
            playerSkills = newPlayer.skillTag()
            validSkills = utils.SkillsUtils.isValidSkills(playerSkills)
        }
        playerSkills.print()
    }
    println("Valid: $validSkills")
    println()

    println("Traits")
    println("------")
    if (validTraits) {
        playerTraits.print()
    } else {
        while (!validTraits) {
            playerTraits = newPlayer.traitPick()
            validTraits = utils.TraitsUtils.isValidTraits(playerTraits)
        }
        playerTraits.print()
    }
    println("Valid: $validTraits")
    println()
}
