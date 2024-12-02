package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public LocationServiceImpl(){
	}

	@Override
	public Location findById(long id) {
		return locationRepository.getReferenceById(id);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}
}
