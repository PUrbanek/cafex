object CafeX {

  private val items = Map(
    "Cola" -> Item("Cola", BigDecimal(0.50), Seq(Drink, Cold)),
    "Coffee" -> Item("Coffee", BigDecimal(1.00), Seq(Drink, Hot)),
    "Cheese Sandwich" -> Item("Cheese Sandwich", BigDecimal(2.0), Seq(Food, Cold)),
    "Steak Sandwich" -> Item("Steak Sandwich", BigDecimal(4.50), Seq(Food, Hot))
  )

  def calculatePrice(itemsOrdered: Seq[String]): BigDecimal = {
    val itemsMapped = itemsOrdered.filter(singleItem => items.contains(singleItem))
        .map(singleItem => items(singleItem))
    val sum = itemsMapped.map(_.price).sum
    val serviceCharge = calculateServiceCharge(sum, determineServiceChargePercent(itemsMapped))
    sum + serviceCharge
  }

  private def determineServiceChargePercent(itemsOrdered: Seq[Item]): BigDecimal = {
    if (itemsOrdered.filter(_.categories.contains(Food)).exists(_.categories.contains(Hot))) 0.20
    else if (itemsOrdered.exists(_.categories.contains(Food))) 0.10
    else 0.00
  }

  private def calculateServiceCharge(sum: BigDecimal, serviceChargePercent: BigDecimal): BigDecimal = {
    (sum * serviceChargePercent).setScale(2, BigDecimal.RoundingMode.HALF_UP) match {
      case sc if sc > 20.00 => 20.00
      case sc => sc
    }
  }
}
