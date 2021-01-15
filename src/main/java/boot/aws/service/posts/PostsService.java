package boot.aws.service.posts;

import boot.aws.domain.posts.Posts;
import boot.aws.domain.posts.PostsRepository;
import boot.aws.web.dto.PostsResponseDto;
import boot.aws.web.dto.PostsSaveRequestDto;
import boot.aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no posts. id =" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no posts. id = " + id));
        return new PostsResponseDto(entity);
    }


}
