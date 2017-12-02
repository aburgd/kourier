package kotlintest

import io.kotlintest.matchers.*
import io.kotlintest.specs.FunSpec
import player.Courier
import java.util.*

class CourierTests : FunSpec() {
    private val testSeed: Long = 10_192_010L // release date represented as long
    private val testPlayer: Courier = Courier(testSeed)

    private fun ClosedRange<Int>.random(): Int = Random().nextInt(endInclusive) + start

    private val testRangeA: ClosedRange<Int> = (1..7)
    private val testRandomA: Int = testRangeA.random()

    private val testRangeB: ClosedRange<Int> = (100..100_000)
    private val testRandomB: Int = testRangeB.random()

    private val testSpecialA = testPlayer.specialAssign()

    init {
        test("ClosedRange<Int>.random() should return an integer within the given range") {
            testRandomA shouldBe between(testRangeA.start, testRangeA.endInclusive)
            testRandomB shouldBe between(testRangeB.start, testRangeB.endInclusive)
            (0..1_000_000).random() shouldBe between(0, 1_000_000)
            (1..100_000_000).random() shouldBe between(1, 100_000_000)
        }
    }

    init {
        test("testPlayer.skillTag() should return an array of nullable strings") {
            testPlayer.skillTag() should beOfType<Array<String?>>()
            testPlayer.skillTag() should beOfType<Array<String?>>()
            testPlayer.skillTag() should beOfType<Array<String?>>()
        }
    }

    init {
        test("testPlayer.traitPick() should return an array of nullable strings") {
            testPlayer.skillTag() should beOfType<Array<String?>>()
            testPlayer.skillTag() should beOfType<Array<String?>>()
            testPlayer.skillTag() should beOfType<Array<String?>>()
        }
    }

    init {
        test("testPlayer.specialAssign() should return a mutable map with 7 String keys") {
            testSpecialA should haveKey("Strength")
            testSpecialA should haveKey("Perception")
            testSpecialA should haveKey("Endurance")
            testSpecialA should haveKey("Charisma")
            testSpecialA should haveKey("Intelligence")
            testSpecialA should haveKey("Agility")
            testSpecialA should haveKey("Luck")
        }
    }
}
