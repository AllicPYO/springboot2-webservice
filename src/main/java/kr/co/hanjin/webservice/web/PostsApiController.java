package kr.co.hanjin.webservice.web;

import kr.co.hanjin.webservice.web.dto.PostsUpdateRequestDto;
import kr.co.hanjin.webservice.web.dto.PostsResponseDto;
import kr.co.hanjin.webservice.web.dto.PostsSaveRequestDto;
import kr.co.hanjin.webservice.web.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping(value="/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping(value="/api/v1/posts/{id}")
    public Long update(@PathVariable(name = "id") Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping(value="/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable(name="id") Long id) {
        return postsService.findById(id);
    }

}
