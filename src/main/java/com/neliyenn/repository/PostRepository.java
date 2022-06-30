package com.neliyenn.repository;

import com.neliyenn.model.Post;
import com.neliyenn.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

    /**
     * pobiera {@link Page} i {@link Post} z magazynu danych nalezacych do uzytwkonka i uporzadkowanych wg daty
     *
     * @param user - wlasciciel {@link Post}
     * @param pageable
     * @return - zwraca {@link Page} i {@link Post}
     */
    Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

    /**
     * pobiera {@link Page} ze wszystkich {@link Post} z magazynu danych uporzadkowanych wg daty
     *
     * @param pageable
     * @return - zwraca {@link Page} i {@link Post}
     */
    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

}
