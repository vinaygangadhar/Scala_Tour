package scala_learn

/**
  * Created by t-vigan on 6/24/2016.
  */

//can be a trait also
abstract class Similar{
  def isSimilar(x: Any): Boolean
}

//exports the constructor
//overrides methods and uses pattern matching
//given an object checks its value
case class MyInt(x: Int) extends Similar{
  def isSimilar(m: Any): Boolean = {
    m.isInstanceOf[MyInt] &&
    m.asInstanceOf[MyInt].x == x
    //the object exports its constructor
  }
}

//test
object UpperBound {
  //a new method to find similar type
  //mention an upper bound that the
  //in-object should be a sub-type of Similar object
  def findSimilar[T <: MyInt](s: T, xs: List[T]): Boolean ={
    if(xs.isEmpty) false
    else if (s.isSimilar(xs.head)) true
    else findSimilar(s, xs.tail)
  }

  //main method
  def main(args: Array[String]): Unit = {
    val list: List[MyInt] = List(MyInt(4), MyInt(6), MyInt(8))

    println(MyInt(2))
    println(findSimilar[MyInt](MyInt(2), list))
    println(findSimilar[MyInt](MyInt(6), list))
  }
}
