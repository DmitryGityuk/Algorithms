package tasks.LeetCode.search;

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int good = 0;
        int bad = n;
        while (bad > good + 1) {
            int mid = good + ((bad - good) / 2);
            if (isBadVersion(mid)) {
                bad = mid;
            } else good = mid;
        }
        return bad;
    }
}
