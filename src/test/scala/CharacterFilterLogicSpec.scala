import Char.{Character, CharacterFilterLogic}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import Char.CharacterLogic.{al, farnoosh, lan, sheila}

class CharacterFilterLogicSpec extends AnyWordSpec with Matchers {
val characterList: List[Character] = List(al, sheila, lan, farnoosh)
"CharacterFilterLogic.filter" should {
  "return a list of characters who are female" when {
    "The chosen character is female and female is the specified trait" in {
      val filterdList:List[Character] = CharacterFilterLogic.filter(
        characterList, sheila, "Female"
      )
      val expectedResult: List[Character] = List(sheila, lan, farnoosh)
      filterdList shouldBe expectedResult
    }
  }
}
}
