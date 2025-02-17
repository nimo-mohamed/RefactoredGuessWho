package src.main.scala

class Male (name: String, hairColour: Character.HairColour, eyeColour: Character.EyeColour) extends Character (name, hairColour, eyeColour) {
  def describe: String = s"$name is a man. He has ${hairColour.toString.toLowerCase} hair and ${eyeColour.toString.toLowerCase} eyes."
}
