package Char

import CharacterLogic.{al, farnoosh, lan, april}


object CharacterFilterLogic extends App {
  val characterList: List[Character] = List(al, april, lan, farnoosh)
  println(characterList)
  def filter(characterList: List[Character], chosenCharacter: Character, filterTrait: String): List[Character] = {
    val filterList: List[Character] = characterList.filter(
      char => char.describe.contains(
        filterTrait.toLowerCase
      )
    )
    filterList
  }

  println(filter(characterList, april, "pink"))



}







