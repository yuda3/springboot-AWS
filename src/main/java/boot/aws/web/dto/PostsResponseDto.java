package boot.aws.web.dto;

import boot.aws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;


    public PostsResponseDto(Posts posts) {
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
