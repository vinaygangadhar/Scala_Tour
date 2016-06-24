package scala_learn

import sun.font.TrueTypeFont

/**
  * Created by vinaygangadhar on 6/24/16.
  */

//case classes export constructors
//heavily can be used for pattern matching
//has equality and toString methods by default


abstract class pattern
case class Var(name: String) extends pattern
case class Func(arg: String, body: pattern) extends pattern
case class App(p1: pattern, p2: pattern) extends pattern


object pattern_match {

  //print function for pattern matching
  //inbuilt tostring method

  //pattern matching to decompose data structures
  def printPattern(p: pattern): Unit = {
    p match{
      case Var(x) =>
        print(x)
      case Func(x, body) =>
        print("^" + x + ".")
        printPattern(body)
      case App(b1, b2) =>
        print("(")
        printPattern(b1)
        print(" ")
        printPattern(b2)
        print(")")
    }
  }

  ////correpond to a idenctity function
  def isIdentityFunc(f: pattern): Boolean = f match{
    case Func(x, Var(y)) if (x == y) => true
    case _ => false
  }

  def main(args: Array[String]): Unit ={

    val id = Func("x", Var("x"))
    val pt = Func("x", Func("y", App(Var("x"), Var("y"))))

    printPattern(pt)
    println

    println(isIdentityFunc(id))
    println(isIdentityFunc(pt))

  }

}