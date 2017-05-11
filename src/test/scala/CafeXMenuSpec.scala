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
}
