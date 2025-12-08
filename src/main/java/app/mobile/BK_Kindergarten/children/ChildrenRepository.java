package app.mobile.BK_Kindergarten.children;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Integer> {
    List<Children> findAllByName(String name);
}
