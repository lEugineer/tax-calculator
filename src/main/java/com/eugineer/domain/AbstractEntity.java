package com.eugineer.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<T extends AbstractEntity> implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    protected Integer version;

    @CreatedDate
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime updatedAt;

    @Nullable
    @Override
    public Long getId () {
        return id;
    }

    public AbstractEntity setId ( Long id ) {
        this.id = id;
        return (T) this;
    }

    public Integer getVersion () {
        return version;
    }

    public AbstractEntity setVersion ( Integer version ) {
        this.version = version;
        return (T) this;
    }

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public AbstractEntity setCreatedAt ( LocalDateTime createdAt ) {
        this.createdAt = createdAt;
        return (T) this;
    }

    public LocalDateTime getUpdatedAt () {
        return updatedAt;
    }

    public AbstractEntity setUpdatedAt ( LocalDateTime updatedAt ) {
        this.updatedAt = updatedAt;
        return (T) this;
    }

    @Override
    public boolean isNew () {
        return id == null;
    }
}
