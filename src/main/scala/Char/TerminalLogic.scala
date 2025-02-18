package Char


import CharacterLogic.{al, april, boardX, boardY, characterList, chosenChar, farnoosh, lan, printBoard, printStartBoard}

import scala.io.StdIn.readInt

object TerminalLogic extends App {

  //val chosenCharacter = CharacterLogic.chosenChar

  def terminalLogic = {
    printStartBoard(boardX, boardY)
    println("\n")
    println(characterList.map((char: Char.Character) => char.describe).mkString("\n"))
    println("\n")
    var newFilteredList: List[Character] = runGame(characterList)
    while (newFilteredList.length > 1) {
      val oldFilteredList: List[Character] = newFilteredList
      newFilteredList = runGame(oldFilteredList)
    }
    println(s"Congratulations! $chosenChar was my chosen character. You win!")
  }

  def subject(subjectNum: Int): String =
    if (subjectNum == 1) {
      println("Choose question Number \n 1. Is your person a Male? \n 2. Is you person a Female?")
      val choice: Int = readInt()
      if (choice == 1) {
        "man"
      } else if (choice == 2) {
        "lady"
      } else {
        "invalid"
      }
    } else if (subjectNum == 2) {
      println("Choose question Number \n 1. Does the person have Pink hair? \n 2. Does the person have Black hair? \n 3. Does the person have Blonde hair?")
      val choice: Int = readInt()
      if (choice == 1) {
        "pink"
      } else if (choice == 2) {
        "black"
      } else if (choice == 3) {
        "blonde"
      } else {
        "invalid"
      }
    } else if (subjectNum == 3) {
      val eyes: String = "eyes"
      println("Choose question Number \n 1. Does the person have Blue eyes? \n 2. Does the person have Brown eyes? \n 3. Does the person have Hazel eyes?  \n 4. Does the person have Green eyes?")
      val choice: Int = readInt()
      if (choice == 1) {
        "blue"
      } else if (choice == 2) {
        "brown"
      } else if (choice == 3) {
        "hazel"
      } else if (choice == 4) {
        "green"
      } else {
        "invalid"
      }
    } else {
      "invalid"
    }

  def questions(choice: Int): String = {
    val hairColours: List[Character.HairColour] = List(Character.Blonde, Character.Black, Character.Pink)
    val genders: List[String] = List("man", "lady")
    val genderChoiceQuestions: List[String] = for (genderQuestions <- genders) yield s"Is Your person a $genders?"
    val colourQuestions: List[String] = for (hairColourQuestions <- hairColours) yield s"Does your person have $hairColours "
    val traitType: String = if (choice == 2) {
      "hair"
    } else if (choice == 3) {
      "eyes"
    } else {
      "invalid"
    }
    if (choice == 1) {
      s"$genderChoiceQuestions"
    } else if (choice == 2) {
      s"$colourQuestions"
    } else {
      s"$colourQuestions"
    }

  }

  def runGame(listToFilter: List[Character]): List[Character] = {
    print("What would you like to ask about? \n")
    print("1. Gender? \n")
    print("2. Hair colour? \n")
    print("3. Eye colour? \n")
    //print("4. Choose final character \n") add methodology later
    val subjectChoice: Int = readInt()
    val chosenTrait: String = subject(subjectChoice)
    val filterList: List[Character] = CharacterFilterLogic.filter(listToFilter, chosenChar, chosenTrait)
    println("\n")
    printBoard(boardX, boardY, characterList, filterList)
    println("\n")
    println(filterList.map((char: Char.Character) => char.describe).mkString("\n"))
    println("\n")
    filterList
  }

  terminalLogic
}
