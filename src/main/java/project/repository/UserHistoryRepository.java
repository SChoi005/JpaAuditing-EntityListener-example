package project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.UserHistory;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>{
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Optional<UserHistory> findByUsername(String username);
}