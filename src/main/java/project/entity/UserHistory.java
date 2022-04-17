package project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;
    
    private String createdBy;

    private LocalDateTime createdAt;
    
    private String updatedBy;
    
    private LocalDateTime updatedAt;
    
    private String deletedBy;
    
    private LocalDateTime deletedAt;
    
    private boolean isDeleted;
}