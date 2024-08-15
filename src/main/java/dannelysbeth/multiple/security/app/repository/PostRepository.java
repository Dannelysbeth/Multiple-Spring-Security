package dannelysbeth.multiple.security.app.repository;

import dannelysbeth.multiple.security.app.model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post,Integer> {
}
