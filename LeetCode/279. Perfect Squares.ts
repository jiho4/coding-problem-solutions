/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/submissions/864008975/
 * solved: 2022-12-22
 */
function numSquares(n: number): number {
    let sqaureArr: number[] = []

    // put perfect squares into set
    for (let i = 1; i*i <= n; i++) {
        sqaureArr.push(i*i)
    }

    return bfs(n, sqaureArr)
};

function bfs(n: number, squareArr: number[]): number {
    if (n < 2) {
        return n
    }

    let depth = 0
    let toVisitList: number[] = [n]
    let visited = new Set<number>()

    while (toVisitList.length > 0) {
        let nextLevel: number[] = []

        depth++
        // console.log("### depth is: " + depth)

        for (let num of toVisitList) {
            // console.log("num is: " + num)
            for (let sq of squareArr) {
                // console.log(num - sq)

                if (num == sq) {
                    return depth
                } else if (num < sq) {
                    break
                } else if (visited.has(num - sq)) {
                    continue
                } else {
                    visited.add(num - sq)
                    nextLevel.push(num - sq)
                }
            }
        }

        toVisitList = nextLevel
    }

    return depth
}
