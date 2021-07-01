package previousQuestion.kakao;

public class FirstRound2020FirstProblem {

    /**
     * 문제 링크
     * https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1
     *
     * 이해 안가는 부분
     * 예시 5번. 왜  x / ababcdcd / ababcdcd 로 자르는 것은 불가능한가?
     * => 이유는 없고 그냥 이 문제의 제약 조건임. 따지지 말고 푸셈.
     */
    public int solution(String s){
        int answer = s.length();

        /** i : 기준이 되는 문자 길이
         *  i <= s.length()/2 : 길이가 문자 길이의 절반이 넘으면 연속된 패턴이 있지 않기 때문에 절반만 반복하면 된다.
         */
        for(int i = 1; i <= s.length()/2; ++i ){
            int pos = 0; // 연산 수행 위치
            int len = s.length(); // 압축된 문자의 길이. 초기엔 전체 길이로 시작.

            for(  ; pos + i <= s.length()  ; ){
                String unit = s.substring(pos, pos + i);
                pos += i;

                // 기준이 되는 문자가 몇번 반복되는지 확인
                int cnt = 0;
                for( ; pos + i <= s.length(); ){
                    if(unit.equals(s.substring(pos, pos + i))){
                        ++cnt;
                        pos += i;
                    }else{
                        break;
                    }
                }

                if(cnt > 0){
                    len -= i * cnt;

                    if(cnt < 9 ) len += 1;
                    else if(cnt < 99 ) len += 2;
                    else if(cnt < 999 ) len += 3;
                    else len += 4;
                }

                answer = Math.min(answer, len);
            }
        }
        return answer;
    }




}
