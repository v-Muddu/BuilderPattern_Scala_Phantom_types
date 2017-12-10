import BuilderPattern._
/**
  * Class Name: Main, this is the main class, and this is where the application starts
  */
object Main {
  /**
    * Main method, that sets the values of all the variables of the Vehicle object and
    * is said to be building the object
    * @param args
    */
  def main(args: Array[String]): Unit ={
    /**
      * this builder is example from the type safe builder pattern referenced from the link you've
      * posted on Piazza
      */
    var bookVehicle = builder withModel("TeslaS")withColor ("RED")withBatteryUnit (90)withAutoPilot (true) build()
    /**
      * prints out the all the set variables
      */
    println(bookVehicle)
    /**
      * this builder, is based on the phantom types uses pure type level programming,
      * prints out all the variables from this class
      */
    var x = new Builder[Customer.Car.GetCar](Nil).withModel("Tesla S").withColor("Red").withAutoPilot.withBatteryUnit("90D").build
    println(x)

  }
}