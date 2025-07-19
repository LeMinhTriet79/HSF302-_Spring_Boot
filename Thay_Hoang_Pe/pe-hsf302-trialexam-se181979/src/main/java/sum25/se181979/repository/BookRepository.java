package sum25.se181979.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sum25.se181979.pojo.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> searchAllByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String authorName);

    public List<Book> getAllByOrderByCreatedAtDesc();
}
