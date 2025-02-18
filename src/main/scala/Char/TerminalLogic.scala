package Char


import CharacterLogic.{al, characterList, farnoosh, lan, april}

import scala.io.StdIn.readInt

object TerminalLogic {


  def terminalLogic = {
    do {
      print("What would you like to ask about? \n")
      print("1. Gender? \n")
      print("2. Hair colour? \n")
      print("3. Eye colour? \n")
      val subjectChoice: Int = readInt()
      println(subject(subjectChoice))
      val questionChoice: Int = readInt()
      println(questions(questionChoice))
      val secondQuestionChoice: Int = readInt()
      println()
    } while (characterList.length < 1)

  }
  def subject(subjectNum: Int): String =
      if (subjectNum == 1) {
        "Choose question Number \n 1. Is your person a Male? \n 2. Is you person a Female?"
      } else if (subjectNum == 2) {
        s"1. Does the person have Pink hair? \n 2. Does the person have Black hair? \n 3. Does the person have Blonde hair?"
      } else if (subjectNum == 3) {
        val eyes: String = "eyes"
        s"1. Does the person have Blue eyes? \n 2. Does the person have Brown eyes? \n 3. Does the person have Hazel eyes?  \n 4. Does the person have Blonde hair?"
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
  terminalLogic
}
