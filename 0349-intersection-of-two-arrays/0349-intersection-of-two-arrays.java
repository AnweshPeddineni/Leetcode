class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Store unique elements of nums1 in a HashSet
        for (int num : nums1) {
            set1.add(num);
        }

        // Check nums2 elements in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // Store in resultSet to ensure uniqueness
            }
        }

        // ✅ Convert HashSet to int[] using a for-each loop
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}