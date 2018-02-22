package data.domain

import data.domain.HiringPredicate.{ATOMIC, EVERY, Quantifier, Struct}

class HiringPredicate (val predicates: List[Employee => Boolean],
                       private val quantifier: Quantifier,
                       private val structure: Struct){

  def this (predicate: Employee => Boolean) = this(List(predicate), EVERY(), ATOMIC())

  def &&(other: HiringPredicate):HiringPredicate = new HiringPredicate(emp => this (emp) && other (emp))

  def ||(other: HiringPredicate):HiringPredicate = new HiringPredicate(emp => this (emp) || other (emp))

  def unary_! : HiringPredicate = new HiringPredicate(emp => ! this(emp))

}

object HiringPredicate {
  implicit def predToFunc(hiringPredicate: HiringPredicate): Employee => Boolean = hiringPredicate.structure match {
    case ATOMIC() => hiringPredicate.predicates.head
    case COMPOSITE() => hiringPredicate.quantifier match {
      case ANY() => hiringPredicate.predicates.reduce((pr1, pr2) => (emp) => pr1(emp) || pr2(emp))
      case EVERY() => hiringPredicate.predicates.reduce((pr1, pr2) => (emp) => pr1(emp) && pr2(emp))
      case NOT_ANY() => hiringPredicate.predicates.reduce((pr1, pr2) => (emp) => ! (pr1(emp) || pr2(emp)))
      case NOT_EVERY() => hiringPredicate.predicates.reduce((pr1, pr2) => (emp) => ! (pr1(emp) && pr2(emp)))
    }
  }

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

  abstract class Quantifier
  case class ANY() extends Quantifier
  case class EVERY() extends Quantifier
  case class NOT_ANY() extends Quantifier
  case class NOT_EVERY() extends Quantifier

  abstract class Struct
  case class ATOMIC() extends Struct
  case class COMPOSITE() extends Struct
}