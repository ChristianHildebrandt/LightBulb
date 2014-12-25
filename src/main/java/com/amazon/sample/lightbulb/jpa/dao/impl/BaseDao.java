/*
 * Copyright 2014 Christian Hildebrandt.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazon.sample.lightbulb.jpa.dao.impl;

import com.amazon.sample.lightbulb.literal.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author Christian Hildebrandt
 */
public class BaseDao {
    
    protected static final Logger LOG = Logger.getLogger(BaseDao.class.getName());

    private static final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory(Constants.Database.PERSISTENCE_UNIT);

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    protected Object create(Object object) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
            LOG.debug("Persisted " + object);
        } catch (Exception e) {
            LOG.error("Could not persist Object", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return object;
    }

    public Object read(Object object) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Object result = null;
        try {
            result = em.find(object.getClass(), "id");
            LOG.debug("Found " + object);
        } catch (Exception e) {
            LOG.error("Could not find Object", e);
        } finally {
            em.close();
        }
        return result;
    }

    protected void update(Object object) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Could not update Object", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    protected void delete(Object object) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.error("Could not delete Object", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
