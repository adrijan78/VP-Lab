package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
	List<Event> findAllByLocation_Id(Long locationId);
	List<Event> findByNameIgnoreCase(String name);
	List<Event> findByPopularityScoreGreaterThanEqual(double score);
	List<Event> findByNameIgnoreCaseAndPopularityScoreGreaterThanEqual(String name, double score);
}
