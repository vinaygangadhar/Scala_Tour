package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */

//decorator class with a
//polymorphic method
class Decorator(left: String, right: String){

  //takes a functions and apllies to an integer
  //[A] -- takes any type
  def decorate[A](x: A) = left + x.toString() + right
}


object higher_order extends App{

  //higher-order function takes any func as input
  //returns a functiuon applied on value
  def apply(f: Int => String, v: Int) = f(v)

  val dec = new Decorator("{", "}")

  //decorate is automatically coerced into Type Int
  //becasue of apply's signature - f(v) where v is Int
  println(apply(dec.decorate, 7))   //returns decorate(7)

  higher_order.main(Array("run"))
}
