package ua.nox.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.nox.domain.NzakItem;
import ua.nox.repository.NzakItemRepository;
import ua.nox.service.NzakService;


/**
 * Created by onitsov on 10/6/2016.
 */
@RestController
public class NzakController {

    @Autowired
    private NzakService service;

    @ResponseBody
    @GetMapping("/find")
    public Page<NzakItem> findItemByNameOrSurName(@RequestParam("q") String query, Pageable pageable) {
        return this.service.findByQuery(query, pageable);
    }

}
