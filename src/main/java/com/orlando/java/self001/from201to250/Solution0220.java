package com.orlando.java.self001.from201to250;

import java.util.HashMap;
import java.util.Map;

/*
 * Contains Duplicate III
 *
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in
 * the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 */
public class Solution0220 {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0) return false;

    Map<Long, Long> buckets = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      //negative nums will cause edge cases of bucket targeting and bucket comparing, so reposition all nums, so that each num
      //is converted to be positive
      long normalizedNum = (long)nums[i] - Integer.MIN_VALUE;//nums[i] must be converted to long firstly, since
                                                             // nums[i] - Integer.MIN_VALUE may already overflow

      //choose bucket size to be t + 1, that's because:
      //bucket size == t: t = 0 would be an edge case, need to be processed separately
      //bucket size == t + 2: two nums with difference == t + 1 > t may fall into the same bucket, which will not be detected
      //bucket size == t - 1: instead of merely comparing bucket with bucket-1 and bucket+1, bucket-2 and bucket+2 also need to
      //                      be compared, cause nums with difference == t may fall into bucket-2 and bucket+2
      long bucketId = normalizedNum / ((long) t + 1);

      if (buckets.containsKey(bucketId)
        || (buckets.containsKey(bucketId - 1) && normalizedNum - buckets.get(bucketId - 1) <= t)
        || (buckets.containsKey(bucketId + 1) && buckets.get(bucketId + 1) - normalizedNum <= t)) {
        return true;
      }

      if (buckets.entrySet().size() >= k) {
        long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
        buckets.remove(lastBucket);
      }
      buckets.put(bucketId, normalizedNum);
    }
    return false;
  }
}
