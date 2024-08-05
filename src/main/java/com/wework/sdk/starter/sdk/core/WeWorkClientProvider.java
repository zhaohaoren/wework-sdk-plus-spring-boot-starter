package com.wework.sdk.starter.sdk.core;

import java.util.List;

/**
 * @author zhaohaoren
 */
public interface WeWorkClientProvider {

    /**
     * 系统的通讯录应用
     */
    List<WeWorkClient> sysUserAgent();

    /**
     * 系统的联系人应用
     */
    List<WeWorkClient> sysExternalUserAgent();

    /**
     * 一个主体多自建应用
     */
    List<WeWorkClient> multiAgent();

    /**
     * 一个主体一个自建引用
     */
    List<WeWorkClient> singleAgent();

    /**
     * 上下游应用
     */
    List<WeWorkClient> corpGroupAgent();
}
