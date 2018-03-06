package kz.kaznitu.repasitories;

import kz.kaznitu.models.Ticher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicherRepasitory extends CrudRepository<Ticher, Long> {
    Optional<Ticher> findById(Long id);
}
