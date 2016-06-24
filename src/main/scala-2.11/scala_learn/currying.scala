package scala_learn

/**
  * Created by vinaygangadhar on 6/24/16.
  */
object currying {

  //comparison fn passed as an argument
  def filter(xs: List[Int], f: Int => Boolean): List[Int] = {
    if(xs.isEmpty) xs
    else if (f(xs.head)) xs.head :: filter(xs.tail, f)
    else filter(xs.tail, f)
  }

  //Function with different params list
  def modN(n: Int)(x: Int) : Boolean = ((x % n) == 0)

  def main(args: Array[String]) = {
    val list = List(1, 3, 4, 5, 6, 9, 8, 14, 16)

    println(filter(list, modN(2)))
    println(filter(list, modN(3)))
  }

}
