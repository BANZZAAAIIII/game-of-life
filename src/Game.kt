

class Game(val rules: List<ruleType>) {
    fun update(grid: Grid): Grid {
        val newGrid = Grid(grid.rows, grid.cols)
        for ((row, col, value) in grid.gen()) {
            //println("Row: $row, col: $col, value: $value")
            val aliveNeighbors = grid.aliveNeighbors(row, col)
            val next = applyRules(value, aliveNeighbors)
            newGrid.setCell(row, col, next)
        }

        return newGrid
    }

    private fun applyRules(cell: Int, aliveNeighbors: Int): Int {
        rules.forEach {rule ->
            val result = rule(cell, aliveNeighbors)
            if (result == true)
                return 1
            if (result == false)
                return 0
        }
        return cell
    }
}

