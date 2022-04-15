package project.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.catalina.core.ApplicationContext;

import project.repository.UserRepository;

//JPA에서 리스너는 @Component를 사용하지 못함 @Autowired 사용 불가
public class DefaultEntityListener{
    
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o){
        //빈 주입
        UserRepository userRepository = BeanUtils.getBean(UserRepository.class);
        
        
    }
}