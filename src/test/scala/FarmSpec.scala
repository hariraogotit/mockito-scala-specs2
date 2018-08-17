import org.specs2.mock._
import org.specs2.mutable.Specification

/**
  * Created by Hari Rao on 17/08/18.
  */
class FarmSpec extends Specification with Mockito {

  "Farm" should {
    val chicken = Animal("Bob", 12, Chicken)
    val cow = Animal("Bessy", 12, Cow)
    val horse = Animal("Douglas", 12, Horse)
    val dog = Animal("Cleo", 12, Dog)
    val cat = Animal("Santiago", 12, Cat)

    val tasker = mock[FarmTasker]

    val farm = new Farm("My Farm", tasker)

    "runs correctly for one day" in{
      val tasker = mock[FarmTasker]
      val farm = new Farm("My Farm", tasker)
      //method call is stubbed. anyInt says irrespective of the argument to the method taskForTheDay, return the Sequence
      //with three FarmTasks'
      tasker.taskForTheDay(anyInt) returns Seq(FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
          FarmTask(horse, "plowing", 12))

      farm.runForDays(13,1) must_== Seq(FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12))
// This checks that the taskForTheDay is called once and with the argument 13
      there was one(tasker).taskForTheDay(13)

    }

    "runs correctly for two days" in{
      val tasker = mock[FarmTasker]
      val farm = new Farm("My Farm", tasker)

      tasker.taskForTheDay(anyInt) returns Seq(FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12))

      farm.runForDays(13, 2) must_== Seq(FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12),
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12))

      // This checks that the taskForTheDay is called twice and with the argument 13
      there was 2.times(tasker).taskForTheDay(13)
    }
  }

}
