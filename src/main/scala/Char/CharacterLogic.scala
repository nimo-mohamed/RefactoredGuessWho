package Char

import scala.util.Random

object CharacterLogic {
  val al = new Male("Al", Char.Character.Pink, Char.Character.Blue)
  val april: Female = new Female("April", Char.Character.Black, Char.Character.Brown)
  val lan = new Female("Lan", Char.Character.Pink, Char.Character.Green)
  val farnoosh = new Female("Farnoosh", Char.Character.Pink, Char.Character.Blue)
  val eloise = new Female("Eloise", Char.Character.Black, Char.Character.Green)
  val nimo = new Female("Nimo", Char.Character.Blonde, Char.Character.Hazel)
  val dorothea = new Female("Dorothea", Char.Character.Blonde, Char.Character.Blue)
  val sandra = new Female("Sandra", Char.Character.Pink, Char.Character.Hazel)
  val ash = new Male("Ash", Char.Character.Pink, Char.Character.Hazel)
  val tudor = new Male("Tudor", Char.Character.Blonde, Char.Character.Hazel)
  val waris = new Male("Waris", Char.Character.Black, Char.Character.Blue)
  val andy = new Male("Andy", Char.Character.Black, Char.Character.Green)
  val characterList: List[Char.Character] = List(al, april, lan, farnoosh, eloise, nimo,dorothea, sandra, ash, tudor, waris, andy)

  val randomnum: Int = Random.between(0, characterList.length - 1)
  //println(randomnum)
  val chosenChar: Char.Character = characterList(randomnum)
  //println(chosenChar.name)

  //sorting out how our logic works

  val hairList: List[Char.Character.HairColour] = List(Char.Character.Black, Char.Character.Blonde, Char.Character.Pink)
  val eyeList: List[Char.Character.EyeColour] = List(Char.Character.Brown, Char.Character.Hazel, Char.Character.Blue, Char.Character.Green)

  //lists of features to use when creating random characters

  def createRandomMale(name: String): Char.Character = {
    val hair: Char.Character.HairColour = hairList(Random.between(0, hairList.length))
    val eye: Char.Character.EyeColour = eyeList(Random.between(0, eyeList.length))
    new Male(name, hair, eye)
  }

  def createRandomFemale(name: String): Char.Character = {
    val hair: Char.Character.HairColour = hairList(Random.between(0, hairList.length - 1))
    val eye: Char.Character.EyeColour = eyeList(Random.between(0, eyeList.length - 1))
    new Female(name, hair, eye)
  }

  //methods to create random characters for males and females

  val maleNames: List[String] = List("Al", "Andy", "Waris", "Aashvin", "Tudor", "Ash", "Joe", "Lucian", "Kevin", "Brian")
  val femaleNames: List[String] = List("Lan", "Farnoosh", "Eloise", "Nimo", "Sandra", "Dorothea", "April", "Gemma","Lucy", "Emily")

  //list of male and female names for the characters to have

  val boardX: Int = 4
  val boardY: Int = 3

  //choose the board size here (make sure the x*y <= how many names we have in each list)

//  def createCharList(numOfChars: Int): List[Char.Character] = (for {
//    num: Int <- 1 to numOfChars
//    genderNum: Int = Random.between(1, 3)
//    newChar: Char.Character = {
//      if (genderNum == 1) {
//        createRandomMale(maleNames(num - 1))
//      } else {
//        createRandomFemale(femaleNames(num - 1))
//      }
//    }
//  } yield newChar).toList

  //method to create a list (length n) of characters with randomised features

//  val fullCharList: List[Char.Character] = createCharList(boardX*boardY)

  //value of list of random characters which will fill our board

//  val chosenCharacter: Char.Character = fullCharList(Random.between(0, fullCharList.length))

  //this is the character the computer has picked to play as

  def startBoardAsRow(x: Int, y: Int):List[String] = (for {
    num: Int <- 1 to x*y
  } yield "\u001b[34m-O-\u001b[0m").mkString.grouped(12*x).toList

  def printStartBoard(x: Int, y: Int): Unit = for {
    numY: Int <- 0 until y
  } println(startBoardAsRow(x, y)(numY))

  //methods so that we can print the start board (size x by y) where all characters are "flipped up"

//  printStartBoard(5, 4) //prints example of this

//  val filteredCharList: List[Char.Character] = fullCharList.filter(char => char.hairColour == Char.Character.Pink)

//  println(fullCharList.map(char => char.describe))

  //an example list of filtered characters and their descriptions

  def boardAsRow(x: Int, y: Int, fullList: List[Char.Character], filteredList: List[Char.Character]): List[String] = (for {
    num: Int <- 0 to x*y-1
    piece: String = if (filteredList.contains(fullList(num))) {
      "\u001b[34m-O-\u001b[0m"
    } else {
      "\u001b[31m-X-\u001b[0m"
    }
  } yield piece).mkString.grouped(12*x).toList

  def printBoard(x: Int, y: Int, fullList: List[Char.Character], filteredList: List[Char.Character]): Unit = for {
    numY: Int <- 0 to y-1
  } println(boardAsRow(x, y, fullList, filteredList)(numY))

//  printBoard(boardX, boardY, fullCharList, filteredCharList)

  // methods to compare the full list of characters, with the remaining possibilities for the computer's character. It then prints what the board will look like after this go.

//  println(filteredCharList.map((char: Char.Character) => char.describe).mkString("\n"))

  // prints a description of each of the remaining characters
}
