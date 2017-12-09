package junit

import org.junit.Test
import kotlin.test.assertTrue
import utils.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class UtilsJUnitTest {
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

    @Test
    fun testIsValidSkills() {
        assertTrue { SkillsUtils.isValidSkills(testSkillsA) }
        assertFalse { SkillsUtils.isValidSkills(testSkillsB) }
    }

    @Test
    fun testIsValidTraits() {
        assertTrue { TraitsUtils.isValidTraits(testTraitsA) }
        assertFalse { TraitsUtils.isValidTraits(testTraitsB) }
    }

    @Test
    fun testIsValidSPECIAL() {
        assertTrue { SPECIALUtils.isValidSPECIAL(testSpecialA) }
        assertFalse { SPECIALUtils.isValidSPECIAL(testSpecialB) }
    }

    @Test
    fun testToLong() {
        assertEquals(10192010, toLong(10_192_010L))
        assertEquals(318923937, toLong("test string"))
    }
}
