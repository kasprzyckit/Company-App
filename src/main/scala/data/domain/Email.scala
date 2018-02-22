package data.domain

@throws(classOf[IllegalArgumentException])
class Email (email:String)
{
  private var login_ : String = _
  private var domain_ : String = _

    email match {
      case "" =>
    case Email(log, dom) => login_ = log; domain_ = dom;
    case _ => throw new IllegalArgumentException
  }

  def login: String = login_
  def domain: String = domain_

  override def toString: String = email
}

object Email {
  def apply(login: String, domain: String): Email = new Email(login + domain)
  def apply(email: String): Email = new Email(email)

  def unapply(arg: String): Option[(String, String)] = {
    val emailRegex = "([a-zA-Z][a-zA-Z0-9]*)@([a-z0-9]+.[a-z]+)".r
    val matches = emailRegex.findAllIn(arg).matchData.next()
    if (matches.groupCount == 2) Some(matches.group(1), matches.group(2)) else None
  }

  implicit def stringToEmail(s: String): Email = new Email(s)
}