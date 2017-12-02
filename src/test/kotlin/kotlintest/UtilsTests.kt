package kotlintest

import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNot
import io.kotlintest.specs.FunSpec

class UtilsTests : FunSpec() {

    private val testTraitsA: Array<String?> = arrayOf("built to destroy", "fast shot")
    private val testTraitsB: Array<String?> = arrayOf("fast shot", "fast shot")

    private val testSkillsA: Array<String?> = arrayOf("energy weapons", "melee weapons", "guns")
    private val testSkillsB: Array<String?> = arrayOf("energy weapons", "melee weapons", "melee weapons")

    private val testSpecialA: MutableMap<String, Int> = mutableMapOf(
            "Strength" to 7,
            "Perception" to 6,
            "Endurance" to 3,
            "Charisma" to 6,
            "Intelligence" to 7,
            "Agility" to 6,
            "Luck" to 5
    )

    private val testSpecialB: MutableMap<String, Int> = mutableMapOf(
            "Strength" to 5,
            "Perception" to 5,
            "Endurance" to 5,
            "Charisma" to 5,
            "Intelligence" to 5,
            "Agility" to 5,
            "Luck" to 5
    )

    init {
        test("utils.TraitsUtils.isValidTraits should return a boolean") {
            utils.TraitsUtils.isValidTraits(testTraitsA) shouldBe true
            utils.TraitsUtils.isValidTraits(testTraitsB) shouldBe false
        }
    }

    init {
        test("utils.SkillsUtils.isValidSkills should return a boolean") {
            utils.SkillsUtils.isValidSkills(testSkillsA) shouldBe true
            utils.SkillsUtils.isValidSkills(testSkillsB) shouldBe false
        }
    }

    init {
        test("utils.SPECIALUtils.isValidSPECIAL should return a boolean") {
            utils.SPECIALUtils.isValidSPECIAL(testSpecialA) shouldBe true
            utils.SPECIALUtils.isValidSPECIAL(testSpecialB) shouldBe false
        }
    }

    init {
        test("utils.toLong() should return a non-negative long") {
            utils.toLong("test string") should beOfType<Long>()
            utils.toLong("another test string") shouldNot beOfType<String>()
        }
    }

    init {
        test("utils.randomSeed should return a long from any object") {
            utils.randomSeed("test string", 10192010L, testSkillsA, testSpecialB) should beOfType<Long>()
            utils.randomSeed(testSpecialA, "another test string") should beOfType<Long>()
        }
    }
}
