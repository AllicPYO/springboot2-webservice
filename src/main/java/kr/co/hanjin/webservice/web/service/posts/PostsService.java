package kr.co.hanjin.webservice.web.service.posts;

import kr.co.hanjin.webservice.web.domain.posts.Posts;
import kr.co.hanjin.webservice.web.domain.posts.PostsRepository;
import kr.co.hanjin.webservice.web.dto.PostsUpdateRequestDto;
import kr.co.hanjin.webservice.web.dto.PostsResponseDto;
import kr.co.hanjin.webservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );

        return new PostsResponseDto(entity);
    }
}
