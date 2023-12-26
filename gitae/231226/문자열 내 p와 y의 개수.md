## 문제
[프로그래머스 LV.1 문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916)

## 결과 코드
```
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.toUpperCase(c) == 'P') {
                pCnt++;
            } else if (Character.toUpperCase(c) == 'Y') {
                yCnt++;
            }
        }
        
        if (pCnt != yCnt) {
            answer = false;
        }

        return answer;
    }
}
```
