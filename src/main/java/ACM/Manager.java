package ACM;


import java.util.*;

class ManagerSolution {

    public int solution(List<Integer> nums) {
        Collections.sort(nums, (a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });
        int max = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0) {
                max += nums.get(0);
                continue;
            }
            int a = nums.get(i);
            if (a == 0) {
                break;
            }
            if (a == nums.get(i-1)) {
                max += a - 1;
                nums.set(i, a -1);
            }
        }
        return max;
    }
}
public class Manager {

    public static void main(String[] args) {
        Scanner sysIn = new Scanner(System.in);
        int size = sysIn.nextInt();
        sysIn.nextLine();

        String[] input = sysIn.nextLine().trim().split(" ");
        List<Integer> parsedInput = new ArrayList<>();
        for(String s : input) {
            parsedInput.add(Integer.parseInt(s));
        }
        ManagerSolution solution = new ManagerSolution();
        System.out.println(solution.solution(parsedInput));
        sysIn.close();
    }
}
