class Solution {
    public long largestPerimeter(int[] a) {
        int n = a.length;
        long ans = -1;
        Arrays.sort(a);
        long s = 0L;
        for (int e : a) {
            s += (long) e;
        }
        long cur = s;
        for (int i = n - 1; i > 1; i--) {
            cur -= (long) a[i];
            if (cur > a[i]) {
                ans = cur + a[i];
                break;
            }
        }
        return ans;
    }
}