package kz.kaznitu.repasitories;

import kz.kaznitu.models.Kafedra;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KafedraRepasitory extends CrudRepository<Kafedra, Long> {
    Optional<Kafedra> findById(Long id);
}
