class Solution {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
		int i = 0, j = 0;
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) {
					break;
				} else {
					int len = (axis + orbit) - (axis - orbit);
					if (max < len) {
						max = len;
						i = axis - orbit;
						j = axis + orbit;
					}
				}
			}
		}
		// EVEN
		int even = 0;
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt((int) (axis - orbit)) != s.charAt((int) (axis + orbit))) {
					break;
				} else {
					int len = (int) ((axis + orbit) - (axis - orbit));
					if (max < len) {
						max = len;
						i = (int) (axis - orbit);
						j = (int) (axis + orbit);
					}
				}
			}
		}
		return  s.substring(i, j+1);
	}
}