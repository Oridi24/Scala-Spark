package Examen

import Examen.Pregunta1._
import org.apache.spark.sql.catalyst.dsl.expressions.{DslAttr, StringToAttributeConversionHelper}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class Pregunta1Test extends AnyFlatSpec with Matchers{

  val spark: SparkSession = SparkSession.builder()
    .appName("Test DataFrame Estudiantes")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._


  def crearDataFrameEstudiantes(): DataFrame = {
    val estudiantes = Seq(
      ("Juan", 20, 8.5),
      ("Lucía", 22, 9.2),
      ("Carlos", 19, 7.8),
      ("María", 21, 8.9)
    )

    estudiantes.toDF("nombre", "edad", "calificacion")
  }
  "ejercicio1" should "tener las columnas correctas" in{
    val df = crearDataFrameEstudiantes()

    val columnasEsperadas = Seq("nombre", "edad", "calificacion")
    df.columns should contain theSameElementsAs columnasEsperadas
  }



    schema("nombre").dataType.typeName shouldbe("string")
    schema("edad").dataType.typeName shouldbe("integer")
    schema("calificacion").dataType.typeName shouldbe("double")
  }

  "ejercicio1" should "permitir hacer filtros correctamente" in{
    val df = crearDataFrameEstudiantes()
    val mayores = df.filter($"edad" >= 21)

    mayores.count() shouldbe(2)
  }
}
