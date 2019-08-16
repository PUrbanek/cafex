sealed trait TemperatureCategory
case object Hot extends TemperatureCategory
case object Cold extends TemperatureCategory

sealed trait TypeCategory
case object Food extends TypeCategory
case object Drink extends TypeCategory

case class Item(name: String, price: Int, temperatureCategory: TemperatureCategory, typeCategory: TypeCategory)