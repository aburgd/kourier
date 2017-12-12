@file:JvmName("Kourier")

/**
 * @author Alec Burgdorf <aeburgd at gmail dot com>
 * @version 0.1.0
 */

package kourier

import io.codearte.jfairy.producer.person.Person
import player.Courier
import utils.print
import java.util.Scanner

fun main(args: Array<String>) {
    val stdin: Scanner = Scanner(System.`in`)

    val playerName: String
    val playerAge: String
    val playerGender: String

    print("Mojave Express Courier Application\n")

    print("Do you have a desired name, gender, AND age? (y/n) ")
    val ans: String = stdin.next()
    when (ans) {
        "y", "Y" -> {
            print("Name: ")
            playerName = stdin.next().capitalize().plus(" ").plus(stdin.next().capitalize())
            print("Age: ")
            playerAge = stdin.nextInt().toString()
            print("Gender: ")
            playerGender = stdin.next()
            println()
        }
        else -> {
            playerGender = utils.courierPrintedGender()
            val nameGender: String = utils.courierNameGender(playerGender)
            val newPlayer: Person = utils.newCourier(nameGender)
            playerAge = newPlayer.age.toString()
            playerName = newPlayer.fullName
        }
    }

    val randomSeed: Long = utils.randomSeed(playerName, playerAge, playerGender)
    val newPlayer: Courier = Courier(randomSeed)

    val playerSpecial: MutableMap<String, Int> = utils.SPECIALUtils.rollSPECIAL()
    var playerSkills: Array<String?> = newPlayer.skillTag()
    var playerTraits: Array<String?> = newPlayer.traitPick()

    val validSpecial: Boolean = utils.SPECIALUtils.isValidSPECIAL(playerSpecial)
    var validSkills: Boolean = utils.SkillsUtils.isValidSkills(playerSkills)
    var validTraits: Boolean = utils.TraitsUtils.isValidTraits(playerTraits)

    println("Review:\n======")
    println("Name: $playerName")
    println("Age: $playerAge")
    println("Gender $playerGender")

    println()
    println("Attributes")
    println("==========")

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
