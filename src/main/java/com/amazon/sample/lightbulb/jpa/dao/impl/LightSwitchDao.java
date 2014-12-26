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

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.jpa.dao.ILightSwitchDao;
import com.amazon.sample.lightbulb.literal.Constants;
import com.amazon.sample.lightbulb.model.LightSwitch;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.h2.engine.User;

/**
 *
 * @author Christian Hildebrandt
 */
public class LightSwitchDao extends BaseDao implements ILightSwitchDao{

    @Override
    public void addSwitch(LightSwitch lightswitch) {
        super.create(lightswitch);
    }

    @Override
    public List<LightSwitch> getAllLightSwitches() throws DatabaseException {
        EntityManager em = getEntityManager();
        Query query = em.createQuery(Constants.Database.NamedQueries.GET_ALL_SWITCHES, LightSwitch.class);
        List<LightSwitch> allSwitches = query.getResultList();
        em.close();
        return allSwitches;
    }
    
    
    
}
