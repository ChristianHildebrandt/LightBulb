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
 * BaseDao class provides several data access methods for use in specialized
 * data access objects
 *
 * @author Christian Hildebrandt
 */
public class BaseDao {

    /**
     * Logger for logging error, debug or normal logs
     */
    protected static final Logger LOG = Logger.getLogger(BaseDao.class.getName());

    private static final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory(Constants.Database.PERSISTENCE_UNIT);

    /**
     * Gets an Entitymanager from the static EntityManagerFactory. This method
     * can be used of any extending class.
     *
     * @return EntityManager for database queries
     */
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates a given entity in the database
     *
     * @param object Entity that should be saved
     * @return The same object after adding it to database
     */
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

    /**
     * Reads an Entity from databse
     *
     * @param object Objects that has to be read
     * @return Read object
     */
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

    /**
     * Updates an entity in the databse
     *
     * @param object Object that has to be updated
     */
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

    /**
     * Deletes an entity from the database
     *
     * @param object Object that has to be deleted
     */
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
