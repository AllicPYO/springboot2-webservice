package kr.co.hanjin.webservice.web;

import kr.co.hanjin.webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
* RestController
* 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
* 예전에는 @ResponseBody 를 각 메소드마다 선언했던 것을 한번에 사용해주게 함
* */
@RestController
public class HelloController {

    /*
    * GetMapping
    * HTTP Method인 Get 의 요청을 받을 수 있는 API를 만들어줌
    * 이전에는 @RequestMapping(method=RequestMehod.GET) 으로 사용    * */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
                                    //RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 annotation
                                    @RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
