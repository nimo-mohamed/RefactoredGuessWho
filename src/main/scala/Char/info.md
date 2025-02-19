``` scala
package Week2.friday

import Week2.friday.GuessWho.{Green, Pink}

case class GuessWho(name: String, , hairColour: GuessWho.HairColour, eyeColour: GuessWho.EyeColour ) {
}


object GuessWhoLogic extends App {
  //al nameList: List[String] = List("Al", "Betty", "Bob")

  val al = GuessWho("Al", moustache = true, Pink, Green )

  // val chosenCharacter = nameList(math.random(0 to nameList.length-1))
  println(al)

}

// Top abstract class of Character
// subclasses of Male -
// Female - default FacialHair.Moustache = false

//
// sealed traits
// Glasses - Boolean
// Hat - Boolean
// Earrings Boolean

// Nested questions
// - What feature would you like to ask about -
// - Gender (male/female)
// - Haircolour (black/blonde/pink)
// - EyeColour
// - moustache
// - Earrings?
// - Glasses
// - Hat




object GuessWho {
sealed trait HairColour
case object Blonde extends HairColour
case object Black extends HairColour
case object Pink extends HairColour

sealed trait EyeColour
case object Brown extends EyeColour
case object Hazel extends EyeColour
case object Blue extends EyeColour
case object Green extends EyeColour

sealed trait FacialHair {
val beard: Boolean
val moustache: Boolean // override val moustache = parameter???
}
} 



  
}

  def filterCharacters(listCharacters, trait): List[Characters] = {
  val listCharacters: List[Characters] = // List("al', "lan")  sent from Eloise's logic
  val  filteredCharacters: List[Characters] = listCharacters.filter {
  

    }

```

