package leetcode;

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/submissions/862897669/
 * solved: 2022-12-20
 */
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = hashSetOf<Int>()
        val toVisit = hashSetOf<Int>()

        visitRoom(0, rooms, visited, toVisit)

        return visited.size == rooms.size
    }

    private fun visitRoom(visit: Int, rooms: List<List<Int>>,
                          visited: HashSet<Int>, toVisit: HashSet<Int>) {
        // println("visiting: $visit")
        visited.add(visit)

        for (key in rooms[visit]) {
            if (!visited.contains(key) && !toVisit.contains(key)) {
                toVisit.add(key)
            }
        }

        if (toVisit.isNotEmpty()) {
            val nextRoom = toVisit.first().also{ toVisit.remove(it) }
            visitRoom(nextRoom, rooms, visited, toVisit)
        }
    }
}
