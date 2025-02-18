package Char

import CharacterLogic.{al, farnoosh, lan, sheila}


object CharacterFilterLogic extends App {
  val characterList: List[Character] = List(al, sheila, lan, farnoosh)
  println(characterList)
  def filter(characterList: List[Character], chosenCharacter: Character, filterTrait: String): List[Character] = {
    val filterList: List[Character] = characterList.filter(
      char => char.describe.contains(
        filterTrait.toLowerCase
      )
    )
    filterList
  }

  println(filter(characterList, sheila, "pink"))
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