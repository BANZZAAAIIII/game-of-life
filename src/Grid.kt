class Grid(val rows: Int, val cols: Int, initState: List<List<Int>> ?= null) {
    var grid: MutableList<MutableList<Int>> = (initState ?: MutableList(rows) { MutableList(cols) { 0 } }) as MutableList<MutableList<Int>>


    fun setCell(row: Int, col: Int, value: Int) {
        grid[row][col] = value
    }

    fun isBound(row: Int, col: Int): Boolean {
        return row in 0..<rows && col in 0..<cols
    }

    fun isAlive(row: Int, col: Int): Boolean {
        return if (isBound(row, col)) {
            grid[row][col] == 1
        } else {
            false
        }
    }

    fun aliveNeighbors(row: Int, col: Int): Int {
        val offsets = listOf(
            Pair(-1, -1),
            Pair(-1,  0),
            Pair(-1,  1),
            Pair( 0, -1),
            Pair( 0,  1),
            Pair( 1, -1),
            Pair( 1,  0),
            Pair( 1,  1)
        )

        return offsets.fold(0){ acc, (rowOffset, colOffset) ->
            if (isAlive(row + rowOffset, col + colOffset)) {
                acc + 1
            } else
                acc
        }
    }

    fun print() {
        grid.forEachIndexed {indexRow, row ->
            row.forEachIndexed { indexCol, _ ->
                val value = grid[indexRow][indexCol]
                print(" $value")
            }
            println()
        }
        println()
    }

    fun gen() = iterator {
        grid.forEachIndexed {indexRow, row ->
            row.forEachIndexed() { indexCol, _ ->
                yield(listOf(indexRow, indexCol, grid[indexRow][indexCol]))
            }
        }
    }
}