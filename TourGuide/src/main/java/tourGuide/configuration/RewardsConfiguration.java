package tourGuide.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rewardCentral.RewardCentral;
import tripPricer.TripPricer;

@Configuration
public class RewardsConfiguration {

	@Bean
	public RewardCentral getRewardCentral() {
		return new RewardCentral();
	}

	@Bean
	public TripPricer getTripPricer() { return new TripPricer(); }

}