class BirthRuleTest {
    @org.junit.jupiter.api.Test
    fun deadCellThreeNeighbors() {
        assert(birthRule(0,3) == true)
    }
    @org.junit.jupiter.api.Test
    fun deadCellTwoNeighbors() {
        assert(birthRule(0,2) == null)
    }
    @org.junit.jupiter.api.Test
    fun deadCellFourNeighbors() {
        assert(birthRule(0,4) == null)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellTwoNeighbors() {
        assert(birthRule(1,2) == null)
    }
}


class LonelyDeathRuleTest {
    @org.junit.jupiter.api.Test
    fun aliveCellOneAliveNeighbor() {
        assert(lonelyDeathRule(1, 1) == false)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellNoneAliveNeighbor() {
        assert(lonelyDeathRule(1, 0) == false)
    }
    @org.junit.jupiter.api.Test
    fun aliveCellTwoAliveNeighbor() {
        assert(lonelyDeathRule(1,2) == null)
    }

    @org.junit.jupiter.api.Test
    fun deadCellOneAliveNeighbor() {
        assert(lonelyDeathRule(0,1) == null)
    }
}

class StayAliveRuleTest {
    @org.junit.jupiter.api.Test
    fun aliveCellTwoAliveNeighbors() {
        assert(stayAliveRule(1,2) == true)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellThreeAliveNeighbors() {
        assert(stayAliveRule(1,3) == true)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellOneAliveNeighbors() {
        assert(stayAliveRule(1,1) == null)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellFourAliveNeighbors() {
        assert(stayAliveRule(1,4) == null)
    }

    @org.junit.jupiter.api.Test
    fun deadCellFourAliveNeighbors() {
        assert(stayAliveRule(0,2) == null)
    }

    @org.junit.jupiter.api.Test
    fun deadCellThreeAliveNeighbors() {
        assert(stayAliveRule(0,3) == null)
    }
}

class OverPopulatedRuleTest {
    @org.junit.jupiter.api.Test
    fun aliveCellFourNeighbors() {
        assert(overPopulatedRule(1,4) == false)
    }
    @org.junit.jupiter.api.Test
    fun aliveCellFiveNeighbors() {
        assert(overPopulatedRule(1,5) == false)
    }

    @org.junit.jupiter.api.Test
    fun deadCellFourNeighbors() {
        assert(overPopulatedRule(0,4) == null)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellThreeNeighbors() {
        assert(overPopulatedRule(1,3) == null)
    }

    @org.junit.jupiter.api.Test
    fun aliveCellTwoNeighbors() {
        assert(overPopulatedRule(1,2) == null)
    }
}