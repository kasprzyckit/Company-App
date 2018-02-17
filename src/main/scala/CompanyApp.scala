import backend._

class CompanyApp

object CompanyApp {
  def main(args: Array[String]): Unit = {
    val db = new EmplyeeBuilder("John", "Smith")
    db.setCountry("Spain")
    db.setEmail("john@ham.com")
    db.setGender(Gender.M)
    db.setRole("PHP backend.Developer")
    db.setUniversity("AGH")
    val john = db.createDeveloper

    db setFirstName "Alf"
    db setLastName "Bruno"
    db.setCountry("Mehico")
    db.setEmail("alf@mex.com")
    db.setGender(Gender.M)
    db.setRole("HTML backend.Developer")
    db.setUniversity("UJ")
    val alf = db.createDeveloper

    db setFirstName "Bob"
    db setLastName "Casney"
    db.setCountry("US of A")
    db.setEmail("bb@gnail.com")
    db.setGender(Gender.M)
    db.setRole("Logo backend.Developer")
    db.setUniversity("Harvard")
    db.setHiringLimit(2)
    val bob = db createTeamMenager

    val ceo = new TeamManager("Albert", "Crus", "CEO","albert.crus@gmail.com", Gender.W, "California", "Univ", 20)
    val dan = new Developer("Daniel", "Wart", "C++ Dev", "dan@cpp.io", Gender.M, "Arizona", "C High")

    bob.hiringPredicate = HiringPredicate.create("univeristy", "UJ", false) || HiringPredicate.create("first", "john", false)

    bob hire john
    bob hire alf
    ceo hire dan
    ceo hire bob

    bob.assign(new Task("task1", 3))
    bob.assign(new Task("task2", 9))
    bob.assign(new Task("task3", 7))
    bob.assign(new Task("task4", 3))
    bob.assign(new Task("task5", 4))
    ceo.assign(new Task("task6", 1))
    ceo.assign(new Task("task7", 14))
    ceo.assign(new Task("task8", 5))
    ceo.assign(new Task("task9", 8))
    ceo.assign(new Task("task10", 87))
    ceo.assign(new Task("task11", 44))
    ceo.assign(new Task("task12", 0))

    for (task <- ceo.reportWork.tasks) println(task)

  }
}