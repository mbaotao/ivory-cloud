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

package com.highgo.platform.errorcode;

public enum ParamError implements BaseError {

    RESTORE_("200.005001", "instance.create.duplicate_name"), // 实例重名
    INSTANCE_NOT_EXIST("200.005002", "instance.not_exist"), // 实例不存在
    INSTANCE_NOT_AUTH("200.005003", "instance.not_authority"), // 实例无操作权限
    INSTANCE_NOT_ALLOW_OPERATE("200.005.004", "instance.not_allow_operate"), // 当前状态不允许操作
    INSTANCE_NOT_ALLOW_DEMOTE("200.005.005", "instance.not_allow_demote"), // 实例规格不允许降级，只能升级
    INSTANCE_NOT_ALLOW_SHRINKAGE("200.005.006", "instance.not_allow_shrinkage"), // 实例存储不允许缩容，只能扩容
    INSTANCE_NO_CHANGE("200.005.007", "instance.no_change"); // 实例变更参数与当前一直，无需变更

    private String code;
    private String message;

    ParamError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String message(Object... args) {
        return this.message;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String code() {
        return code;
    }
}