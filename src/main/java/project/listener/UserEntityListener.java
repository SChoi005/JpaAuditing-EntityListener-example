package project.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.extern.slf4j.Slf4j;
import project.entity.User;
import project.entity.UserHistory;
import project.repository.UserHistoryRepository;
import project.repository.UserRepository;

@Slf4j
public class UserEntityListener{
    
    @PrePersist
    public void prePersist(Object o){
        log.info("\n<<<<<<PrePersist\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PreUpdate
    public void preUpdate(Object o){
        log.info("\n<<<<<<preUpdate\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PreRemove
    public void preRemove(Object o){
        log.info("\n<<<<<<preRemove\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PostPersist
    public void postPersist(User o){
        //inject bean => Listener cannot use @component annotation in JPA, so @Autowired annotation cannot use too.
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        UserHistory userHistory = new UserHistory();
        
        userHistory.setUsername(o.getUsername());
        userHistory.setPassword(o.getPassword());
        userHistory.setCreatedBy(o.getCreatedBy());
        userHistory.setCreatedAt(o.getCreatedAt());
        userHistory.setUpdatedBy(o.getUpdatedBy());
        userHistory.setUpdatedAt(o.getUpdatedAt());
        userHistory.setDeleted(false);
        
        userHistoryRepository.save(userHistory);
        
        log.info("\n<<<<<<postPersist\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PostUpdate
    public void postUpdate(User o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        
        UserHistory userHistory = userHistoryRepository.findByUsername(o.getUsername()).get();
        
        userHistory.setUsername(o.getUsername());
        userHistory.setPassword(o.getPassword());
        userHistory.setUpdatedBy(o.getUpdatedBy());
        userHistory.setUpdatedAt(o.getUpdatedAt());
        
        userHistoryRepository.save(userHistory);
        log.info("{}", userHistory);
        
        log.info("\n<<<<<<postUpdate\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PostRemove
    public void postRemove(Object o){
        log.info("\n<<<<<<postRemove\n {}\n <<<<<<<<<", o.toString());        
    }
    
    @PostLoad
    public void postLoad(Object o){
        log.info("\n<<<<<<postLoad\n {}\n <<<<<<<<<", o.toString());        
    }
}