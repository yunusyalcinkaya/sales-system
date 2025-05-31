package com.yunusyalcinkaya.commonutils.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Abstract base class for all entities.
 * Contains common fields and audit information.
 * Also provides soft delete functionality.
 */
@Getter
@Setter
@MappedSuperclass
@FilterDef(name = "notDeleted", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "notDeleted", condition = "deleted = :isDeleted")
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;
    
    @Column(nullable = false)
    private boolean deleted = false;
    
    @Column
    private LocalDateTime deletedTime;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    public void delete() {
        this.deleted = true;
        this.deletedTime = LocalDateTime.now();
    }
} 