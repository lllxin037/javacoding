package leetcode.minimum.size.subarray.sum;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int left = 0;
		int right = 0;
		int minLen = nums.length + 1;

		int curSum = 0;

		while (right < nums.length) {

			curSum += nums[right];
			if (curSum >= s) {

				while (curSum - nums[left] >= s && left <= right) {
					curSum -= nums[left];
					left++;
				}

				minLen = Math.min(minLen, right - left + 1);
			}

			right++;
		}

		return (minLen == nums.length + 1) ? 0 : minLen;
	}
}
