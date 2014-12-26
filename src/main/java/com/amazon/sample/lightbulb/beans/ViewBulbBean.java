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
package com.amazon.sample.lightbulb.beans;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.service.IBusinessService;
import com.amazon.sample.lightbulb.service.impl.BusinessService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Christian Hildebrandt
 */
@ManagedBean
@SessionScoped
public class ViewBulbBean {

    IBusinessService businessService = BusinessService.getInstance();

    private LightState currentState;

    public LightState getCurrentState() throws DatabaseException {
        currentState = businessService.getLastLightState();
        return currentState;
    }

    public void setCurrentState(LightState currentState) {
        this.currentState = currentState;
    }

//    public String toggleLight() {
//        try {
//            if (loginService.isAuthorized(username, password)) {
//                loggedIn = true;
//                loginFailed = false;
//                return "Employee/users.xhtml";
//            } else {
//                loggedIn = false;
//                loginFailed = true;
//            }
//        } catch (UserNotFoundException ex) {
//            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            FacesMessage fm;
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
//            facesContext.addMessage(null, fm);
//        }
//        return null;
////        return "Employee/users.xhtml";
//    }
//    private void addErrorMessage(String msg, String clientId) {
//        String codingErrorMsgKey = "coding_error_msg";
//        FacesMessage fm;
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        if (StringUtils.isEmpty(msg)) {
//            ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "bundle");
//            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(codingErrorMsgKey), bundle.getString(codingErrorMsgKey));
//        } else {
//            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
//        }
//        facesContext.addMessage(clientId, fm);
//    }
}
