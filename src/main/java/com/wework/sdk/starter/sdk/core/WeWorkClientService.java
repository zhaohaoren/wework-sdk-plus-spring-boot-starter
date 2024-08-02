package com.wework.sdk.starter.sdk.core;

import cn.hutool.core.util.StrUtil;
import com.wework.sdk.starter.sdk.wework.consts.WeWorkSystemAgentId;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

    /**
     * 普通主体 - 系统通讯录应用TOKEN
     */
    private final Map<String, WeWorkClient> NORMAL_CORP_USER_MAP = new ConcurrentHashMap<>(0);
    /**
     * 普通主体 - 系统外部联系人应用TOKEN
     */
    private final Map<String, WeWorkClient> NORMAL_CORP_EXTERNAL_MAP = new ConcurrentHashMap<>(0);
    /**
     * 普通主体+多自建应用 TOKEN
     * key: 主体id+自建应用id
     */
    private final Map<String, WeWorkClient> NORMAL_MULTI_AGENT_MAP = new ConcurrentHashMap<>(0);
    /**
     * 普通主体-唯一自建应用 TOKEN
     * key: 主体id
     */
    private final Map<String, WeWorkClient> NORMAL_SINGLE_AGENT_MAP = new ConcurrentHashMap<>();
    /**
     * 上下游
     * key: 上下游中的主体id
     * value: (共享的单agent-id，上游主体信息)
     */
    private final Map<String, WeWorkClient> GROUP_CORP_MAP = new ConcurrentHashMap<>();

    /**
     * 添加需要托管的 token
     *
     * @param corpId  主体id
     * @param secret  秘钥
     * @param agentId 应用id，外部联系人应用的id传1，通讯录的应用id传2，其他的传id即可
     * @see WeWorkSystemAgentId
     */
    public void addClient(String corpId, String secret, String agentId) {
        WeWorkClient client = new WeWorkClient();
        client.setCorpId(corpId);
        client.setAgentId(agentId);
        client.setSecret(secret);
        TOKEN_REPO.put(genKey(corpId, agentId), client);
    }

    /**
     * 添加下游应用
     *
     * @param corpId         下游corpId
     * @param agentId        下游共享应用agentId
     * @param upstreamClient 上游主体
     */
    public void addDownstreamClient(String corpId, String agentId, WeWorkClient upstreamClient) {
        WeWorkClient client = new WeWorkClient();
        client.setCorpId(corpId);
        client.setAgentId(agentId);
        client.setUpperStreamClient(upstreamClient);
        TOKEN_REPO.put(genKey(corpId, agentId), client);
    }


    private String genKey(String corpId, String agentId) {
        return corpId + "_" + agentId;
    }

    public WeWorkClient client(String corpId, String agentId) {
        return TOKEN_REPO.get(genKey(corpId, agentId));
    }

    public List<WeWorkClient> clients() {
        return new ArrayList<>(TOKEN_REPO.values());
    }

    public List<WeWorkClient> groupClients(String corpId, String agentId) {
        return TOKEN_REPO.values().stream().filter(item -> {
            if (Objects.isNull(item.getUpperStreamClient())) {
                return false;
            }
            return StrUtil.equals(corpId, item.getUpperStreamClient().getCorpId()) &&
                    StrUtil.equals(agentId, item.getUpperStreamClient().getAgentId());
        }).collect(Collectors.toList());
    }

}
