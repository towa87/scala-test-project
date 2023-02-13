package codilityTask
import codilitytasks.ArrListLen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ArrListLenSpec extends AnyFlatSpec {
behavior of "Array tests"
  it should "find the closest value" in {
   val valueToTest =  ArrListLen.solutionWithList(Array(1, 4, -1, 3, 2))
    valueToTest  shouldBe 5
  }

  it should "find the closest value for another solution" in {
    val valueToTest = ArrListLen.solution(Array(1, 4, -1, 3, 2))
    valueToTest shouldBe 4
  }
}
