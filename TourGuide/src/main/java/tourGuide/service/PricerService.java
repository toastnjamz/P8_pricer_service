package tourGuide.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class PricerService {

	private final TripPricer tripPricer;

	@Autowired
	public PricerService(TripPricer tripPricer) {
		this.tripPricer = tripPricer;
	}

	public List<Provider> getTripDeals(String tripPricerApiKey, UUID userId, int numberOfAdults, int numberOfChildren,
											int tripDuration, int cumulativeRewardPoints) {
		List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren, tripDuration, cumulativeRewardPoints);
		return providers;
	}

}
