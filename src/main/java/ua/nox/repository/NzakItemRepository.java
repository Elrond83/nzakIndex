package ua.nox.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ua.nox.domain.NzakItem;

import java.util.UUID;

/**
 * Created by onitsov on 10/6/2016.
 */
public interface NzakItemRepository extends CrudRepository <NzakItem, UUID> {

    Page<NzakItem> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName, Pageable pageable);

}
