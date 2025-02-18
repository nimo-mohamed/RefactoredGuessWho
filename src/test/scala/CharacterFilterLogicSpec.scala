import Char.{Character, CharacterFilterLogic}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import Char.CharacterLogic.{al, april, characterList, farnoosh, lan, sheila}

class CharacterFilterLogicSpec extends AnyWordSpec with Matchers {
"CharacterFilterLogic.filter" should {
  "return a list of characters who are female" when {
    "The chosen character is female and female is the specified trait" in {
      val filterdList:List[Character] = CharacterFilterLogic.filter(
        characterList, april, "Female"
      )
      val expectedResult: List[Character] = List(april, lan, farnoosh)
      filterdList shouldBe expectedResult
    }
  }
}
}
