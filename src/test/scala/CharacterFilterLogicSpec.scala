import Char.{Character, CharacterFilterLogic}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import Char.CharacterLogic.{al, characterList, farnoosh, lan, april, tudor}

class CharacterFilterLogicSpec extends AnyWordSpec with Matchers {
  val testCharList:List[Character] = List(al, lan, april, tudor)
  "CharacterFilterLogic.filter" should {
    "return a list of characters who are female" when {
      "The chosen character is a lady and lady is the specified trait" in {
        val filteredList: List[Character] = CharacterFilterLogic.filter(
          testCharList, april, "female", 1
        )
        val expectedResult: List[Character] = List(lan, april)
        filteredList shouldBe expectedResult
      }

      "The chosen character is a lady and man is the specified trait" in {
        val filteredList: List[Character] = CharacterFilterLogic.filter(
          testCharList, april, "male", 1
        )
        val expectedResult: List[Character] = List(lan, april)
        filteredList shouldBe expectedResult
      }

    }
  }
}