/*
*Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/
package org.wso2.carbon.automation.engine.extensions;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.xpath.XPathExpressionException;

public abstract class SuiteListenerExtension extends ListenerExtension {
    private final Log log = LogFactory.getLog(getClass());
    private final static String XPATH_TO_CLASS = "//listenerExtensions/PlatformSuiteManager/extentionClasses/class/name";

    public SuiteListenerExtension() {
        super();
        try {
            setParameterMap(XPATH_TO_CLASS, getClass().getName());
        } catch (XPathExpressionException e) {
            log.warn("Failed to initializing the Extension Class");
            log.error("Error initializing the Automation Context", e);
        }
    }
    public abstract void initiate();

    public abstract void onStart();

    public abstract void onFinish();

}
