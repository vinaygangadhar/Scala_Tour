package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */
object Unified_types extends App{
  val set = new scala.collection.mutable.LinkedHashSet[Any]

  set += "Test"
  set += 732
  set += 'c'
  set += main _

  val iter: Iterator[Any] = set.iterator

  while(iter.hasNext){
    println(iter.next.toString())
  }

  Unified_types.main(args)
}


