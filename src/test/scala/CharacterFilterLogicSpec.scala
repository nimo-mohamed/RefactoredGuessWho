import Char.{Character, CharacterFilterLogic}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import Char.CharacterLogic.{al, characterList, farnoosh, lan, april}

class CharacterFilterLogicSpec extends AnyWordSpec with Matchers {
  "CharacterFilterLogic.filter" should {
    "return a list of characters who are female" when {
      "The chosen character is a lady and lady is the specified trait" in {
        val filteredList: List[Character] = CharacterFilterLogic.filter(
          characterList, april, "lady"
        )
        val expectedResult: List[Character] = List(april, lan, farnoosh)
        filteredList shouldBe expectedResult
      }

      "The chosen character is a lady and man is the specified trait" in {
        val filteredList: List[Character] = CharacterFilterLogic.filter(
          characterList, april, "man"
        )
        val expectedResult: List[Character] = List(april, lan, farnoosh)
        filteredList shouldBe expectedResult
      }

    }
  }
}