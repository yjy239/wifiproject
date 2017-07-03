package yidu.cooking.network;

import okhttp3.FormBody;
import yidu.cooking.utils.MD5;

/**
 * Created by Administrator on 2016/7/5.
 */
public class HttpApi {


//    "http://api.global.football.gamenew100.com"
    //主服务器地址
	private static final String mainURL = "http://api.lht9.com";
//    private static final String mainURL = "http://api.global.football.gamenew100.com";
    /**图片地址*/
    private static final String imageURL = "http://football9.b0.upaiyun.com";
    //签名用到的randomKey
    private static final String randomKey = "123456";

    public static final String imageLoadURL = "http://v0.api.upyun.com/football9";

    //返回值为{code:0,content:响应数据,message:错误详情}，code为0时表示成功，其它均为失败

    /**
     * 初始化：
    接口：/public/init
    参数：version
    返回：versiondata,uploaddata,coverdata,matchcategorylist*/
    public static final String Init = "/public/init";


    //region 会员类接口
    /**
    * 会员注册
    * 参数:partner_id,mobile,password,nickname,captchacode
    * */
    public static final String Register = "/user/register";
    /**
    * 会员登录
    * 参数:partner_id,mobile,password
    * */
    public static final String Login = "/user/login";
    /**
    * 会员登出
    * 参数:user_id,token,sig
    * */
    public static final String Logout = "/user/logout";
    /**
    * 会员修改(找回)密码
    * 参数:captchacode,mobile,password
    * */
    public static final String ChangePwd = "/user/changepwd";
    /**
    * 获取会员信息
    * 参数:user_id,token,sig,version
    * */
    public static final String Profile = "/user/profile";
    /**
    * 获取会员动态列表信息
    * 参数:user_id,token,sig,version,page,timeline_user_id
    * */
    public static final String Timeline = "/user/timeline";

    /**
     *
     * 获取会员动态列表详细信息
     * */
    public static final String TimeLineDetail = "/timeline/detail";


    /**
    * 上传会员设备信息
    * 参数:user_id,token,sig,deviceid,devicemodel,os,osversion,version
    * */
    public static final String DeviceInfo = "/user/deviceinfo";

    /**上传会员信息**/
    public static final String Update = "/user/update";


    /**
     * 第三方登录
     * 参数：platform,openid,accesstoken,expiresin,refreshtoken,parterid,city_id,lng,lat*/
    public static final String ThirdLogin = "/user/thirdlogin";

    /**
     * 第三方登录绑定
     * 参数：mobile,password,captchacode,user_id,token,sig**/
    public static final String ThirdBind = "/user/thirdbind";

    /**
     * 更换绑定手机
     * 参数：mobile,captchacode**/
    public static final String ChangeMobile = "/user/changemobile";

    /***
     *绑定手机 */
    public static final String BindMobile = "/user/bindmobile";

    /**
     * 修改手机密码*/
    public static final String ResetPw = "/user/resetpwd";


    //endregion

    //region 关系链接口
    /**
    * 添加关注
    * 参数:follow_user_id,user_id,token,sig
    * */
    public static final String Follow = "/relationship/follow";
    /**
    * 取消关注
    * 参数:disfollow_user_id,user_id,token,sig
    * */
    public static final String Disfollow = "/relationship/disfollow";
    /**
    * 添加备注
    * 参数:remark_user_id,name,user_id,token,sig
    * */
    public static final String Remark = "/relationship/remark";

    /**备注信息
     * 参数:user_id,token,sig**/
    public static final String RemarkList = "/relationship/remarklist";

    /***
     * 获取好友列表
     * 参数:user_id,token,sig**/
    public static final String GethxUser = "/user/gethxuser";
    //endregion

    //region 新闻头条接口
    /**
    * 头条详情
    * 参数:news_id
    * */
    public static final String NewsDetail = "/news/detail";
    /**
    * 头条评论列表
    * 参数:news_id,page
    * */
    public static final String NewsCommentlist = "/news/commentlist";
    /**
    * 添加头条评论
    * 参数:news_id,content,user_id,token,sig,pid,reply_user_id
    * */
    public static final String NewsAddcomment = "/news/addcomment";
    /**
    * 头条新闻列表
    * 参数:area_id,page
    * */
    public static final String NewsList = "/news/list";
    /**
    * 评论点赞
    * 参数:news_id,comment_id,user_id,token,sig
    * */
    public static final String NewsAddlike = "/news/addlike";
    //endregion

    /**
     * 检测验证码是否正确
     * 参数:mobile,type,captchacode
     */
    public static final String SMSCheck = "/sms/check";
    /**
     * 发送验证码
     * 参数:mobile,type
     */
    public static final String SMSSend = "/sms/send";

    //region 商城接口
    /**
     * 商城物品列表
     * 参数:area_id,page
     */
    public static final String ShoppingList = "/shopping/list";
    /**
     * 商城物品兑换
     * 参数:shopping_id,user_id,token,sig
     */
    public static final String ShoppingExchange = "/shopping/exchange";

    /**获取推送的赛事提醒*/
    public static final String Jpush = "/user/jpush";

    /**获取邀请码**/
    public static final String ShareCode = "/user/sharecode";

    /***更新已读消息**/
    public static final String UpdateMesssage = "/my/updatemessage";
    //endregion


    //region 赛事接口
    /**
     * 约战赛事
     * 参数:area_id,
     * user_id,token,sig
     */
    public static final String MatchFreedom = "/match/freedom";
    /**
     * 常规赛事
     * 参数:category_id,
     * user_id,token,sig
     */
    public static final String MatchGeneral = "/match/general";

    /**
     * 关注赛事
     * 参数:match_id,
     * user_id,token,sig
     */
    public static final String MatchFollow = "/match/follow";
    /**
     * 取消关注赛事
     * 参数:match_id,
     * user_id,token,sig
     */
    public static final String MatchUnFollow = "/match/unfollow";
    /**
     * 赛事签到
     * 参数:match_id,
     * user_id,token,sig
     */
    public static final String MatchSign = "/match/sign";
    /**
     * 赛事详情
     * 参数:match_id,
     * user_id,token,sig
     */
    public static final String MatchDetail = "/match/detail";
    /**
     * 加入阵营
     * 参数:support_team_id,match_id,
     * user_id,token,sig
     */
    public static final String MatchJoincamp = "/match/joincamp";
    /**
     * 球队评价
     * 参数:
     * assessment_team_id, assessment_user_id,type, match_id,
     * user_id,token,sig
     */
    public static final String MatchAssessment = "/match/assessment";
    /**
     * 赛事举报
     * 参数:match_id,
     * user_id,token,sig
     */
    public static final String MatchReport = "/match/report";
    /**
     * 赛事评分
     * 参数  match_id ,score ,stadium_id ,judge_id ,cheer_id ,data
     * user_id,token,sig
     */
    public static final String MatchScore = "/match/score";
    /**
     * 球队签到
     * 参数  match_id ,battledata
     * user_id,token,sig
     */
    public static final String MatchEmbattle = "/match/embattle";
    //endregion


    //region 动态接口
    /**
     * 圈子动态列表
     * 参数：category_id,type,page**/
    public static final String CircleList = "/timeline/list";

    /**
     * 动态分享
     * 参数 timeline_id**/
    public static final String Share="/timeline/share";

    /***
     * 点赞
     * 参数timeline_id*/
    public static final String Like = "/timeline/like";

    /**
     * 取消点赞
     * 参数 timeline_id,token,uid,sig*/
    public static final String disLike="/timeline/dislike";

    /**
     * 发送帖子
     * 参数 category_id,text,media_ids,user_id,token,sig*/
    public static final String Post = "/timeline/post";

    /***
     * 删除帖子
     * 参数 timeline_id,user_id,token,sig*/
    public static final String delPost = "/timeline/delete";

    /**
     * 发送评论
     * 参数 timeline_id,content,user_id,token,sig*/
    public static final String postComment = "/timeline/postcomment";

    /**
     *删除评论
     * 参数 timeline_id,timeline_comment_id,user_id,token,sig**/
    public static final String delComment="/timeline/delcomment";

    /**
     * 评论点赞
     * 参数 timeline_comment_id,user_id,token,sig*/
    public static final String likeComment="/timeline/likecomment";

    /**
     * 删除评论点赞**/
    public static final String dislikeComment="/timeline/dislikecomment";

    public static final String atuser = "/timeline/addnote";

    //endregion

    //region 达人榜
    /**
     * 球员排名
     * 参数 city_id,page,
     * user_id,token,sig
     */
    public static final String RankUser = "/rank/user";
    /**
     * 球队排名
     * 参数 city_id,page,
     * user_id,token,sig
     */
    public static final String RankTeam = "/rank/team";
    //endregion

    //region 约战
    /**
     * 自由约战
     * 参数  city_id,page,
     * user_id,token,sig
     */
    public static final String AppointmentFreeList = "/appointment/freelist";
    /**
     * 自由约战详情
     * 参数  match_id
     * user_id,token,sig
     */
    public static final String AppointmentFreeDetail = "/appointment/freedetail";
    /**
     * 创建自由约战数据接收
     * 参数  stadium_id,stadium_name,address,gametime,playerset,cost,city_id,minutes,friends,nearpeoples
     * user_id,token,sig
     */
    public static final String AppointmentFreeAdd = "/appointment/freeadd";
    /**
     * 自由约战申请
     * 参数  match_id
     * user_id,token,sig
     */
    public static final String AppointmentFreeApply = "/appointment/freeapply";
    /**
     * 自由约战申请列表
     * 参数  match_id
     * user_id,token,sig
     */
    public static final String AppointmentFreeApplyList = "/appointment/freeapplylist";
    /**
     * 通过申请者参赛
     * 参数  match_id ,user_ids ,action
     * user_id,token,sig
     */
    public static final String AppointmentFreeApplyHandle ="/appointment/freeapplyhandle";
    /**
     * 邀请好友
     * 参数  match_id ,user_ids
     * user_id,token,sig
     */
    public static final String AppointmentFreeInvite = "/appointment/freeinvite";

    /***邀请我的**/
    public static final String FreeInvite = "/appointment/freeinviter";
    /**
     * 个人邀战处理
     * 参数  match_id  ,action
     * user_id,token,sig
     */
    public static final String AppointmentFreeInviteHandle = "/appointment/freeinvitehandle";
    /**
     * 我的约战
     * 参数
     * user_id,token,sig
     */
    public static final String AppointmentFreeOwner = "/appointment/freeowner";
    /**
     * 我的应战
     * 参数
     * user_id,token,sig
     */
    public static final String AppointmentFreeParter = "/appointment/freeparter";
    /**
     * 邀请我的
     * 参数
     * user_id,token,sig
     */
    public static final String AppointmentFreeInviter = "/appointment/freeinviter";



    /**
     * 球队约战列表
     * 参数  city_id，page
     * user_id,token,sig
     */
    public static final String AppointmentTeamList = "/appointment/teamlist";
    /**
     * 球队约战详情
     * 参数  match_id
     * user_id,token,sig
     */
    public static final String AppointmentTeamDetail = "/appointment/teamdetail";
    /**
     * 创建球队约战数据接收
     * 参数  stadium_id,stadium_name,address,gametime,playerset,cost,city_id,invite_team_id
     * user_id,token,sig
     */
    public static final String AppointmentTeamadd = "/appointment/teamadd";
    /**
     * 球队约战邀请球队
     * 参数  match_id ,team_id
     * user_id,token,sig
     */
    public static final String AppointmentTeamInvite = "/appointment/teaminvite";
    /**
     * 球队邀战处理
     * 参数  match_id ,memberset ,action
     * user_id,token,sig
     */
    public static final String AppointmentTeamInviteHandle = "/appointment/teaminvitehandle";
    /**
     * 球队主动申请约战
     * 参数  match_id ,memberset//member_user_id
     * user_id,token,sig
     */
    public static final String AppointmentTeamApply = "/appointment/teamapply";
    /**
     * 球队约战申请列表
     * 参数  match_id ,page
     * user_id,token,sig
     */
    public static final String AppointmentTeamApplyList = "/appointment/teamapplylist";
    /**
     * 球队约战申请处理
     * 参数  match_id ,match_apply_id ,action
     * user_id,token,sig
     */
    public static final String AppointmentTeamApplyHandle = "/appointment/teamapplyhandle";
    /**
     * 删除约战
     * 参数  match_id
     * user_id,token,sig
     */
    public static final String AppointmentDelete = "/appointment/delete";

    /***技术分和时间排名*/
    public static final String TeamApplyList = "/appointment/teamapplylist";
    //end region


    //region 球队
    /**
     * 创建球队
     * 参数 name ，logo ，playerset
     * user_id,token,sig
     */
    public static final String TeamCreate = "/team/create";
    /**
     * 球队信息
     * 参数  profile_team_id
     * user_id,token,sig
     */
    public static final String TeamProfile = "/team/profile";
    /**
     * 解散球队
     * 参数
     * user_id,token,sig
     */
    public static final String TeamDismiss = "/team/dismiss";
    /**
     * 添加成员
     * 参数  add_user_ids
     * user_id,token,sig
     */
    public static final String TeamAddMember = "/team/addmember";
    /**
     * 删除成员
     * 参数  del_user_ids
     * user_id,token,sig
     */
    public static final String TeamDelMember = "/team/delmember";
    /**
     * 邀请成员加入
     * 参数  invite_user_ids
     * user_id,token,sig
     */
    public static final String TeamInvite = "/team/invite";
    /**
     * 退出球队
     * 参数
     * user_id,token,sig
     */
    public static final String TeamQuit = "/team/quit";
    /**
     * 邀请事件处理
     * 参数  from_team_id ,action
     * user_id,token,sig
     */
    public static final String TeamInviteHandle = "/team/invitehandle";
    /**
     * 球队赛事
     * user_id,token,sig
     */
    public static final String TeamMatchList = "/team/matchlist";
    /**
     * 球队约战列表
     * user_id,token,sig
     */
    public static final String TeamAppointList = "/team/appointlist";
    /**
     * 赋予职位
     * 参数  offer_user_id ,type
     * user_id,token,sig
     */
    public static final String TeamOffer = "/team/offer";
    /**
     * 解雇职位
     * 参数  fire_user_id
     * user_id,token,sig
     */
    public static final String TeamFire = "/team/fire";
    /**
     * 关注球队
     * 参数 team_id
     * user_id,token,sig
     */
    public static final String TeamFollow = "/team/teamfollow";
    /**获取好友**/
    public static final String TeamPlayer = "/team/player";

    //end region


    //region 发现
    /**
     * 附近的队伍
     * 参数  city_id，lng，lat
     * user_id,token,sig
     */
    public static final String DiscoverTeam = "/discover/team";
    /**
     * 附近的人
     * 参数  city_id，lng，lat
     * user_id,token,sig
     */
    public static final String DiscoverUser = "/discover/user";
    //end region

    //region 订场
    /**
     * 球场
     * 参数  city_id, page
     */
    public static final String BookingStadium = "/booking/stadium";
    /**
     * 裁判
     * 参数  city_id, page
     */
    public static final String BookingJudge = "/booking/judge";
    /**
     * 足球宝贝
     * 参数  city_id, page
     */
    public static final String BookingCheer = "/booking/cheer";
    //end region


    //region 我的
    /***
     * 我的任务列表
     * 参数:user_id,token,sig*/
    public static final String MyTask ="/my/task";

    /**
     * 我的积分收入
     * 参数:user_id,token,sig**/
    public static final String ScoreIn = "/my/scorein";

    /***
     * 我的积分支出
     * 参数:user_id.token,sig**/
    public static final String ScoreOut = "/my/scoreout";


    /**
     * 我的胜负
     * 参数:user_id,token,sig*/
    public static final String WinLoss = "/my/winloss";

    /***
     * 我的技术分获得
     * 参数：user_id,token,sig**/
    public static final String TechnologyIn = "/my/technologyin";

    /**我的回复
     *参数：user_id,token,sig,page*/
    public static final String NoteReply = "/my/notereply";

    /**
     * @ 我的
     * 参数：user_id,token,sig,page*/
    public static final String NoteAt = "/my/noteat";

    /**点赞我的
     * 参数：user_id,token,sig,page**/
    public static final String NoteLike = "/my/notelike";

    /**人气分兑换技术分
     * 参数:user_id,token,num**/
    public static final String UserpoptoTec = "/my/userpoptotec";

    /**球队人气兑换技术分
     * 参数:user_id,token,num**/
    public static final String TeampoptoTec = "/my/teampoptotect";

    /**通过环信获取好友列表**/
    public static final String Chatlist = "/my/chatlist";

    /**
     * 刷新我的信息**/
    public static final String Polling = "/my/polling";

    /**
     * 创建单人聊天室
     * 参数:user_id,token,sig,user_ids*/
    public static final String CreateSingle = "/my/createsingleroom";

    /**
     * 创建多人聊天室
     * 参数:user_id,token,sig,user_ids**/
    public static final String CreateChatRoom = "/my/createusersroom";

    /**
     * 意见反馈
     * 参数:userid,token,sig,content*/
    public static final String FeedBack = "/my/feedback";

    /**
     * 手机号搜索id
     * 参数:userid,token,sig,moblie**/
    public static final String SearchUser = "/my/searchbymobile";

    /**
     * 聊天室添加成员**/
    public static final String AddMember = "/my/addroommembers";

    /**聊天室删除成员*/
    public static final String DelMemeber = "/my/minusroommembers";

    //end region

    //获取post请求URL
    public static String getRouterURL(String router) {
        return mainURL + router;
    }


    //获取post form
    public static FormBody getFormBody(String requestStr) {
        String signData = HttpApi.getSignString(requestStr);
//        Log.e("FormBody", requestStr);
//        Log.e("FormBody", signData);
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("code", requestStr)
                .add("sign", signData);
        return builder.build();
    }

    //签名
    public static String getSignString(String sign) {
        String signData = MD5.getMD5(sign) + randomKey;
//        signData = signData.toUpperCase();
        signData = MD5.getMD5(signData);

        return signData;
    }

    //获取图片完整url
    public static String getFullImageUrl(String imageUrl) {
        if (imageUrl == null)
            return "";
        if (imageUrl.contains("http://")) {
            return imageUrl;
        } else {
            return imageURL + "/" + imageUrl;
        }
    }

    public static String getFullImageUrl(String imageURL, boolean small) {
        if (imageURL == null) return "";
        String fullImageUrl = getFullImageUrl(imageURL);
        if (small) {
            fullImageUrl = fullImageUrl + "!/fwfh/300x300";
        }
        return fullImageUrl;
    }

    public static String limitString(String orgin){
        String str = "";

        return str;
    }

}
