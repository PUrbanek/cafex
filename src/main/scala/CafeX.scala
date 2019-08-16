import scala.math.min

object CafeX {

  private final val items = Map(
    "Cola" -> Item("Cola", 50, Cold, Drink),
    "Coffee" -> Item("Coffee", 100, Hot, Drink),
    "Cheese Sandwich" -> Item("Cheese Sandwich", 200, Cold, Food),
    "Steak Sandwich" -> Item("Steak Sandwich", 450, Hot, Food)
  )
  private final val maximumServiceCharge = 2000

  def calculatePrice(itemsOrdered: Seq[String]): BigDecimal = {
    val itemsMapped = itemsOrdered.filter(singleItem => items.contains(singleItem))
        .map(singleItem => items(singleItem))
    val sum = itemsMapped.map(_.price).sum
    val serviceCharge = min(maximumServiceCharge, sum * determineServiceChargePercent(itemsMapped))
    BigDecimal((sum + serviceCharge)/100).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

  private def determineServiceChargePercent(itemsOrdered: Seq[Item]): Double = {
    if (itemsOrdered.filter(_.typeCategory == Food).exists(_.temperatureCategory == Hot)) 0.20
    else if (itemsOrdered.exists(_.typeCategory == Food)) 0.10
    else 0.00
  }
}
