import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PokerHandTest extends AnyWordSpec with Matchers {

  "Poker hand" should {
    "pick the highest card 7" in {
      PokerHand.evaluate("5M 4C 6S 7S 2D") should equal("high card : 7")
    }
    "pick the highest card 9" in {
      PokerHand.evaluate("5M 4C 6S 9S 2D") should equal("high card : 9")
    }
  }
}
