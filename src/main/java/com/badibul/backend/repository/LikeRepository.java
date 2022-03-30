package com.badibul.backend.repository;

import com.badibul.backend.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByUserIdAndEventId(Long userId, Long eventId );

    List<Like> findByUserId(Long aLong);

    List<Like> findByEventId(Long aLong);
}
