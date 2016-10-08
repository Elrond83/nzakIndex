package ua.nox.service;

import com.fasterxml.jackson.databind.ObjectReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.nox.domain.NzakItem;
import ua.nox.domain.NzakResponse;
import ua.nox.repository.NzakItemRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by onitsov on 10/7/2016.
 */
@Component
public class NzakService {
    Logger log = LoggerFactory.getLogger(NzakService.class);

    @Autowired
    private NzakItemRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectReader nzakResponseReader;

    @Value("${nzak.url}")
    private String nzakUrl;

    public Page<NzakItem> findByQuery(String query, Pageable pageable) {
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase (query, query, pageable);
    }

    public NzakItem getById(UUID uuid) {
        return repository.findOne(uuid);
    }

    public void refresh() throws IOException {
        log.info("starting refresh");
        Map<String,String> map = new HashMap<>();
        map.put("page","10");
        String response =  restTemplate.getForObject(nzakUrl, String.class,map );
        NzakResponse nzakResponse = nzakResponseReader.readValue(response);
        List<NzakItem> items = nzakResponse.getItems();
        repository.save(items);
        log.info("refresh finished");
    }



}
