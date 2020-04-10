package com.aws.jones.guardanomeaws.repository;

import com.aws.jones.guardanomeaws.model.Name;
import org.springframework.data.repository.CrudRepository;

public interface NameRepository extends CrudRepository<Name, Long> {
}
