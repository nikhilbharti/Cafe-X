/**
  * Created by nikhilb on 11/05/17.
  */
sealed trait Item {
  val price: Double
}

sealed trait Drinks extends Item
sealed trait Food extends Item
sealed trait HotFood extends Item

case class Cola(price: Double = 0.5) extends Drinks
case class Coffee(price: Double = 1) extends Drinks
case class CheeseSandwich(price: Double = 2) extends Food
case class SteakSandwich(price: Double = 4.5) extends HotFood



object CafeXMenu {

 val FOOD_SERVICE_CHARGE = 0.1 // 10%
 val HOT_FOOD_SERVICE_CHARGE = 0.2 // 20%
  val MAX_SERVICE_CHARGE = 20

  def calculateBill(items: Seq[Item]): Double = items.foldLeft(0.0)(_ + _.price)

  def calculateBillWithCharges(items: Seq[Item]): Double = {
    val purchaseOnlyDrinks = items.forall(x => x.isInstanceOf[Drinks])
    val purchaseContainFood = items.exists(x => x.isInstanceOf[Food])
    val purchaseContainHotFood = items.exists(x => x.isInstanceOf[HotFood])

    (purchaseOnlyDrinks,purchaseContainFood,purchaseContainHotFood) match {
      case (true,_ ,_)  => calculateBill(items)
      case (_,true,_) => round2Decimal(calculateBill(items) + (calculateBill(items)* FOOD_SERVICE_CHARGE))
      case (_,_,true) => if(calculateBill(items)* HOT_FOOD_SERVICE_CHARGE < 20)
        round2Decimal(calculateBill(items) + (calculateBill(items)* HOT_FOOD_SERVICE_CHARGE))
        else
        round2Decimal(calculateBill(items) + MAX_SERVICE_CHARGE)
      case (_,_,_) => 0.0
    }
  }

  def round2Decimal(value : Double) = {
    BigDecimal(value).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

}