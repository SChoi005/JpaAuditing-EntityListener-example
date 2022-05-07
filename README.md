# Jpa Auditing
> The reason why we use Jpa Auditing is that we automatically save created_by, created_at, updated_by, updated_at. <br/>
Recording them in DB is important.

### User entity 
> Add annotation <br/>
@Entity <br/>
@EntityLsteners({AuditingEntityListener.class}) <br/>
@CreatedBy          => when insert quary executes, created_by automatically saves in db.  <br/>
@CreatedDate        => when insert quary executes, created_at automatically saves in db.  <br/>
@LastModifiedBy     => when insert and update quary execute, updated_by automatically saves in db. <br/>
@LastModifiedDate   => when insert and update quary execute, updated_at automatically saves in db.

```java
    
    @EntityListeners({DefaultEntityListener.class, AuditingEntityListener.class})
    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class User{
        
        /* fields */
        
        @CreatedBy
        private String createdBy;

        @CreatedDate
        private LocalDateTime createdAt;

        @LastModifiedBy
        private String updatedBy;

        @LastModifiedDate
        private LocalDateTime updatedAt;
    }
    
```
### Application.java
> Add @EnableJpaAuditing in Application.java

```java

    @EnableJpaAuditing
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }

```

### Implements AuditorAware
> Write what will be saved in created_by and updated_by in getCurrentAuditor() method.

```java

    @Component
    public class AuditAware implements AuditorAware<String>{

        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("SChoi005");
        }
    }
    
```


# Entity Listener
> Entity listeners are useful for general purpose auditing or logging applications.

```java

    @PrePersist     // Before Insert query 
    @PreUpdate      // Before Update query 
    @PreRemove      // Before Delete query 
    @PostPersist    // After Insert query 
    @PostUpdate     // After Update query 
    @PostRemove     // After Delete query 
    @PostLoad       // After select query 

```
