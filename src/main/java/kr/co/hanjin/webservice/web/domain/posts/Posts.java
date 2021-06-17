package kr.co.hanjin.webservice.web.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//실제 DB의 테이블과 매칭될 클래스이며, 보통 Entity 클래스라고도 함
//DB데이터에 작업할 경우 실제 쿼리를 날리기보다는 이 Entity클래스의 수정을 통해 작업

//Entity : 테이블과 링크될 클래스임을 나타냄
@Getter
@NoArgsConstructor      //기본 생성자 자동추가
@Entity
public class Posts {

    @Id     // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //PK 생성 규착을 나타냄
    private Long id;


    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        // 해당 클래스의 빌더패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
