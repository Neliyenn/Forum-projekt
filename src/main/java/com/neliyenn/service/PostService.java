package com.neliyenn.service;

import com.neliyenn.model.Post;
import com.neliyenn.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Klasa Service dla obiektów domeny {@link Post}
 * Odwoluje sie do {@link com.neliyenn.repository.PostRepository}
 */
public interface PostService {

    Optional<Post> findForId(Long id);
    Post save(Post post);

    /**
     * Wyszukuje {@link Page} i {@link Post} podanego uzytkownika uporzadkowane wg daty
     */
    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    /**
     * Wyszukuje {@link Page} wsrid wszystkich {@link Post}cuporzadkowane wg daty
     */
    Page<Post> findAllOrderedByDatePageable(int page);

    /**
     * Usuwa {@link Post} z magazynu danych
     */
    void delete(Post post);
}
