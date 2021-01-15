package boot.aws.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    void test(){
        String title = "TEST TITLE";
        String content = "TEST Content";

        postsRepository.save(Posts.builder().title(title).content(content).author("jo@gamil.com").build());

        List<Posts> all = postsRepository.findAll();

        Posts posts = all.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
