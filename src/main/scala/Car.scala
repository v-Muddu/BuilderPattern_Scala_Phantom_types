/**
  * Enum like class: Vehicle
  * @param options
  */
case class Vehicle(options: Seq[String])
/**
  * Class Name: Builder, which is type parametrized,
  * and has methods sets the values for all the variables
  * @param options
  * @tparam Car
  */
class Builder[Car <: Customer.Car](options: Seq[String]) {
  import Customer.Car._

  def withModel(modelType: String): Builder[Car with Model] = Customer(options :+ modelType)

  def withColor(colorType: String) : Builder[Car with Color] = Customer(options :+ colorType)

  def withAutoPilot: Builder[Car with AutoPilot] = Customer(options :+ "Autopilot")

  def withBatteryUnit(uniType : String) : Builder[Car with BatteryUnit] = Customer(options :+ uniType)

  def build(implicit ev: Car =:= GetCar): Vehicle = Vehicle(options)
}
