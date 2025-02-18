package Char

import CharacterLogic.{al, characterList, farnoosh, lan, sheila}


object CharacterFilterLogic extends App {
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

  println(filter(characterList, sheila, "Lady").map(char => char.describe))
  //  def filterByGender(characterList: List[Character], gender: String): List[Character] = {
  //    characterList.filter(character => character.gender == gender)
  //
  //  }
  //
  //  def filterByHairColour(characterList: List[Character], hairColour: Character.HairColour): List[Character] = {
  //    characterList.filter(character => character.hairColour == hairColour)
  //  }
  //
  //  def filterByEyeColour(characterList: List[Character], eyeColour: Character.EyeColour): List[Character] = {
  //    characterList.filter(character => character.eyeColour == eyeColour)
  //  }

  //  def filterCharacterByTrait(characterList: List[Character],gender: String, hairColour: Character.HairColour,eyeColour: Character.EyeColour ): List[Character] = for {
  //    char <- characterList
  //    if char.gender == gender
  //    if char.hairColour == hairColour
  //    if char.eyeColour == eyeColour
  //  }yield char


}







// def filterCharacters(listCharacters, trait): List[Characters] = {
//  val listCharacters: List[Characters] = // List("al', "lan")  sent from Eloise's logic
//  val  filteredCharacters: List[Characters] = listCharacters.filter {

//}
//}