package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */

import ComplexImplicits._

//Implicit conversion of double to complex
//and tuple to complex
object ComplexImplicits {

  //implicit conversion from a double to complex
  implicit def Double2Complex(value: Double) =
    new Complex(value, 0.0)

  //tuple of doubles to Complex
  implicit def Tuple2Complex(value: Tuple2[Double, Double]): Complex =
    new Complex(value._1, value._2)
}


//complex numbers example with
//operator overloading
class Complex(val real: Double, val imag: Double){

  //+ operator
  //def +(c: Complex): Complex = new Complex(this.real + c.real, this.imag + c.imag)
  //implicit conversion
  //returns a tuple and then converst to complex
  def +(c: Complex): Complex = (this.real + c.real, this.imag + c.imag)

  //- operator for complex
  //def -(c: Complex): Complex = new Complex(this.real - c.real, this.imag - c.real)
  def -(c: Complex): Complex = (this.real - c.real, this.imag - c.real)

  //unary operator
  def unary_~ = Math.sqrt(real * real + imag * imag)

  //toString method
  override def toString = real  + " + " + imag + "i"
}

object Implicit_Conv {

  def main(args: Array[String]): Unit = {

    val a = new Complex(4, 5)
    val b = new Complex(2, 3)

    println(a)
    println(a + b)    //returns a new compelx object

    //Creata a tuple -- and use it as paramter for
    //implicit conversion
    val a1: Complex = (4.0, 3.0)
    val b1: Complex = (3.0, 4.0)

    //Implicit conversion of int to double
    val d: Complex = 3 + a1
    println(d)

    val e: Complex = (1.2, 5.2) + b1
    println(e)
  }
}
