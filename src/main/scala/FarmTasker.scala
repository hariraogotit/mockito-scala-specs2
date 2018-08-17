
/**
  * Created by Hari Rao on 17/08/18.
  */
class FarmTasker(animals: Seq[Animal]) {

  def taskForTheDay(maxAge: Int): Seq[FarmTask]  ={
    animals.flatMap {
      case animal @ Animal(_,age,Cow) if age < maxAge => Seq(FarmTask(animal,"milking",age))
      case animal @ Animal(_,age,Chicken) if age < maxAge =>  Seq(FarmTask(animal, "chicken for eggs", age))
      case animal @ Animal(_,age,Horse) if age < maxAge => Seq(FarmTask(animal, "plowing", age))
      case animal @ Animal(_,_,Wolf)  => throw new Exception("Wolves are attacking the farm!")
      case _ => Seq()
    }
  }

}
