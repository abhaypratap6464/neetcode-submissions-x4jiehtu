class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var count = 0

        val directions = arrayOf(
            intArrayOf(1,0),
            intArrayOf(-1,0),
            intArrayOf(0,1),
            intArrayOf(0,-1),
        )

        fun bfs(startR:Int,startC:Int){
            val queue = ArrayDeque<Pair<Int,Int>>()
            queue.add(Pair(startR,startC))
            grid[startR][startC] = '0'
            
            while(queue.isNotEmpty()){
                val (r,c) = queue.removeFirst()

                for(dir in directions){
                    val nr = r + dir[0]
                    val nc = c + dir[1]

                    if(nr < 0 || nr >= rows) continue
                    if(nc < 0 || nc >= cols) continue

                    if(grid[nr][nc] != '1') continue

                    grid[nr][nc] = '0'

                    queue.add(Pair(nr,nc))
                }
            }
        }

        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c] == '1'){
                    count++
                    bfs(r,c)
                }
            }
        }

        return count
    }
}