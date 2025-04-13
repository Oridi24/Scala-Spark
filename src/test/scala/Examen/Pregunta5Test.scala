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
      val ventas = Seq(
        ("v1", "p1", 2, 10.0),
        ("v2", "p2", 1, 20.0),
        ("v3", "p1", 3, 10.0)
      ).toDF("id_venta", "id_producto", "cantidad", "precio_unitario")

      val resultado = ejercicio5(ventas)(spark)

      val esperado = Map(
        "p1" -> (2 * 10.0 + 3 * 10.0),
        "p2" -> (1 * 20.0)
      )

      val resultadoMap = resultado
        .collect()
        .map(row => row.getAs[String]("id_producto") -> row.getAs[Double]("total_por_producto"))
        .toMap

      assert(resultadoMap("p1") == esperado("p1"))
      assert(resultadoMap("p2") == esperado("p2"))
    }

  }

