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
		input[type="button"] {
	transition: all .3s;
    border: 1px solid #ddd;
    padding: 6px 12px;
    text-decoration: none;
    border-radius: 4px;
	font-size: 15px;
	margin-left: 10px;
	position: relative;
	left: 73.3%;
}
/*
input[type="button"]:not(.active) {
	background-color:transparent;
	color: #23abf0;border: 1px solid #23abf0;
}

.active {
	background-color: #23abf0;
	
	color :#fff;
}

input[type="button"]:hover:not(.active) {
	background-color: #ddd;
}*/
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
                    <a href="javascript:;" class="sidebar-nav-sub-title active">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 人员管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                        <li class="sidebar-nav-link">
                            <a href="table-list.jsp" class="sub-active">
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
                    <a href="door.jsp">
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
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">物业人员</div>


                            </div>
                            <div class="widget-body  am-fr">
<!--
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group" style="opacity: 0;">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select data-am-selected="{btnSize: 'sm'}">
							              <option value="option1">所有类别</option>
							              <option value="option2">姓名</option>
							              <option value="option3">职务</option>
							              <option value="option3">联系方式</option>
							            </select>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
								            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
								          </span>
                                    </div>
                                </div>
-->
                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="myTable">
                                        <thead>
                                            <tr>
                                                <th width="25%">姓名</th>
                                                <th width="25%">职务</th>
                                                <th width="25%">联系方式</th>
                                                <th width="25%">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="gradeX">
                                                <td>张鹏飞</td>
                                                <td>总经理</td>
                                                <td>18500315771</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i>  <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="even gradeC">
                                                <td>莫羡</td>
                                                <td>项目经理</td>
                                                <td>16619732847</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i> <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="gradeX">
                                                <td>程灵素</td>
                                                <td>经理</td>
                                                <td>18518525475</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i> <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="even gradeC">
                                                <td>展信佳</td>
                                                <td>主管</td>
                                                <td>17601045702</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i>  <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="even gradeC">
                                                <td>白慕杨</td>
                                                <td>班长</td>
                                                <td>17621845027</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i>  <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>

                                            <tr class="even gradeC">
                                                <td>阮红妆</td>
                                                <td>客服</td>
                                                <td>16621018924</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a class="edit"  href="javascript:;" data-time="1">
                                                            <i class="am-icon-pencil"></i> <span>编辑</span>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del delete">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.datatables.min.js"></script>
    <script src="assets/js/dataTables.responsive.min.js"></script>
    <script src="assets/js/app.js"></script>
	<script type="text/javascript">
		var $table = document.getElementById("myTable"),
// number of rows per page
$n = 10,
// number of rows of the table
$rowCount = $table.rows.length,
// get the first cell's tag name (in the first row)
$firstRow = $table.rows[0].firstElementChild.tagName,
// boolean var to check if table has a head row
$hasHead = ($firstRow === "TH"),
// an array to hold each row
$tr = [],
// loop counters, to start count from rows[1] (2nd row) if the first row has a head tag
$i,$ii,$j = ($hasHead)?1:0,
// holds the first row if it has a (<TH>) & nothing if (<TD>)
$th = ($hasHead?$table.rows[(0)].outerHTML:"");
// count the number of pages
var $pageCount = Math.ceil($rowCount / $n);
// if we had one page only, then we have nothing to do ..
if ($pageCount > 1) {
	// assign each row outHTML (tag name & innerHTML) to the array
	for ($i = $j,$ii = 0; $i < $rowCount; $i++, $ii++)
		$tr[$ii] = $table.rows[$i].outerHTML;
	// create a div block to hold the buttons
	$table.insertAdjacentHTML("afterend","<div id='buttons'></div");
	// the first sort, default page is the first one
	sort(1);
}

// ($p) is the selected page number. it will be generated when a user clicks a button
function sort($p) {
	/* create ($rows) a variable to hold the group of rows
	** to be displayed on the selected page,
	** ($s) the start point .. the first row in each page, Do The Math
	*/
	var $rows = $th,$s = (($n * $p)-$n);
	for ($i = $s; $i < ($s+$n) && $i < $tr.length; $i++)
		$rows += $tr[$i];
	
	// now the table has a processed group of rows ..
	$table.innerHTML = $rows;
	// create the pagination buttons
	document.getElementById("buttons").innerHTML = pageButtons($pageCount,$p);
	// CSS Stuff
	document.getElementById("id"+$p).setAttribute("class","active");
}


// ($pCount) : number of pages,($cur) : current page, the selected one ..
function pageButtons($pCount,$cur) {
	/* this variables will disable the "Prev" button on 1st page
	   and "next" button on the last one */
	var	$prevDis = ($cur == 1)?"disabled":"",
		$nextDis = ($cur == $pCount)?"disabled":"",
		/* this ($buttons) will hold every single button needed
		** it will creates each button and sets the onclick attribute
		** to the "sort" function with a special ($p) number..
		*/
		$buttons = "<input type='button' value='«' onclick='sort("+($cur - 1)+")' "+$prevDis+">";
	for ($i=1; $i<=$pCount;$i++)
		$buttons += "<input type='button' id='id"+$i+"'value='"+$i+"' onclick='sort("+$i+")'>";
	$buttons += "<input type='button' value='»' onclick='sort("+($cur + 1)+")' "+$nextDis+">";
	return $buttons;
}
$(".edit").click(function() {
	var index = $(".edit").index(this);
	var b = $(".edit").eq(index).attr("data-time");
	if(b == "2") {
		//alert(b);
		$(this).parent().parent().parent().find("td:lt(3)").addClass('active');
		$(this).parent().parent().parent().find("td:nth-child(4) span").html('编辑');
		$(this).parent().parent().parent().find("td:lt(3)").attr("contenteditable", false);
		$(".edit").eq(index).attr("data-time", 1);
		
	} else {
		//alert(b);
		console.log("2");
		$(this).parent().parent().parent().find("td:lt(3)").attr("contenteditable", true);
		$(this).parent().parent().parent().find("td:lt(3)").addClass('active');
		$(this).parent().parent().parent().find("td:nth-child(4) span").html('保存');
		$(".edit").eq(index).attr("data-time", 2);
	}
});
$(".delete").click(function() {
	
	
	$(this).parent().parent().parent().remove();
	
});
	</script>
</body>

</html>