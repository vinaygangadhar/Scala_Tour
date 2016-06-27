package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */

class Polymorphism {

  //duplicating an object passed
  def dup[T](x: T, n: Int): List[T] = {
    if (n == 0)
      Nil
    else
      x :: dup(x, n-1)
  }
}


object PolymorphismTest{

  def main(args: Array[String]){

    val Dup = new Polymorphism

    println(Dup.dup[Int](3, 2))

    //methods type is aotomatically detected
    println(Dup.dup("check", 4))
  }
}