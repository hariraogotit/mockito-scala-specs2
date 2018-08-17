/**
  * Created by Hari Rao on 17/08/18.
  */
class Farm(name: String, tasker: FarmTasker) {
  def runForDays(maxAge:Int, days: Int) : Seq[FarmTask] ={
    for{
      day <- 1 to days
      task <- tasker.taskForTheDay(maxAge)
    }yield{
      task
    }
  }

}
