package dataModel

class UnitsOfWork (val units: Int){

  override def toString: String = units.toString
}

object UnitsOfWork{

  implicit def intToUOW (n:Int): UnitsOfWork = new UnitsOfWork(n)
}