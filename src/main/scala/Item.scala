sealed trait Category

sealed trait TemperatureCategory extends Category
case object Hot extends TemperatureCategory
case object Cold extends TemperatureCategory

sealed trait TypeCategory extends Category
case object Food extends TypeCategory
case object Drink extends TypeCategory

case class Item(name: String, price: Double, categories: Seq[Category])