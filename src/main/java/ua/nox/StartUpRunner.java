package ua.nox;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ua.nox.service.NzakService;

/**
 * Created by onitsov on 10/7/2016.
 */
@Component
public class StartUpRunner implements ApplicationRunner {

    @Getter
    @Setter
    @Autowired
    private NzakService service;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        service.refresh();
    }
}
