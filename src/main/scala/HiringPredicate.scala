class HiringPredicate (private val predicate: Employee => Boolean){

  def &&(other: HiringPredicate):HiringPredicate = new HiringPredicate(emp => this (emp) && other (emp))

  def ||(other: HiringPredicate):HiringPredicate = new HiringPredicate(emp => this (emp) || other (emp))

  def unary_! : HiringPredicate = new HiringPredicate(emp => ! this(emp))

}

object HiringPredicate {
  implicit def predToFunc(hiringPredicate: HiringPredicate): Employee => Boolean = hiringPredicate.predicate
  //implicit def funcToPred(predicate: Employee => Boolean): HiringPredicate = new HiringPredicate(predicate)

  def create(field: String, value: String, neg: Boolean):HiringPredicate = { val p: Employee => Boolean = field match {
    case "first" => _.firstName.equalsIgnoreCase(value)
    case "last" => _.lastName.equalsIgnoreCase(value)
    case "role" => _.role.contains(value)
    case "email" =>   _.email.toString.equalsIgnoreCase(value)
    case "email_login" => _.email.login.equalsIgnoreCase(value)
    case "email_domain" => _.email.domain.equalsIgnoreCase(value)
    case "gender" => _.gender.toString.equalsIgnoreCase(value)
    case "country" => _.country.equalsIgnoreCase(value)
    case "university" => _.university.contains(value)
    case _ => _ => true
    }
    if (neg) ! new HiringPredicate(p) else new HiringPredicate(p)
  }
}