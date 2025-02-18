package Char


import CharacterLogic.{al, farnoosh, lan, april, characterList}


object CharacterFilterLogic {
 

  def filter(characterList: List[Character], chosenCharacter: Character, filterTrait: String, subject: Int): List[Character] = {
    val filterList: List[Character] =
      if (chosenCharacter.describe.contains(filterTrait.toLowerCase())) {
        TerminalLogic.filterMessage(subject, filterTrait, correct = true)
        characterList.filter(
          char => char.describe.contains(
           " " + filterTrait.toLowerCase
          )
        )

      } else {
        TerminalLogic.filterMessage(subject, filterTrait, correct = false)
        characterList.filterNot(
          char => char.describe.contains(
            " " + filterTrait.toLowerCase
          )
        )
      }

    filterList
  }

  //println(filter(characterList, april, "Lady").map(char => char.describe))

}







