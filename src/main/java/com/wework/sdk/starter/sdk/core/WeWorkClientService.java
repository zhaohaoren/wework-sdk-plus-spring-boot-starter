package com.wework.sdk.starter.sdk.core;

import cn.hutool.core.collection.CollUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * token类型
 * 1. corp + external_user_secret(无)
 * 2. corp + user_secret(无)
 * 3. corp + agent(应用token)
 * 4. enc_corp + agent (下游token)
 * 总体：corp_agent_secret
 *
 * @author zhaohaoren
 */
@Slf4j
public class WeWorkClientService {


    private static final WeWorkClient DEFAULT_CLIENT = new WeWorkClient() {
        @Override
        public <T> T request(WxApiBaseRequest<T> request) {
            log.info("corp not config, request ignore!");
            return null;
        }
    };

    /**
     * 普通主体 - 系统通讯录应用TOKEN
     */
    private Map<String, WeWorkClient> userAgentTokenMap;
    /**
     * 普通主体 - 系统外部联系人应用TOKEN
     */
    private Map<String, WeWorkClient> externalAgentTokenMap;
    /**
     * 普通主体+多自建应用 TOKEN
     * key: 主体id+自建应用id
     */
    private Map<String, WeWorkClient> multiAgentTokenMap;
    /**
     * 普通主体-唯一自建应用 TOKEN
     * key: 主体id
     */
    private Map<String, WeWorkClient> singleAgentTokenMap;
    /**
     * 上下游
     * key: 上下游中的主体id
     * value: (共享的单agent-id，上游主体信息)
     */
    private Map<String, WeWorkClient> groupCorpTokenMap;

    public WeWorkClientService(WeWorkClientProvider weWorkClientProvider) {
        List<WeWorkClient> userAgent = weWorkClientProvider.sysUserAgent();
        if (CollUtil.isNotEmpty(userAgent)) {
            userAgentTokenMap = new ConcurrentHashMap<>();
            userAgent.forEach(item -> userAgentTokenMap.put(item.getCorpId(), item));
        }
        List<WeWorkClient> externalUserAgent = weWorkClientProvider.sysExternalUserAgent();
        if (CollUtil.isNotEmpty(externalUserAgent)) {
            externalAgentTokenMap = new ConcurrentHashMap<>();
            externalUserAgent.forEach(item -> externalAgentTokenMap.put(item.getCorpId(), item));
        }
        List<WeWorkClient> multiAgent = weWorkClientProvider.multiAgent();
        if (CollUtil.isNotEmpty(multiAgent)) {
            multiAgentTokenMap = new ConcurrentHashMap<>();
            multiAgent.forEach(item -> multiAgentTokenMap.put(item.getCorpId() + "_" + item.getAgentId(), item));
        }
        List<WeWorkClient> singleAgent = weWorkClientProvider.singleAgent();
        if (CollUtil.isNotEmpty(singleAgent)) {
            singleAgentTokenMap = new ConcurrentHashMap<>();
            singleAgent.forEach(item -> singleAgentTokenMap.put(item.getCorpId(), item));
        }
        List<WeWorkClient> corpGroupAgent = weWorkClientProvider.corpGroupAgent();
        if (CollUtil.isNotEmpty(corpGroupAgent)) {
            groupCorpTokenMap = new ConcurrentHashMap<>();
            corpGroupAgent.forEach(item -> groupCorpTokenMap.put(item.getCorpId(), item));
        }
    }

    public WeWorkClient userAgent(String corpId) {
        return userAgentTokenMap.getOrDefault(corpId, DEFAULT_CLIENT);
    }

    public WeWorkClient externalAgent(String corpId) {
        return externalAgentTokenMap.getOrDefault(corpId, DEFAULT_CLIENT);
    }

    public WeWorkClient multiAgent(String corpId, String agentId) {
        return multiAgentTokenMap.getOrDefault(corpId + "_" + agentId, DEFAULT_CLIENT);
    }

    public WeWorkClient singleAgent(String corpId) {
        return singleAgentTokenMap.getOrDefault(corpId, DEFAULT_CLIENT);
    }

    public WeWorkClient corpGroup(String corpId) {
        return groupCorpTokenMap.getOrDefault(corpId, DEFAULT_CLIENT);
    }
}
