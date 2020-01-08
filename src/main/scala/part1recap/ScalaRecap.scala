package part1recap

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ScalaRecap extends App {

  // Future
  import scala.concurrent.ExecutionContext.Implicits.global
  val aFuture = Future {
    // some expensive computation, runs on another thread
    42
  }

  aFuture.onComplete {
    case Success(meaningOfLife) => println(s"I've found $meaningOfLife")
    case Failure(ex) => println(s"I have failed: $ex")
  }

  // Partial Functions
//  val aPartialFunction = (x: Int) => x match {
//    case 1 => 43
//    case 8 => 56
//    case _ => 999
//  }
  // can instead be:
  val aPartialFunction: PartialFunction[Int, Int] = {
      case 1 => 43
      case 8 => 56
      case _ => 999
  }

  // Implicits
  // auto-injection by the compiler
  def methodWithImplicitArgument(implicit  x: Int) = x + 43
  implicit val implicitInt = 67

  val implicitCall = methodWithImplicitArgument

  // Implicit Conversions - implicit defs
  case class Person(name: String) {
    def greet = println(s"Hi, my name is $name")
  }

  implicit  def fromStringToPerson(name: String) = Person(name)
  "Bob".greet // fromStringToPerson("Bob").greet

  // implicit conversion - implicit classes
  implicit class Dog(name: String) {
    def bark = println("Bark")
  }
  "Lassie".bark
}
