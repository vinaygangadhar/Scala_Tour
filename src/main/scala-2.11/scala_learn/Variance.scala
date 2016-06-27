package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */

//Covariant subtype implementaion of stack
//Immutable stack implementation

class Stack_new[+T] {

  //+T allows T to be used in co-variant poisitions only
  //so define push method using lower bounds
  //co-variant subtyping of stacks
  def push[B >: T](elem: B): Stack_new[B] = new Stack_new[B]{

    override def top: B = elem
    override def pop: Stack_new[B] = Stack_new.this

    override def toString = elem.toString + " " + Stack_new.this.toString

  }

  def top: T = sys.error("no element on stack")
  def pop: Stack_new[T] = sys.error("no element on stack")

  override def toString = ""
}



//Testing stack
object Variance {
  def main(args: Array[String]) = {

    //T as a lowerbound of push's type varibale
    var s: Stack_new[Any] = new Stack_new().push("Stack")
    println(s)
    s = s.push(7)

    println(s)
  }
}