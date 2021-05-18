package io.flats.repository;

import java.util.List;
import java.util.Optional;

import io.flats.entity.Comments;
import io.flats.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Optional<Comments>> findAllByUserTo(User user);
}