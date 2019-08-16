object CafeX {

  val items = Map(
    "Cola" -> 0.50,
    "Coffee" -> 1.00,
    "Cheese Sandwich" -> 2.00,
    "Steak Sandwich" -> 4.50
  )

  def order(itemsOrdered: Seq[String]): Double = {
    itemsOrdered.filter(item => items.contains(item)).map(items(_)).sum
  }
}
