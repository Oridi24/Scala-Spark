package Examen


import Examen.Pregunta2._
import org.apache.spark.sql.{Row, SparkSession}
import org.scalatest.flatspec.AnyFlatSpec


class Pregunta2Test extends AnyFlatSpec {

  val spark: SparkSession = SparkSession.builder()
    .appName("Test UDF Par o Impar")
    .master("local[*]")
    .getOrCreate()


  "ejercicio2" should  "clasificar correctamente números pares e impares" in {
    import spark.implicits._

    val numerosDF = Seq(1, 2, 3, 4).toDF("numero")
    val resultadoDF = ejercicio2(numerosDF)(spark)
    val resultado = resultadoDF.select("numero", "par").collect()


    assert(resultado.contains(Row(1, "Impar")))
    assert(resultado.contains(Row(2, "Par")))
    assert(resultado.contains(Row(3, "Impar")))
    assert(resultado.contains(Row(4, "Par")))
  }
}

