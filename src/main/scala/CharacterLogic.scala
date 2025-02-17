package src.main.scala

object CharacterLogic extends  App {
  val al = new Male("Al", Character.Pink, Character.Blue)
  println(al.name, al.eyeColour, al.hairColour)
  println(al.describe)
}
