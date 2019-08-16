import org.scalatest.{FlatSpec, Matchers}

class HelloWorldSpec extends FlatSpec with Matchers {

  "HelloWorld.hello" should "be equal to \"Hello, World!\"" in {
    HelloWorld.hello shouldEqual "Hello, World!"
  }
}
