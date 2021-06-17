package kr.co.hanjin.webservice.web.dto;

import org.junit.Test;


/*
* assertj 장점
* CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음
* 자동완성이 확실하게 지원됨
* http://bit.ly/30vm9Lg 참조
* */
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /*
        * assertThat : 테스트 검증 라이브러리의 검증메소드
        * 검증하고 싶은 대상을 메소드 인자로 받음
        * 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능
        *
        * isEqualTo
        * assertj 의 동등 비교메소드
        * assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 떄만 성공
        * */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
