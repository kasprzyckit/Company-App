package data.domain

import data.domain.Gender.Gender

class Developer(firstName: String,
                lastName: String,
                role: String,
                email: Email,
                gender: Gender,
                country: String,
                university: String,
                supervisor: Manager,
                company: Company)
  extends AbstractEmployee(firstName, lastName, role, email, gender, country, university, supervisor, company) {

  private var tasks_ : List[Task] = List()

  def tasks: List[Task] = tasks_

  override def reportWork: Report = new Report(tasks)

  override def assign(task: Task): Unit = {tasks_ = task.setEmployee(this) :: tasks_}
}