package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

}
/*
INSERT INTO "location" (id, address, capacity, name)
VALUES (0, '123 Main St', 150, 'Kavadarci');
INSERT INTO "location" (id, address, capacity, name)
VALUES (1, '124 Main St', 120, 'Strumica');
INSERT INTO "location" (id, address, capacity, name)
VALUES (2, '125 Main St', 110, 'Ohrid');
INSERT INTO "location" (id, address, capacity, name)
VALUES (3, '126 Main St', 210, 'Skopje');
INSERT INTO "location" (id, address, capacity, name)
VALUES (4, '127 Main St', 90, 'Stip');
*/