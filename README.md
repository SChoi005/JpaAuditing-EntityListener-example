# Jpa Auditing
> The reason why we use Jpa Auditing is that we automatically save created_by, created_at, updated_by, updated_at. <br/>
Recording them in DB is important.

### user entity 
> Add annotation <br/>
@Entity
@EntityLsteners({AuditingEntityListener.class})
@CreatedBy          => when insert quary executes, created_by automatically saves in db.  <br/>
@CreatedDate        => when insert quary executes, created_at automatically saves in db.  <br/>
@LastModifiedBy     => when insert and update quary execute, updated_by automatically saves in db. <br/>
@LastModifiedDate   => when insert and update quary execute, updated_at automatically saves in db.

```bash
    
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

```bash

    @EnableJpaAuditing
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }

```

### implements AuditorAware
> Write what will be saved in created_by and updated_by in getCurrentAuditor() method.

```bash

    @Component
    public class AuditAware implements AuditorAware<String>{

        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("SChoi005");
        }
    }
    
```


# Entity Listener

```bash

    @PrePersist     // Insert호출 전 실행
    @PreUpdate      // merge 호출 전 실행
    @PreRemove      // Delete호출 전 실행
    @PostPersist    // Insert호출 후 실행
    @PostUpdate     // merge 호출 후 실행
    @PostRemove     // Delete호출 후 실행
    @PostLoad       // select호출 후 실행

```


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