package Examen

import Pregunta3._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.flatspec.AnyFlatSpec



class Pregunta3Test extends AnyFlatSpec  {


  "ejercicio3" should "calcular correctamente el promedio de calificación por estudiante" in {

    val estudiantesDF = crearEstudiantesDF()
    val calificacionesDF = crearCalificacionesDF()
    val resultadoDF = ejercicio3(estudiantesDF, calificacionesDF)

    resultadoDF.schema.fieldNames should contain allOf("nombre", "promedio-calificacion")

    val resultado = resultadoDF.collect()

    resultado should contain theSameElementsAs Array(
      Row("Ana", 8.5),
      Row("Juan", 7.0),
      Row("Carla", 9.5)
    )
  }
}

