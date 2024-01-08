import java.util.Arrays;

class Solution {
    public long solution(final int n, final int[] times) {
        long answer = 0;
        
        //시간에 대해서 오름차순 정렬
        Arrays.sort(times);
        
        //심사에 있어서 필요한 최소 시간과 최대 시간을 구한다.
        long left = 0;
        long right = (long) times[0] * n; //최소로 걸리는 시간 (입국 심사 제일 빠르게 하는 심사관 기준) * n명
        
        //심사 최소 시간과 최대 시간을 이용하여 이분 탐색을 진행한다.
        //심사 걸리는 시간을 정해서 해당 값을 바꿔가면서, 해당 시간에 대해서 n명이 심사를 받을 수 있는지 확인한다.
        //n명을 심사할 수 있다면, 해당 시간을 저장하고, 최대 시간을 줄인다.
        //n명을 심사할 수 없다면, 최소 시간을 늘린다.
        while (left <= right) {
            final long curTime = left + (right - left) / 2;

            long completeCheckNum = 0;

            for (final int eachTime : times) {
                completeCheckNum += curTime / eachTime;
            }

            if (completeCheckNum >= n) {
                answer = curTime;
                right = curTime - 1;
            } else {
                left = curTime + 1;
            }
        }

        return answer;
    }
}
