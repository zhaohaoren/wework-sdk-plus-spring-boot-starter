package com.wework.sdk.starter.sdk.wework.api.department.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class DepartmentListResponse extends WxApiBaseResponse {

    private List<DepartmentItem> department;

    @Data
    public static class DepartmentItem {
        private Integer id;
        private String name;
        @JsonProperty("name_en")
        private String nameEn;
        @JsonProperty("department_leader")
        private List<String> departmentLeader;
        @JsonProperty("parentid")
        private Integer parentId;
        private Integer order;
    }
}
