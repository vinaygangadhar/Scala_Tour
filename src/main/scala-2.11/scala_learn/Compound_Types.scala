package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */

//Compound types -- interesction of object types
trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {

    //ojects super class clone method
    super.clone().asInstanceOf[Cloneable]
  }
}


//second trait
trait Resetable {
  def reset: Unit
}

object Compound_Types {

  // A new object wihich is of both traits
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable ={
    val cloneObj = obj.clone()
    obj.reset
    cloneObj
  }

  def main(args: Array[String]): Unit ={
  }
}
