data class Ingredient(val name: String, var price: Int = 0, val vegetarian: Boolean)

fun main(args: Array<String>) {

  val kebabPlateBase: List<Ingredient> = listOf(
    Ingredient("pain", 1, true),
    Ingredient("salade", 1, true),
    Ingredient("tomates", 2, true),
    Ingredient("oignons", 1, true)
  )

  val kebabPlateCmd1: List<Ingredient> = kebabPlateBase.plus(
    listOf(
      Ingredient("veau", 4, false),
      Ingredient("riz", 1, true),
      Ingredient("frites", 2, true)
    )
  )

  // reduction sur les frites et sur le veau (50%)
  val price = kebabPlateCmd1.map {
    var newPrice = if (it.name == "frites" || it.name == "veau") {
      it.price / 2
    } else {
      it.price
    }

    Ingredient(it.name, newPrice, it.vegetarian)
  }.sumBy { it.price }

  val isVegetarian = kebabPlateCmd1.all {
    it.vegetarian
  }

  println(kebabPlateCmd1)
  println(price)
  println(isVegetarian)


}