/**
  * Created by nikhilb on 11/05/17.
  */
sealed trait Item {
  val price: Double
}

case class Cola(price: Double = 0.5) extends Item
case class Coffee(price: Double = 1) extends Item
case class CheeseSandwich(price: Double = 2) extends Item
case class SteakSandwich(price: Double = 4.5) extends Item


object CafeXMenu {

  def calculateBill(items: Seq[Item]): Double = items.foldLeft(0.0)(_ + _.price)

}