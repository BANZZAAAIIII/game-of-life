fun main() {
    var grid = Grid(rows = 4, cols = 5, listOf(
        listOf(1, 1, 0, 0, 0),
        listOf(1, 1, 0, 0, 0),
        listOf(0, 0, 0, 1, 1),
        listOf(0, 0, 0, 1, 1)))

    val rules:List<ruleType> = listOf(::birthRule, ::lonelyDeathRule, ::overPopulatedRule, ::stayAliveRule)
    val game = Game(rules)

    for (generation in 1..6) {
        grid.print()
        grid = game.update(grid)
    }
}