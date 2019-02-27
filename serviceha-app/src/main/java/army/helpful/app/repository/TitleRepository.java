package army.helpful.app.repository;

import army.helpful.app.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TitleRepository extends JpaRepository<Title, Integer> {
    @Query("SELECT t FROM Title t WHERE t.name = ?1")
    Title findByName(String name);
}
