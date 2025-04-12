package Examen

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 *Ejercicio 5: Procesamiento de archivos
 *Pregunta: Carga un archivo CSV que contenga información sobre
 *ventas (id_venta, id_producto, cantidad, precio_unitario)
 *y calcula el ingreso total (cantidad * precio_unitario) por producto.
 */

object Pregunta5 {
  def ejercicio5(ventas: DataFrame)(spark:SparkSession): DataFrame = {
       ventas
         .withColumn("ingreso_total", col("cantidad") * col("precio_unitario"))
         .groupBy("id_producto")
         .agg(sum("ingreso_total").alias("total_por_producto"))

  }
}
