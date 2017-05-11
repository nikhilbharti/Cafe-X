/**
  * Created by nikhilb on 11/05/17.
  */
import CafeXMenu._
import org.scalatest.{FlatSpec, Matchers}

class CafeXMenuSpec extends FlatSpec with Matchers {

  "calculateBill" should "calculate the total bill of all the items passed to it" in {
    calculateBill(List(Cola(), Coffee(), CheeseSandwich())) should be(3.5)
  }

  it should "return 0 for an empty list of items" in {
    calculateBill(List.empty) should be(0)
  }

  "calculateBillWithCharges" should "NOT apply a service charge when only drinks are purchased" in {
    calculateBillWithCharges(List(Cola(), Coffee())) should be (1.5)
  }

  "calculateBillWithCharges" should "apply a service charge of 10% when purchased item includes any FOOD" in {
    calculateBillWithCharges(List(Cola(), Coffee(),CheeseSandwich())) should be (3.85)
  }

  "calculateBillWithCharges" should "apply a service charge of 20% when purchased items includes any HOT FOOD" in {
    calculateBillWithCharges(List(Cola(), Coffee(),SteakSandwich())) should be (7.2)
  }

  "Calculated bill" should "round to 2 decimals" in {
    round2Decimal(2.866674) should be (2.87)
  }

  "calculateBillWithCharges" should "apply a service charge of 20% to the total bill with a maximum £20 service charge" +
    "when purchased items include any hot food" in {
    calculateBillWithCharges(List(SteakSandwich(120))) should be (140)
  }

}
