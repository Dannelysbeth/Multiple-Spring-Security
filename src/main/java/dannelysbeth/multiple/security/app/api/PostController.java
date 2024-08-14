package dannelysbeth.multiple.security.app.api;

import dannelysbeth.multiple.security.app.model.Post;
import dannelysbeth.multiple.security.app.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository repo;

    PostController (PostRepository postRepository) {
         this.repo = postRepository;
    }

    @GetMapping
    public List<Post> findAll() {
        return repo.findAll();
    }

}
