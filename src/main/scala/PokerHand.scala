object PokerHand {
  val figuresIndex: Map[Char, Int] = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
    .zipWithIndex
    .toMap

  case class Card(figure: Char, power: Int)

  object Card {
    def parse(input: String): Card = input.toList match {
      case List(figure, _) => Card(figure, figuresIndex(figure))
    }
  }

  case class CardOccurrence(occurrence: Int, cardPower: Int, figure: Char)

  object CardOccurrence {
    val create: ((Char, Array[Card])) => CardOccurrence = {
      case (figure, cards) => CardOccurrence(cards.size, cards.head.power, figure)
    }
  }

  implicit val cardOccurrenceOrdering: Ordering[CardOccurrence] =
    Ordering.by[CardOccurrence, (Int, Int)](co => (co.occurrence, co.cardPower)).reverse

  def evaluate(hand: String): String = {
    val cardOccurrences: List[CardOccurrence] = hand
      .split(" ")
      .map(Card.parse)
      .groupBy(_.figure)
      .map(CardOccurrence.create)
      .toList
      .sorted

    val maxCardOccurrence = cardOccurrences.head
    val secondMaxCardOccurrence = cardOccurrences(1)
    if (maxCardOccurrence.occurrence == 2) {
      if (secondMaxCardOccurrence.occurrence == 2) {
        "two pairs of : " + maxCardOccurrence.figure + "," + secondMaxCardOccurrence.figure
      } else {
        "pair of : " + maxCardOccurrence.figure
      }
    } else {
      "high card : " + maxCardOccurrence.figure
    }
  }
}
