package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// NOTE: JPA에서 단순히 CRUD 작업만 한다면 CrudRepository를 사용해도 충분. 하지만 CRUD 작업에 더해 페이지 처리와 정렬 작업까지 해야 한다면 JpaRepository 사용하는 것이 좋음
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    List<Comment> findByNickname(String nickname);
}
