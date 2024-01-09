/*
정수 삼각형
     7
    3 8
   8 1 0

해당 삼각형을 이렇게 바꿔서 생각한다.
   7
   3 8
   8 1 0
 */

class Solution {
    public int solution(final int[][] triangle) {
        //삼각형의 높이를 구한다.
        final int length = triangle.length;
        //최대값을 구하기 위한 변수 (최대값을 구하는 문제이므로 최소값으로 초기화한다.)
        int maxValue = Integer.MIN_VALUE;

        //dp 배열을 선언한다.
        final int[][] dp = new int[length][length];
        //dp 배열의 초기값을 설정한다. (맨 꼭대기)
        dp[0][0] = triangle[0][0];

        //위에서 아래로 최대값을 구한다.
        //dp 배열을 채워나간다. (맨 꼭대기는 위에서 선언함, 2번째 라인부터 계산한다.)
        for (int row = 1; row < dp.length; row++) {
            //맨 왼쪽 값은 위에서 내려오는 값이 없으므로 그냥 더한다.
            dp[row][0] = dp[row - 1][0] + triangle[row][0];

            //col이 1인 값부터 계산 (col이 0인 값은 위에서 계산했으므로)
            for (int col = 1; col < row + 1; col++) {
                //현재 값
                final int curValue = triangle[row][col];

                final int prevRowValue = dp[row - 1][col]; //바로 위 row 값
                final int diagonalPrevRowValue = dp[row - 1][col - 1]; //왼쪽 대각선 위 row 값

                //위에서 내려오는 값이 2개이므로 둘 중 최대값을 더한다.
                dp[row][col] = Math.max(prevRowValue, diagonalPrevRowValue) + curValue;

                //더해지는 값이 0이상 이므로, 모든 값을 다 비교해보면 무조건 최대값이 나온다.
                maxValue = Math.max(maxValue, dp[row][col]);
            }
        }

        return maxValue;
    }
}
