package src.main.scala

import scala.util.Random

object CharacterLogic extends  App {
  val al = new Male("Al", Character.Pink, Character.Blue)
  println(al.name, al.eyeColour, al.hairColour)
  println(al.describe)
  val sheila: Female = new Female("Sheila", Character.Black, Character.Brown)
  println(sheila.describe)
  val lan = new Female("Lan", Character.Pink, Character.Green)
  val farnoosh = new Female("Farnoosh", Character.Pink, Character.Blue)
  val characterList: List[Character] = List(al, sheila, lan, farnoosh)

  val randomnum: Int = Random.between(0, characterList.length - 1)
  println(randomnum)
  val randomChar: Character = characterList(randomnum)
  println(randomChar.name)

  //sorting out how our logic works

  val hairList: List[Character.HairColour] = List(Character.Black, Character.Blonde, Character.Pink)
  val eyeList: List[Character.EyeColour] = List(Character.Brown, Character.Hazel, Character.Blue, Character.Green)

  //lists of features to use when creating random characters

  def createRandomMale(name: String): Character = {
    val hair: Character.HairColour = hairList(Random.between(0, hairList.length))
    val eye: Character.EyeColour = eyeList(Random.between(0, eyeList.length))
    new Male(name, hair, eye)
  }

  def createRandomFemale(name: String): Character = {
    val hair: Character.HairColour = hairList(Random.between(0, hairList.length - 1))
    val eye: Character.EyeColour = eyeList(Random.between(0, eyeList.length - 1))
    new Female(name, hair, eye)
  }

  //methods to create random characters for males and females

  val maleNames: List[String] = List("Al", "Andy", "Waris", "Aashvin", "Tudor", "Ash", "Joe", "Lucian", "Kevin", "Brian")
  val femaleNames: List[String] = List("Lan", "Farnoosh", "Eloise", "Nimo", "Sandra", "Dorothea", "April", "Gemma","Lucy", "Emily")

  //list of male and female names for the characters to have

  val boardX: Int = 3
  val boardY: Int = 3

  //choose the board size here (make sure the x*y <= how many names we have in each list)

  def createCharList(numOfChars: Int): List[Character] = (for {
    num: Int <- 1 to numOfChars
    genderNum: Int = Random.between(1, 3)
    newChar: Character = {
      if (genderNum == 1) {
        createRandomMale(maleNames(num - 1))
      } else {
        createRandomFemale(femaleNames(num - 1))
      }
    }
  } yield newChar).toList

  //method to create a list (length n) of characters with randomised features

  val fullCharList: List[Character] = createCharList(boardX*boardY)

  //value of list of random characters which will fill our board

  val chosenChar: Character = fullCharList(Random.between(0, fullCharList.length))

  //this is the character the computer has picked to play as

  def startBoardAsRow(x: Int, y: Int):List[String] = (for {
    num: Int <- 1 to x*y
  } yield "-O-").mkString.grouped(3*x).toList

  def printStartBoard(x: Int, y: Int): Unit = for {
    numY: Int <- 0 until y
  } println(startBoardAsRow(x, y)(numY))

  //methods so that we can print the start board (size x by y) where all characters are "flipped up"

  printStartBoard(5, 4) //prints example of this

  val filteredCharList: List[Character] = fullCharList.filter(char => char.hairColour == Character.Pink)

  println(fullCharList.map(char => char.describe))

  //an example list of filtered characters and their descriptions

  def boardAsRow(x: Int, y: Int, fullList: List[Character], filteredList: List[Character]): List[String] = (for {
    num: Int <- 0 to x*y-1
    piece: String = if (filteredList.contains(fullList(num))) {
      "-O-"
    } else {
      "-X-"
    }
  } yield piece).mkString.grouped(3*x).toList

  def printBoard(x: Int, y: Int, fullList: List[Character], filteredList: List[Character]): Unit = for {
    numY: Int <- 0 to y-1
  } println(boardAsRow(x, y, fullList, filteredList)(numY))

  printBoard(boardX, boardY, fullCharList, filteredCharList)

  // methods to compare the full list of characters, with the remaining possibilities for the computer's character. It then prints what the board will look like after this go.

  println(filteredCharList.map((char: Character) => char.describe).mkString("\n"))

  // prints a description of each of the remaining characters
}
