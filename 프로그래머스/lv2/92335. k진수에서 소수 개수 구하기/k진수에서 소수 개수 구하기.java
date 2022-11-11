class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = conversion(n, k);

        String[] nums = str.split("0");

        for(String s : nums) {
            if(s == null || s.length() == 0) {
                continue;
            }

            long num = Long.parseLong(s);
            if(num == 1) {
                continue;
            } else {
                if(isPrime(num) == 1)
                    answer++;
            }
        }
        return answer;
    }

    public static String conversion(int num, int k) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
            return "0";
        }

        while(num > 0) {
            if(num % k < 10) {
                sb.append(num % k);
            } else {
                sb.append((char)(num%k - 10 + 'A'));
            }
            num /= k;
        }
        return sb.reverse().toString();
    }

    public static int isPrime(long num) {
        for(long i = 2; i <= (long)Math.sqrt(num); i++) {
            if(num % i == 0)
                return 0;
        }
        return 1;
    }
}