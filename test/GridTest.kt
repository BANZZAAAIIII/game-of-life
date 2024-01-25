class GridTest {
    val grid = Grid(3, 3)

    @org.junit.jupiter.api.Test
    fun initialization() {
        assert(grid.grid.size == 3)
        assert(grid.grid[0].size == 3)
    }

    @org.junit.jupiter.api.Test
    fun setCell() {
        grid.setCell(1,1,1)

        assert(grid.grid[1][1] == 1)
    }

    @org.junit.jupiter.api.Test
    fun inBound() {
        assert(grid.isBound(0,0))
        assert(grid.isBound(1,1))
        assert(grid.isBound(2,2))

        assert(!grid.isBound(-1,0))
        assert(!grid.isBound(3,0))
        assert(!grid.isBound(0,3))
        assert(!grid.isBound(3,3))
    }

    @org.junit.jupiter.api.Test
    fun isAlive() {
        grid.grid[1][1] = 1
        assert(grid.isAlive(1, 1))
        grid.grid[0][0] = 1
        assert(grid.isAlive(0, 0))

        assert(!grid.isAlive(2, 2))

        assert(!grid.isAlive(3, 3))
    }

    @org.junit.jupiter.api.Test
    fun aliveNeighbors() {
        grid.grid[0][1] = 1
        grid.grid[1][0] = 1
        grid.grid[1][2] = 1
        assert(grid.aliveNeighbors(1,1) == 3)
        assert(grid.aliveNeighbors(0,0) == 2)

        assert(grid.aliveNeighbors(2,2) != 10)
    }
}