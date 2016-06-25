/**
  * Created by t-vigan on 6/24/2016.
  */
//This is to explain the working of case
//class constructors using generic type parameters
//and variance annotation

//allows only objects with subtype of T
abstract class AbList[+T]

//a case class for linked list
case class MyList[T](h: T, list: AbList[T]) extends AbList[T]

//Can also instantiate MyList directly with Nil
case object Null extends AbList[Nothing]

object case_class_list {
  def main(args: Array[String]): Unit ={
    val ll: MyList[Int] = MyList(2, MyList(3, MyList(8, Null)))
    val ls: MyList[String] = MyList("one", MyList("three", MyList("eight", Null)))

    println(ll)
    println(ls)
  }
}

