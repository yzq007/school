<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>face door</title>
		<meta name="description" content="这是一个 index 页面">
		<meta name="keywords" content="index">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="icon" type="image/png" href="assets/i/icon.png">
		<link rel="apple-touch-icon-precomposed" href="assets/i/icon.png">
		<meta name="apple-mobile-web-app-title" content="Amaze UI" />
		<script src="assets/js/echarts.min.js"></script>
		<link rel="stylesheet" href="assets/css/amazeui.min.css" />
		<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
		<link rel="stylesheet" href="assets/css/app.css">
		<script src="assets/js/jquery.min.js"></script>
		<style type="text/css">
    	.backDoor
{
  background-color: lightgrey;
  position:relative;
  width:200px;
  height:300px;
  
  margin: 0 auto;
  margin-top:50px;
}

.door
{
  background-color: brown;
  position:absolute;
  top:0px;
  left:0px;
  width:200px;
  height:300px;
 
  transform-origin: left;
  /*Speed of the Door animation*/
  transition: all 0.5s ease-in-out;
}

.doorOpen
{
  /*prespectiv creates the door open effect*/
  transform: perspective(1200px) translateZ(0px) translateX(0px) translateY(0px) rotateY(-105deg);
}

    </style>
</head>
<body data-type="widgets">
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="javascript:;" style="line-height: 0;"><p style="font-size: 40px;font-family: Gabriola; position: relative;top: 10px;">face door</p></a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
                </div>
                <!-- 搜索 -->
                <div class="am-fl tpl-header-search">
                    <form class="tpl-header-search-form" action="javascript:;">
                        <button class="tpl-header-search-btn am-icon-search"></button>
                        <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
                    </form>
                </div>
                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <a href="javascript:;">欢迎你, <span>${login.name }</span> </a>
                        </li>

                        <!-- 新邮件 -->
                        <li class="am-dropdown tpl-dropdown" data-am-dropdown>
                            <a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>
                                <i class="am-icon-envelope"></i>
                                <span class="am-badge am-badge-success am-round item-feed-badge">4</span>
                            </a>
                            <!-- 弹出列表 -->
                            <ul class="am-dropdown-content tpl-dropdown-content">
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <div class="menu-messages-ico">
                                            <img src="${login.photo }" alt="">
                                        </div>
                                        <div class="menu-messages-time">
                                            3小时前
                                        </div>
                                        <div class="menu-messages-content">
                                            <div class="menu-messages-content-title">
                                                <i class="am-icon-circle-o am-text-success"></i>
                                                <span>雯欣雨</span>
                                            </div>
                                            <div class="am-text-truncate">在小区门口捡到一把钥匙 </div>
                                            <div class="menu-messages-content-time">2018-4-17 下午 16:40</div>
                                        </div>
                                    </a>
                                </li>

                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <div class="menu-messages-ico">
                                            <img src="assets/img/user02.png" alt="">
                                        </div>
                                        <div class="menu-messages-time">
                                            5天前
                                        </div>
                                        <div class="menu-messages-content">
                                            <div class="menu-messages-content-title">
                                                <i class="am-icon-circle-o am-text-warning"></i>
                                                <span>可一琳</span>
                                            </div>
                                            <div class="am-text-truncate">小区保安素质差</div>
                                            <div class="menu-messages-content-time">2018-4-20 上午 09:23</div>
                                        </div>
                                    </a>
                                </li>
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="feedback.jsp" class="tpl-dropdown-menu-messages-item am-cf">
                                        <i class="am-icon-circle-o"></i> 进入列表…
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <!-- 新提示 -->
                        <li class="am-dropdown" data-am-dropdown>
                            <a href="javascript:;" class="am-dropdown-toggle" data-am-dropdown-toggle>
                                <i class="am-icon-bell"></i>
                                <span class="am-badge am-badge-warning am-round item-feed-badge">5</span>
                            </a>

                            <!-- 弹出列表 -->
                            <ul class="am-dropdown-content tpl-dropdown-content">
                                <li class="tpl-dropdown-menu-notifications">
                                    <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                        <div class="tpl-dropdown-menu-notifications-title">
                                            <i class="am-icon-star"></i>
                                            <span> 欧蓝逞申请在2018-04-07~2018-04-08内访问</span>
                                        </div>
                                        <div class="tpl-dropdown-menu-notifications-time">
                                            12分钟前
                                        </div>
                                    </a>
                                </li>
                                <li class="tpl-dropdown-menu-notifications">
                                    <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                        <div class="tpl-dropdown-menu-notifications-title">
                                            <i class="am-icon-star"></i>
                                            <span> 欧蓝逞申请在2018-04-07~2018-04-08内访问</span>
                                        </div>
                                        <div class="tpl-dropdown-menu-notifications-time">
                                            12分钟前
                                        </div>
                                    </a>
                                </li>
                                <li class="tpl-dropdown-menu-notifications">
                                    <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                        <div class="tpl-dropdown-menu-notifications-title">
                                        	<i class="am-icon-star"></i>
                                            <span> 欧蓝逞申请在2018-04-07~2018-04-08内访问</span>
                                        </div>
                                        <div class="tpl-dropdown-menu-notifications-time">
                                            12分钟前
                                        </div>
                                    </a>
                                </li>


                                <li class="tpl-dropdown-menu-notifications">
                                    <a href="form.jsp" class="tpl-dropdown-menu-notifications-item am-cf">
                                        <i class="am-icon-bell"></i> 进入列表…
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="login.jsp">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="${login.photo }" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              ${login.name }
          </span>
                    <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>


            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-link">
                    <a href="index.jsp">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 小区概况
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="tables.jsp">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 通行记录
                    </a>
                </li>
               <li class="sidebar-nav-link">
						<a href="javascript:;" class="sidebar-nav-sub-title">
							<i class="am-icon-table sidebar-nav-link-logo"></i> 人员注册
							<span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
						</a>
						<ul class="sidebar-nav sidebar-nav-sub">							
							<li class="sidebar-nav-link">
								<a href="calendar.jsp">
									<span class="am-icon-angle-right sidebar-nav-link-logo am-icon-calendar"></span> 业主
								</a>
							</li>

							<li class="sidebar-nav-link">
								<a href="calendar-visitor.jsp">
									<span class="am-icon-angle-right sidebar-nav-link-logo am-icon-calendar"></span> 访客
								</a>
							</li>
						</ul>
					</li>
               <li class="sidebar-nav-link">
                    <a href="/Face-AI/avtransferServlet" >
                        <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 申请
						<span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm"></span>
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 人员管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="table-list.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 物业
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/Face-AI/otransferServlet">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 业主
                            </a>
                        </li>
                        
                        <li class="sidebar-nav-link">
                            <a href="/Face-AI/vtransferServlet">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 访客
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="door.jsp" class="active">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 门禁
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="feedback.jsp">
                        <i class="am-icon-tv sidebar-nav-link-logo"></i> 反馈
                    </a>
                </li>

            </ul>
        </div>



        <!-- 内容区域 -->
      <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                        	<div class="backDoor">
  								<div class="door"> 
  								</div>
							</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script type="text/javascript">
var door=document.querySelector(".door");
door.addEventListener("click",function(){
	door.classList.toggle('doorOpen');
})
    </script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.datatables.min.js"></script>
    <script src="assets/js/dataTables.responsive.min.js"></script>
    <script src="assets/js/app.js"></script>

</body>
</html>