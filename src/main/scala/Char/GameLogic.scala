package Char

object GameLogic {
  def questions(subject: Int): String = {
    val input: Int = ???

    val subject: Int = ???
    // What would you like to ask about?
    // 1. Gender
    //  A) Is the person a male
    //  B) Is the person a female
    // 2. HairColour
    //  A) Does the person have Pink Hair etc

    // 3. EyeColour

    //  B) Does the person have Blue eyes ...
    // 4. Guess the Character // list out names and number of characters left in the game
    if (subject == 1) {
      println("Select the number of the question you want to ask \n 1. Is the person a male? \n 2. Is the person a female?")//change for terminal
      val gender = genderQuestion(1)
      if (gender == "male" || gender == "female") {
        s"Is the person a $gender?"
      } else {
        s"Invalid choice"
      }
      gender
    } else if (subject == 2) {
      val hair = "hair"
      s"Does the person have $hair hair"
    } else if (subject == 3) {
      val eyes: String = "eyes"
      s"Does the person have $eyes eyes"
    } else {
    "EHH EHH Invalid question"
    }
  }

  def genderQuestion(genderChoice: Int): String = {
    if (genderChoice == 1) {
      "male"
    } else if (genderChoice == 1) {
      "female"
    } else {
      "Invalid"
    }

  }

  println(questions(1))

}

/**
 * 0 0 0 x 0
 * 0 x 0 0 0
 * 0 0 0 0 x
 */