package com.badibul.backend.repository;

import com.badibul.backend.entity.Basvuru;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasvuruRepository extends JpaRepository<Basvuru,Long> {
    List<Basvuru> findByUserIdAndEventId(Long aLong, Long aLong1);

    List<Basvuru> findByUserId(Long aLong);

    List<Basvuru> findByEventId(Long aLong);
}
