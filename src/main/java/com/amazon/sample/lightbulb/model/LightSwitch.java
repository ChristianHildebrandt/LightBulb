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
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * LightSwitch entity represents a switch to turn on/off a light bulb. It holds
 * the state of the light bulb and the datetime off toggling from on to off and
 * vice versa.
 *
 * @author Christian Hildebrandt
 */
@Entity
public class LightSwitch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lightswitch_id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.lightswitch_id);
        hash = 79 * hash + Objects.hashCode(this.toggleDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LightSwitch other = (LightSwitch) obj;
        if (!Objects.equals(this.toggleDate, other.toggleDate)) {
            return false;
        }
        return this.lightState == other.lightState;
    }

}
