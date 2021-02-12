package tourGuide.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tourGuide.domain.ProviderListWrapper;
import tourGuide.service.PricerService;

import java.util.UUID;

@RestController
@Api(description="Rewards microservice for TourGuide")
public class PricerController {

    @Autowired
    private PricerService pricerService;
    private final Logger logger = LoggerFactory.getLogger(PricerController.class);

    /**
     * Gets a list of a user's available trip deals
     * @param tripPricerApiKey
     * @param userId
     * @param numberOfAdults
     * @param numberOfChildren
     * @param tripDuration
     * @param cumulativeRewardPoints
     * @return list of trip deals
     */
    @RequestMapping("/trip-deals")
    public ProviderListWrapper getTripDeals(@RequestParam String tripPricerApiKey, @RequestParam UUID userId, @RequestParam int numberOfAdults,
                                            @RequestParam int numberOfChildren, @RequestParam int tripDuration,
                                            @RequestParam int cumulativeRewardPoints) {
        logger.debug("Request made to getTripDeals");
        ProviderListWrapper providerListWrapper = new ProviderListWrapper();
        providerListWrapper.setProviderList(pricerService.getTripDeals(tripPricerApiKey, userId, numberOfAdults,
                numberOfChildren, tripDuration, cumulativeRewardPoints));
        return providerListWrapper;
    }

}
