package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/{id}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long id) {
        List<CommentDto> dtos = commentService.comments(id);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/articles/{id}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long id, @RequestBody CommentDto dto) {
        CommentDto commentDto = commentService.create(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(commentDto);
    }

    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto) {
        CommentDto commentDto = commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(commentDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto delete = commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
}
