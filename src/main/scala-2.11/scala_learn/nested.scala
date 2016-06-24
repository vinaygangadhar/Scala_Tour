package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */
object nested {

  def filter(lx: List[Int], threshold: Int) = {
    def process(ly: List[Int]): List[Int] = {
      if(ly.isEmpty) ly
      else if (ly.head < threshold) ly.head :: process(ly.tail)
      else process(ly.tail)
    }

    process(lx)
  }

  def main(args: Array[String]) = {
    println(filter(List(1, 8, 7, 3, 4, 2), 4))
  }

}
