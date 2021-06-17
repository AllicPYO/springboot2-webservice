package kr.co.hanjin.webservice.web.posts;

import kr.co.hanjin.webservice.web.domain.posts.Posts;
import kr.co.hanjin.webservice.web.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PostsRepository postsRepository;

    @After      //Junit 에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정, 배포전 전체테스트를 수행할 때 테스트 간 데이터 침범을 막기 위해 사용.
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //postsRepository.save : insert/update 쿼리를 실행, id 값이 있으면 update, 없다면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("welchsy@gmail.com")
                .build()
        );

        //when
        // postsRepository.findAll : 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        logger.info(">>>>>" + postsList.size());

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
