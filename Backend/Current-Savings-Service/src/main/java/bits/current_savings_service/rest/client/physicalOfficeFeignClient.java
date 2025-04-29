package bits.current_savings_service.rest.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Mf-physical-officeService", contextId = "Mf-Physical-office", path = "/api/v1/physical-office")
public interface physicalOfficeFeignClient {
}
