import org.scalatest.{FlatSpec, Matchers}

class CafeXSpec extends FlatSpec with Matchers {

  "CafeX.order" should "return 0 when nothing is ordered" in {
    CafeX.order(Seq()) shouldEqual 0
  }

  it should "return 0.50 if Cola is ordered" in {
    CafeX.order(Seq("Cola")) shouldEqual 0.50
  }

  it should "return 1.00 if Coffee is ordered" in {
    CafeX.order(Seq("Coffee")) shouldEqual 1.00
  }

  it should "return 2.20 if Cheese Sandwich is ordered" in {
    CafeX.order(Seq("Cheese Sandwich")) shouldEqual 2.20
  }

  it should "return 5.40 if Steak Sandwich is ordered" in {
    CafeX.order(Seq("Steak Sandwich")) shouldEqual 5.40
  }

  it should "not count nonexistent items" in {
    CafeX.order(Seq("Steak Sandwich", "Random")) shouldEqual 5.40
  }

  it should "add up many items correctly" in {
    CafeX.order(Seq("Steak Sandwich", "Cola")) shouldEqual 6.00
  }

  it should "not add more than £20 of service charge" in {
    CafeX.order(Seq(
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"
    )) shouldEqual 141.5
  }
}
