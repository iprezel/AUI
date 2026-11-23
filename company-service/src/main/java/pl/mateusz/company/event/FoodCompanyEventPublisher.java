package pl.mateusz.company.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class FoodCompanyEventPublisher {
    private final RestClient restClient;

    public FoodCompanyEventPublisher(@Value("${food.service.url}") String foodServiceUrl) {
        this.restClient = RestClient.create(foodServiceUrl);
    }

    public void companyCreated(UUID id) {
        restClient.put()
                .uri("/api/companies/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

    public void companyDeleted(UUID id) {
        restClient.delete()
                .uri("/api/companies/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}
