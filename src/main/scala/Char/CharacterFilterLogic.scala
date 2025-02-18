package Char


import CharacterLogic.{al, farnoosh, lan, april, characterList}


object CharacterFilterLogic {
 

  def filter(characterList: List[Character], chosenCharacter: Character, filterTrait: String): List[Character] = {
    val filterList: List[Character] =
      if (chosenCharacter.describe.contains(filterTrait.toLowerCase())) {
        characterList.filter(
          char => char.describe.contains(
            filterTrait.toLowerCase
          )
        )
      } else {
        characterList.filterNot(
          char => char.describe.contains(
            filterTrait.toLowerCase
          )
        )
      }
    filterList
  }

  //println(filter(characterList, april, "Lady").map(char => char.describe))

}







