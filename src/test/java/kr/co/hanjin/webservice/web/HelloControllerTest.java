package kr.co.hanjin.webservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
* RunWith(SpringRunner.class)
* 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
* 스프링부트 테스트와 JUnit 사이에 연결자 역할을 한다.
* */
@RunWith(SpringRunner.class)
/*
* Web(Spring MVC)에 집중할 수 있는 어노테이션
* 선언을 할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
* 단, @Service, @Component, @Repository 등은 사용할 수 없다.
* */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
    * AutoWired
    * 스프링이 관리하는 빈(Bean) 을 주입받는다.
    * */
    @Autowired
    /*
    * private MockMvc mvc
    * 웹 API 를 테스트 할  때 사용, 스프링 MVC 테스트의 시작점
    * HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
    * */
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))      //MockMVC 를 통해 /hello 주소로 HTTP GET 요청
                                                    //체이닝이 지원되어 여러 검증 기능을 이어서 선언 가능
                .andExpect(status().isOk())         //mvc.perform 의 결과를 검증, HTTP Header의 Status 를 검증
                .andExpect(content().string(hello));    //응답 본문의 내용을 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        /*
        * param
        * API 테스트할 떄 사용될 요청 파라미터를 설정
        * 값은 String 만 허용
        *
        * jsonPath
        * JSON 응답값을 필드별로 검증할 수 있는 메소드
        * $를 기준으로 필드명을 명시한다.
        * */
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
        ;
    }
}
