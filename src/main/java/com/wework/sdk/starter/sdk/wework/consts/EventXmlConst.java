package com.wework.sdk.starter.sdk.wework.consts;

/**
 * 事件xml <Event> 标签对应值
 *
 * @author Justin
 */
public interface EventXmlConst {

    String LAB_TO_USERNAME = "ToUserName";
    String LAB_FROM_USERNAME = "FromUserName";
    String LAB_CREATE_TIME = "CreateTime";
    String LAB_MSG_TYPE = "MsgType";
    String LAB_EVENT = "Event";
    String LAB_CHANGE_TYPE = "ChangeType";
    String LAB_TAG_TYPE = "TagType";
    String LAB_USER_ID = "UserID";
    String LAB_EXTERNAL_USER_ID = "ExternalUserID";
    String LAB_CHAT_ID = "ChatId";
    String LAB_UPDATE_DETAIL = "UpdateDetail";
    String LAB_STATE = "State";
    String LAB_WELCOME_CODE = "WelcomeCode";
    String LAB_SOURCE = "Source";
    String LAB_FAIL_REASON = "FailReason";
    String LAB_JOIN_SCENE = "JoinScene";
    String LAB_QUIT_SCENE = "QuitScene";
    String LAB_ID = "Id";
    String LAB_STRATEGY_ID = "StrategyId";
    String LINK_ID = "LinkId";

    /**
     * user 成员相关label
     */
    String LAB_NAME = "Name";
    String LAB_DEPARTMENT = "Department";
    String LAB_MAIN_DEPARTMENT = "MainDepartment";
    String LAB_IS_LEADER_IN_DEPT = "IsLeaderInDept";
    String LAB_DIRECT_LEADER = "DirectLeader";
    String LAB_MOBILE = "Mobile";
    String LAB_POSITION = "Position";
    String LAB_GENDER = "Gender";
    String LAB_EMAIL = "Email";
    String LAB_BIZ_MAIL = "BizMail";
    String LAB_STATUS = "Status";
    String LAB_AVATAR = "Avatar";
    String LAB_ALIAS = "Alias";
    String LAB_TELEPHONE = "Telephone";
    String LAB_ADDRESS = "Address";
    String LAB_NEW_USER_ID = "NewUserID";

    /**
     * 消息推送补充
     */
    String EVENT_KEY = "EventKey";
    String TASK_ID = "TaskId";
    String CARD_TYPE = "CardType";
    String RESPONSE_CODE = "ResponseCode";
    String AGENT_ID = "AgentID";

    String LAB_PARENT_ID = "ParentId";
    String LAB_ORDER = "Order";


    /**
     * 客户联系事件 <Event>
     * https://open.work.weixin.qq.com/api/doc/90000/90135/92130
     */
    interface CustomerContactConst {

        String CHANGE_EXTERNAL_CONTACT = "change_external_contact";
        String CHANGE_EXTERNAL_CHAT = "change_external_chat";
        String CHANGE_EXTERNAL_TAG = "change_external_tag";

        interface ChangeType {
            /**
             * 添加外部成员
             */
            String ADD_EXTERNAL_CONTACT = "add_external_contact";
            /**
             * 编辑外部成员
             */
            String EDIT_EXTERNAL_CONTACT = "edit_external_contact";
            /**
             * 免验证添加外部成员
             */
            String ADD_HALF_EXTERNAL_CONTACT = "add_half_external_contact";
            /**
             * 删除外部成员
             */
            String DEL_EXTERNAL_CONTACT = "del_external_contact";
            /**
             * 被外部成员删除
             */
            String DEL_FOLLOW_USER = "del_follow_user";

            String TRANSFER_FAIL = "transfer_fail";
            /**
             * 群&企业客户标签 创建事件
             */
            String CREATE = "create";
            /**
             * 群&企业客户标签 更新事件
             */
            String UPDATE = "update";
            /**
             * 群解散事件
             */
            String DISMISS = "dismiss";
            /**
             * 企业客户标签删除事件
             */
            String TAG_DELETE = "delete";
            /**
             * 企业客户标签重排事件
             */
            String SHUFFLE = "shuffle";
        }
    }

    /**
     * 成员变更事件 <Event>
     * https://open.work.weixin.qq.com/api/doc/90000/90135/92130
     */
    interface UserConst {
        // 成员通知事件
        String CHANGE_USER = "change_contact";

        interface ChangeType {
            /**
             * 增加成员事件
             */
            String CREATE_USER = "create_user";
            /**
             * 更新成员事件
             */
            String UPDATE_USER = "update_user";
            /**
             * 删除成员事件
             */
            String DELETE_USER = "delete_user";
        }

        interface DepartmentChangeType {
            String CREATE = "create_party";
            String UPDATE = "update_party";
            String DELETE = "delete_party";
        }
    }

    /**
     * 标签事件
     * https://developer.work.weixin.qq.com/document/path/92130
     */
    interface TagConst {

        String CHANGE_EXTERNAL_TAG = "change_external_tag";
        String TAG = "tag";
        String TAG_GROUP = "tag_group";

        interface ChangeType {
            String CREATE = "create";
            String UPDATE = "update";
            String DELETE = "delete";
            /**
             * 企业客户标签重排事件
             */
            String SHUFFLE = "shuffle";
        }
    }

    /**
     * 消息推送回调事件 <Event>
     * https://open.work.weixin.qq.com/api/doc/90000/90135/90240
     */
    interface MessagePushConst {
        String SUBSCRIBE = "subscribe";
        String ENTER_AGENT = "enter_agent";
        String LOCATION = "LOCATION";
        String BATCH_JOB_RESULT = "batch_job_result";
        String CHANGE_CONTACT = "change_contact";
        String CLICK = "click";
        String VIEW = "view";
        String SCANCODE_PUSH = "scancode_push";
        String SCANCODE_WAIT_MSG = "scancode_waitmsg";
        String PIC_SYS_PHOTO = "pic_sysphoto";
        String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        String PIC_WEI_XIN = "pic_weixin";
        String LOCATION_SELECT = "location_select";
        String OPEN_APPROVAL_CHANGE = "open_approval_change";
        String SHARE_AGENT_CHANGE = "share_agent_change";
        String SHARE_CHAIN_CHANGE = "share_chain_change";
        /**
         * 卡片按钮回调
         */
        String TEMPLATE_CARD_EVENT = "template_card_event";
        String TEMPLATE_CARD_MENU_EVENT = "template_card_menu_event";
    }

    /**
     * 会话回调事件 <Event>
     * https://developer.work.weixin.qq.com/document/path/95039
     */
    interface ConversationConst {
        String CONVERSATION_EVENT = "msgaudit_notify";
    }

    /**
     * 获客链接事件
     */
    interface CustomerAcquisitionConst {

        String EVENT = "customer_acquisition";

        interface ChangeType {
            /**
             * 获客额度即将耗尽事件
             */
            String BALANCE_LOW = "balance_low";
            /**
             * 使用量已经耗尽事件
             */
            String BALANCE_EXHAUSTED = "balance_exhausted";
            /**
             * 获客链接不可用事件
             */
            String LINK_UNAVAILABLE = "link_unavailable";
            /**
             * 微信客户发起会话事件
             */
            String CUSTOMER_START_CHAT = "customer_start_chat";
            /**
             * 删除获客链接事件
             */
            String DELETE_LINK = "delete_link";
            /**
             * 通过获客链接申请好友事件
             */
            String FRIEND_REQUEST = "friend_request";
        }
    }

}
