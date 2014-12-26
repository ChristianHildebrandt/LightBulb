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
package com.amazon.sample.lightbulb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Christian Hildebrandt
 */
@Entity
public class LightSwitch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lightswitch_id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toggleDate;

    @Enumerated(EnumType.STRING)
    private LightState lightState;

    public Long getLightswitch_id() {
        return lightswitch_id;
    }

    public void setLightswitch_id(Long lightswitch_id) {
        this.lightswitch_id = lightswitch_id;
    }
    public Date getToggleDate() {
        return toggleDate;
    }

    public void setToggleDate(Date toggleDate) {
        this.toggleDate = toggleDate;
    }

    public LightState getLightState() {
        return lightState;
    }

    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }

}
