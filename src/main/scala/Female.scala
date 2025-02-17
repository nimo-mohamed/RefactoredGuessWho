package src.main.scala

class Female (name: String, hairColour: Character.HairColour, eyeColour: Character.EyeColour) extends Character (name, hairColour, eyeColour) {
  val describe: String = s"$name is a woman. She has ${hairColour.toString.toLowerCase} hair and ${eyeColour.toString.toLowerCase} eyes."
}
