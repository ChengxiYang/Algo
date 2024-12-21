public class NextNumber {

    public int solution(int n) {
        int a = n;
        int[] nums = new int[6];
        int k = nums.length - 1;
        while (a != 0) {
            nums[k] = a % 10;
            a /= 10;
            --k;
        }
        int front = nums[0] + nums[1] + nums[2];
        int back = nums[3] + nums[4] + nums[5];

        do {
            int tmp = nums[3] * 100 + nums[4] * 10 + nums[5] + 1;
            nums[5] = tmp % 10;
            tmp = tmp / 10;
            nums[4] = tmp % 10;
            tmp = tmp / 10;
            nums[3] = tmp % 10;
            back = nums[3] + nums[4] + nums[5];
        } while ((back != front));

        return nums[5] + nums[4] * 10 + nums[3] * 100 + nums[2] * 1000 + nums[1] * 10000 + nums[0] * 100000;
    }
}
