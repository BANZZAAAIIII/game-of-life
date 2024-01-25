
typealias ruleType = (Int, Int) -> Boolean?


// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
fun birthRule(cell: Int, neighbors: Int): Boolean? {
    if (cell == 0 && neighbors == 3)
        return true
    return null
}

// Any live cell with fewer than two live neighbours dies, as if by underpopulation.
fun lonelyDeathRule(cell: Int, neighbors: Int): Boolean? {
    if (cell == 1 && neighbors < 2)
        return false
    return null
}

// Any live cell with two or three live neighbours lives on to the next generation.
fun stayAliveRule(cell: Int, neighbors: Int): Boolean? {
    if (cell == 1 && neighbors in 2..3)
        return true
    return null
}

// Any live cell with more than three live neighbours dies, as if by overpopulation.
fun overPopulatedRule(cell: Int, neighbors: Int): Boolean? {
    if (cell == 1 && neighbors > 3)
        return false
    return null
}