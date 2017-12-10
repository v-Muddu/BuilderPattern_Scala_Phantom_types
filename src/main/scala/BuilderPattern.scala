object BuilderPattern {
  /**
    * Class Name: Builder Pattern, static type
    */
  abstract class TRUE
  abstract class FALSE
  /**
    * Class Name: Vehicle builder,
    * this is the builder that sets and gets the object variables
    * @param model
    * @param color
    * @param batteryUnit
    * @param autoPilot
    * @tparam HM
    * @tparam HC
    * @tparam HB
    */
  class VehicleBuilder[HM, HC, HB]( val model:Option[String], val color:Option[String], val batteryUnit:Option[Int], val autoPilot:Option[Boolean]){
    def withModel(m:String) = new VehicleBuilder[TRUE, HC, HB](Some(m), color, batteryUnit, autoPilot)
    def withColor(c:String) = new VehicleBuilder[HM, TRUE, HB](model, Some(c), batteryUnit, autoPilot)
    def withBatteryUnit(b:Int) = new VehicleBuilder[HM, HC, TRUE](model, color, Some(b), autoPilot)
    def withAutoPilot(a:Boolean) = new VehicleBuilder[HM, HC, HB](model, color, batteryUnit, Some(a))
  }

  /**
    * An implicit method that sets the constructor for the builder pattern and
    * teh inner build method creates a new instance of the Vehicle object
    * @param builder
    * @return
    */
  implicit  def enableBuild(builder: VehicleBuilder[TRUE, TRUE, TRUE]) = new {
    def build() = {
      new Vehicle_C(builder.model.get, builder.color.get, builder.batteryUnit.get, builder.autoPilot.get)
    }
  }
  /**
    * builder, that builds the vehicle builder object
    * @return
    */
  def builder = new VehicleBuilder[FALSE, FALSE, FALSE](None, None, None, None)
}
