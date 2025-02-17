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
}
