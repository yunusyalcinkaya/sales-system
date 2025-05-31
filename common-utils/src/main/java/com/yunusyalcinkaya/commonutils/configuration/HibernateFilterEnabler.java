package com.yunusyalcinkaya.commonutils.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class HibernateFilterEnabler {

    private final EntityManager entityManager;

    public HibernateFilterEnabler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void enableNotDeletedFilter() {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("notDeleted").setParameter("isDeleted", false);
    }
} 