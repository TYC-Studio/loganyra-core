package org.tyc_studio.loganyra.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tyc_studio.loganyra.entities.LogEntity;

import java.util.List;

@Component
@Transactional
public class LogDAO {
    @PersistenceContext
    EntityManager em;

    public LogEntity getLogByID(long id) {
        return this.em.find(LogEntity.class, id);
    }

    public List<LogEntity> getByAppName(String appName) {
        TypedQuery<LogEntity> query = em.createQuery("SELECT u FROM LogEntity u WHERE u.appName = :a", LogEntity.class);
        query.setParameter("a", appName);
        List<LogEntity> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
