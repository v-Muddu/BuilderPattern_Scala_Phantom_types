/**
  * Class Name: Customer
  */
object Customer {
  sealed trait Car
  /**
    * Object Name: car, all the necessary variables are declared in this class
    */
  object Car {
    sealed trait Model extends Car
    sealed trait Color extends Car
    sealed trait AutoPilot extends Car
    sealed trait BatteryUnit extends Car

    type GetCar = Model with Color with AutoPilot with BatteryUnit
  }

  def apply[T <: Car](options: Seq[String]): Builder[T] = new Builder[T](options)

  def apply(): Builder[Car.GetCar] = apply[Car.GetCar](Seq())
}
