package Char


import CharacterLogic.{al, april, boardX, boardY, characterList, chosenChar, farnoosh, lan, printBoard, printStartBoard}

import scala.io.StdIn.{readInt, readLine}

object TerminalLogic extends App {

  //val chosenCharacter = CharacterLogic.chosenChar

  def terminalLogic = {
    println("\u001b[31m .d8888b.                                     \nd88P  Y88b                                    \n888    888                                    \n888        888  888  .d88b.  .d8888b  .d8888b \n888  88888 888  888 d8P  Y8b 88K      88K     \n888    888 888  888 88888888 \"Y8888b. \"Y8888b.\nY88b  d88P Y88b 888 Y8b.          X88      X88\n \"Y8888P88  \"Y88888  \"Y8888   88888P'  88888P'\n                                              \n                                              \n                                              \n888       888 888              .d8888b.       \n888   o   888 888             d88P  Y88b      \n888  d8b  888 888                  .d88P      \n888 d888b 888 88888b.   .d88b.   .d88P\"       \n888d88888b888 888 \"88b d88\"\"88b  888\"         \n88888P Y88888 888  888 888  888  888          \n8888P   Y8888 888  888 Y88..88P               \n888P     Y888 888  888  \"Y88P\"   888          \u001b[0m\n")
    printStartBoard(boardX, boardY)
    println("\n")
    println(characterList.map((char: Char.Character) => char.describe).mkString("\n"))
    println("\n")
    var newFilteredList: List[Character] = runGame(characterList)
    while (newFilteredList.length > 1) {
      val oldFilteredList: List[Character] = newFilteredList
      newFilteredList = runGame(oldFilteredList)
    }
    println(s"\u001b[32mCongratulations! ${chosenChar.name} was my chosen character. You win!\u001b[0m")
    println("\u001b[35m                                   .''.       \n       .''.      .        *''*    :_\\/_:     . \n      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\n  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\n :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\n : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\n  '..'  ':::'     * /\\ *     .'/.\\'.   '\n      *            *..*         :\n        *\n        *\u001b[0m")
  }

  def subject(subjectNum: Int, listToFilter: List[Character]): String =
    if (subjectNum == 1) {
      println("Choose question Number \n 1. Is your person a Male? \n 2. Is you person a Female?")
      val choice: Int = readInt()
      if (choice == 1) {
        "male"
      } else if (choice == 2) {
        "female"
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
      val choice: Int = readLine().toInt
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
    } else if (subjectNum == 4) {
      val charToNum = listToFilter.zipWithIndex.map { case (person, index) => ( index + 1 ) + " " + person.name   }
      val charToMap: Map[Int, String] = listToFilter.zipWithIndex.map { case (person, index) => (index + 1) -> person.name }.toMap
      printCharList(charToNum)
      val choice: Int = readLine().toInt
      val name: String = charToMap(choice)
        s"$name"
    } else {
      "invalid"
    }

  def printCharList(charList: List[String]): Unit = {
    for (person <- charList) yield println(person)

  }

  def runGame(listToFilter: List[Character]): List[Character] = {
    print("What would you like to ask about? \n")
    print("1. Gender? \n")
    print("2. Hair colour? \n")
    print("3. Eye colour? \n")
    print("4. Choose final character \n") //add methodology later
    val subjectChoice: Int = readLine().toInt
    if (subjectChoice > 0 && subjectChoice < 5) {
      val chosenTrait: String = subject(subjectChoice, listToFilter)
      val filterList: List[Character] = CharacterFilterLogic.filter(listToFilter, chosenChar, chosenTrait, subjectChoice)
      val numOfFlipped: Int = listToFilter.length - filterList.length
      print("\n")
      printBoard(boardX, boardY, characterList, filterList)
      print("\n")
      println(s"$numOfFlipped characters eliminated!!")
      print("\n")
      println(filterList.map((char: Char.Character) => char.describe).mkString("\n"))
      print("\n")
      filterList
    } else {
      runGame(listToFilter)
    }

  }


  def filterMessage(subjectNum: Int, chosenTrait: String, correct: Boolean): Unit = {
    val subject: String = {
      if (subjectNum == 1) {
        "gender"
      }  else if (subjectNum == 2) {
        "hair"
      } else if (subjectNum == 3) {
        "eyes"
      } else if (subjectNum == 4) {
        "name"
      } else {
        "invalid"
      }
    }
    if (correct) {
      println(s"That's right!! My chosen character has $chosenTrait $subject")
    } else {
      println(s"Sorry!! My chosen character does not have $chosenTrait $subject")
    }
  }

  def chooseChar(choice: Character, chosenCharacter: Character): Boolean =
    if (choice == chosenCharacter) true else false

  terminalLogic
}
