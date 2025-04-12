package Examen

import Examen.Pregunta5._
import org.apache.spark.sql.SparkSession
import org.scalatest.flatspec.AnyFlatSpec

class Pregunta5Test extends AnyFlatSpec{

  implicit val spark: SparkSession = SparkSession.builder()
    .appName("Ejercicio 5 - CSV")
    .master("local[*]")
    .getOrCreate()

  "ejercicio5" should "ingreso total (cantidad * precio_unitario) por producto" in {
    import spark.implicits._

  }
}
