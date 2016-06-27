package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  *
  *
  */


//Helps for lazy evlaution of the
//funcion params or expressions
object Pass_byName {

  //returns 4
  def demo = {println("Demo Func"); 4}

  def eager(x: Int) = {println("Eager"); x}

  //pass-by-name (pass the value x only when evaluating)
  def lazyeval(x: => Int) = {println("Lazy"); x}

  def main(args: Array[String]): Unit = {
    eager(demo + 2)

    lazyeval(demo + 2)
  }
}
