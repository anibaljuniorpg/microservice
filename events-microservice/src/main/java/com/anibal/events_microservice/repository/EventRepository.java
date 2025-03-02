package com.anibal.events_microservice.repository;

import com.anibal.events_microservice.domain.Event;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {
    //
    @Query(value = "SELECT * FROM events e WHERE PARSEDATETIME(e.date,dd/MM/yyyy AS TIMETAMP) > currentDate", nativeQuery = true)
    List<Event> findUpcomingEvents(@Param("currentDate")LocalDateTime currentDate);

    @Nonnull
    Optional<Event> findById(@Nonnull String id);
}
