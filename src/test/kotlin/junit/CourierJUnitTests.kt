package junit

import org.junit.Test
import player.Courier
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CourierJUnitTests {
    private val testSeed: Long = 10_192_010L // release date represented as long
    private val testPlayer: Courier = Courier(testSeed)

    private fun ClosedRange<Int>.random(): Int = Random().nextInt(endInclusive) + start

    private val testRangeA: ClosedRange<Int> = (1..7)
    private val testRandomA: Int = testRangeA.random()

    private val testRangeB: ClosedRange<Int> = (100..100_000)
    private val testRandomB: Int = testRangeB.random()

    // A cases true, B cases false
    private val testSpecialA = testPlayer.specialAssign()
    private val testSkillsA = arrayOf<String?>("gun", "melee weapons", "energy weapons")
    private val testSkillsB = arrayOf<String?>("guns", "melee weapons", "guns")
    private val testTraitsA = testPlayer.traitPick()
    private val testTraitsB = arrayOf<String?>("small frame", "small frame")

    @Test
    fun testTestPlayer() {
        assertNotNull(testPlayer)
    }

    @Test
    fun testClosedRangeRandom() {
        assert(testRandomA in testRangeA.start..testRangeA.endInclusive)
        assert(testRandomB in testRangeB.start..testRangeB.endInclusive)
        assert((0..100_000).random() in 0..100_000)
    }

    @Test
    fun testSpecialAssign() {
        assertNotNull(testSpecialA)
        assertEquals(7, testSpecialA.size)
        for ((_: String, value: Int) in testSpecialA) {
            assert(value in (1..7))
        }
    }

    @Test
    fun testSkillTag() {
        assertTrue { utils.SkillsUtils.isValidSkills(testSkillsA) }
        assertFalse { utils.SkillsUtils.isValidSkills(testSkillsB) }
        assertEquals(3, testSkillsA.size)
        assertEquals(3, testSkillsB.size)
    }

    @Test
    fun testTraitPick() {
        assertTrue { utils.TraitsUtils.isValidTraits(testTraitsA) }
        assertFalse { utils.TraitsUtils.isValidTraits(testTraitsB) }
        assertEquals(2, testTraitsA.size)
        assertEquals(2, testTraitsB.size)
    }
}
