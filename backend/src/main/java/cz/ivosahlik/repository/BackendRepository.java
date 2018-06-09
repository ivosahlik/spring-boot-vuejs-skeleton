package cz.ivosahlik.repository;

import cz.ivosahlik.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Intellij Idea
 * Created by ivosahlik on 09/06/2018
 */
@Repository
public interface BackendRepository extends JpaRepository<Message, Integer> {



}
