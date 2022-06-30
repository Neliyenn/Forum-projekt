package com.neliyenn.service;

import com.neliyenn.model.Post;
import com.neliyenn.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Klasa Service dla obiektów domeny {@link Post}
 * Odwoluje sie do {@link com.neliyenn.repository.PostRepository}
 */
public interface PostService {

    /**
     * Wyszukuje n najnowszych postów {@link Post}
     *
     * @param n
     * @return - zwraca zbiór {@link Post}
     */
    Collection<Post> findNLatestPosts(int n);

    Collection<Post> findNLatestPostsForUser(int n, User user);

    Post findPostForId(Long id);

    Post savePost(Post post);

    Page<Post> findAllPageable(Pageable pageable);

    /**
     * Wyszukuje {@link Page} i {@link Post} podanego uzytkownika uporzadkowane wg daty
     *
     * @param user
     * @param pageable
     * @return - zwraca instancje {@link Page}
     */
    Page<Post> findByUserOrderedByDatePageable(User user, Pageable pageable);

    /**
     * Wyszukuje {@link Page} wsrid wszystkich {@link Post}cuporzadkowane wg daty
     *
     * @param pageable
     * @return - zwraca instancje {@link Page}
     */
    Page<Post> findAllOrderedByDatePageable(Pageable pageable);

    /**
     * Usuwa {@link Post} z magazynu danych
     *
     * @param post - {@link Post} do usuniecia
     */
    void delete(Post post);
}
