class GameTest {
    val rules:List<ruleType> = listOf(::birthRule, ::lonelyDeathRule, ::overPopulatedRule, ::stayAliveRule)

    @org.junit.jupiter.api.Test
    fun testGridBlinker() {
        val initialState = listOf(listOf(0, 0, 0), listOf(1, 1, 1), listOf(0, 0, 0))
        val expectedState = listOf(listOf(0, 1, 0), listOf(0, 1, 0), listOf(0, 1, 0))

        val game = Game(rules)
        val grid = Grid(3,3, initialState)
        val stateOneGrid = game.update(grid)
        assert(stateOneGrid.grid == expectedState)

        // Grid should the same as initial state after 2 updates
        val stateTwoGrid = game.update(stateOneGrid)
        assert(stateTwoGrid.grid == initialState)
    }

    @org.junit.jupiter.api.Test
    fun testGridTwoCubes() {
        val initialState = listOf(
            listOf(1, 1, 0, 0, 0),
            listOf(1, 1, 0, 0, 0),
            listOf(0, 0, 0, 1, 1),
            listOf(0, 0, 0, 1, 1))
        val game = Game(rules)
        val grid = Grid(4,5, initialState)

        val stateOne = listOf(
            listOf(1, 1, 0, 0, 0),
            listOf(1, 1, 1, 0, 0),
            listOf(0, 0, 1, 1, 1),
            listOf(0, 0, 0, 1, 1))
        val stateOneGrid = game.update(grid)
        assert(stateOneGrid.grid == stateOne)

        val stateTwo = listOf(
            listOf(1, 0, 1, 0, 0),
            listOf(1, 0, 0, 0, 0),
            listOf(0, 0, 0, 0, 1),
            listOf(0, 0, 1, 0, 1))
        val stateTwoGrid = game.update(stateOneGrid)
        assert(stateTwoGrid.grid == stateTwo)

        val stateThree = listOf(
            listOf(0, 1, 0, 0, 0),
            listOf(0, 1, 0, 0, 0),
            listOf(0, 0, 0, 1, 0),
            listOf(0, 0, 0, 1, 0))
        val stateThreeGrid = game.update(stateTwoGrid)
        assert(stateThreeGrid.grid == stateThree)

        val stateFour = listOf(
            listOf(0, 0, 0, 0, 0),
            listOf(0, 0, 1, 0, 0),
            listOf(0, 0, 1, 0, 0),
            listOf(0, 0, 0, 0, 0))
        val stateFourGrid = game.update(stateThreeGrid)
        assert(stateFourGrid.grid == stateFour)
    }

}