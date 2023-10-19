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

package com.highgo.platform.apiserver.model.po;

import com.highgo.cloud.enums.SwitchStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author: highgo-lucunqiao
 * @date: 2023/4/23 9:00
 * @Description: 自动弹性伸缩开关
 */
@Entity
@Data
@Table(name = "autoscaling_switch")
public class AutoScalingSwitchPO extends BaseEntity {

    /**
     *  自动弹性伸缩开关
     */
    @Enumerated(EnumType.STRING)
    private SwitchStatus autoscalingSwitch = SwitchStatus.OFF;
    /**
     *  用户id
     */
    private String userId;
    /**
     *  集群id
     */
    private String clusterId;
}