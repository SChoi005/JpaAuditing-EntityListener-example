package project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.listener.UserEntityListener;

@EntityListeners({UserEntityListener.class, AuditingEntityListener.class})
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;
    
    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
}