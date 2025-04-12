package Examen

import org.apache.spark.sql.SparkSession
import org.scalatest.funsuite.AnyFunSuite
import org.apache.spark.rdd.RDD
import Pregunta4._

class Pregunta4Test extends AnyFunSuite {

  val spark: SparkSession = SparkSession.builder()
    .appName("Test Ejercicio4")
    .master("local[*]")
    .getOrCreate()



  test("Contar ocurrencias de palabras correctamente") {
    val palabras = List("Scala", "Spark", "scala", "RDD", "Spark", "spark", "RDD")
    val resultadoRDD: RDD[(String, Int)] = ejercicio4(palabras)(spark)

    val resultadoMap = resultadoRDD.collect().toMap

    assert(resultadoMap("scala") == 2)
    assert(resultadoMap("spark") == 3)
    assert(resultadoMap("rdd") == 2)
  }

}
