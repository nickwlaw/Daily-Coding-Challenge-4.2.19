import java.util.Arrays;

public class DCPApp {

	public static void main(String[] args) {

		int[] nums = { 10, 15, 3, 7 };
		int k = 1;

		boolean test = test3(nums, k);

		System.out.println(Arrays.toString(nums));
		System.out.println(k);
		System.out.println(test);

	}

	// test the condition with nested for loops
	static boolean test1(int[] nums, int k) {
		for (int i : nums) {
			for (int j : nums) {
				if (i + j == k)
					return true;
			}
		}
		return false;

	}

	// test the condition in one pass by testing incrementing and decrementing
	// indexes
	static boolean test2(int[] nums, int k) {
		Arrays.sort(nums);
		int i1 = 0;
		int i2 = nums.length - 1;
		while (true) {
			if (i1 == i2)
				return false;
			if (nums[i1] + nums[i2] == k)
				return true;
			if (nums[i1] + nums[i2] < k)
				i1++;
			if (nums[i1] + nums[i2] > k)
				i2--;
		}
	}

	// test the condition in one pass using a binary search
	static boolean test3(int[] nums, int k) {
		Arrays.sort(nums);
		for (int i : nums) {
			int j = Arrays.binarySearch(nums, k - i);
			if (j >= 0) {
				if (i + nums[j] == k)
					return true;
			}
		}
		return false;
	}

}

/*
 * Given a list of numbers and a number k, return whether any two numbers from
 * the list add up to k.
 * 
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is
 * 17.
 * 
 * Bonus: Can you do this in one pass?
 * 
 */
