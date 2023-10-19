/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.highgo.platform.apiserver.model.dto;

import com.highgo.cloud.enums.OperationName;
import com.highgo.cloud.enums.OperationStatus;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class OperationDTO implements Serializable {

    /**
     * 操作步骤名称
     */
    private OperationName name;

    /**
     * 操作步骤状态
     */
    private OperationStatus status;

    public OperationName getName() {
        return name;
    }

    public void setName(OperationName name) {
        this.name = name;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }
}