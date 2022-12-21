/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/submissions/863394922/
 * solved: 2022-12-21
 */
var solution = function(isBadVersion: any) {

    return function(n: number): number {
        var validVer: number = 0
        var badVer: number = n

        while (validVer < badVer) {
            // check median
            var midVer = Math.floor((badVer - validVer)/2 + validVer) // for overflow safety

            if (isBadVersion(midVer)) {
                badVer = midVer
            } else {
                validVer = midVer + 1
            }
        }

        return validVer
    };
};

/**
 * (constraints)
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */
