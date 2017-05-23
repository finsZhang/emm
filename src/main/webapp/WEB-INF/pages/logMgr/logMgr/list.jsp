<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="cache-control" content="no-cache">
    <%@ include file="/common/meta.jsp" %>
    <title>日志管理</title>

    <link rel="stylesheet" href="${ctx}/emm/statics/common/plugins/ztree/css/zTreeStyle/zTreeStyle.css"
          type="text/css">
    <link rel="stylesheet" href="${ctx}/emm/statics/common/plugins/ztree/css/selectTree.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/emm/statics/common/css/execute.css" type="text/css">

    <script type="text/javascript" src="${ctx}/emm/statics/common/js/jquery-easyui/jquery.easyui.min.js"></script>
    <link type="text/css" rel="stylesheet"
          href="${ctx}/emm/statics/common/js/jquery-easyui/themes/default/easyui.css"/>
    <script type="text/javascript" src="${ctx}/emm/statics/common/plugins/date/WdatePicker.js"></script>
    <script type="text/javascript" src="${ctx}/emm/statics/common/plugins/ztree/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript"
            src="${ctx}/emm/statics/common/plugins/ztree/js/jquery.ztree.excheck-3.5.js"></script>
    <script type="text/javascript"
            src="${ctx}/emm/statics/common/plugins/ztree/js/jquery.ztree.exedit-3.5.js"></script>

    <script type="text/javascript" src="${ctx}/emm/statics/ace/plugins/jqGrid/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${ctx}/emm/statics/ace/plugins/jqGrid/grid.locale-cn.js"></script>
    <script type="text/javascript" src="${ctx}/emm/statics/pages/js/logMgr/logMgr/list.js?_dc=${staticVersion}"></script>
    <script type="text/javascript"
            src="${ctx}/emm/statics/common/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <style type="text/css">

    </style>
</head>
<body width="100%" height="100%">
<div class="wrap100 quickrecharge">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try {
                ace.settings.check('breadcrumbs', 'fixed')
            } catch (e) {
            }
        </script>

        <ul class="breadcrumb" style="margin-top: 8px;">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="${ctx}/logMgr/page/list.html">日志管理</a>
            </li>
            <li class="active">用卡操作日志管理</li>
        </ul>
        <!-- .breadcrumb -->
    </div>
    <div class="q_r_list" style="width:98%; ">
        <!--交易记录查询条件 begin-->
        <div class="listTable">
            <form id="searchForm" action="#">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <th width="13%" class="r">姓名：</th>
                        <td width="13%">
                            <input name="cardName" id="cardName" class="inputW160"/>
                        </td>
                        <th width="13%" class="r">卡号：</th>
                        <td width="13%">
                            <input name="cardNo" id="cardNo" class="inputW160"/>
                        </td>
                        <th width="13%" class="r">身份证号：</th>
                        <td width="13%">
                            <input name="idNo" id="idNo" class="inputW600"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="r">业务类型：</th>
                        <td><label></label>
                            <select name="businessType" id="businessType">
                                <option value="-1">请选择业务类型</option>
                            </select></td>
                        <th class="r">操作状态：</th>
                        <td><label></label>
                            <select name="operateStatus" id="operateStatus">
                                <option value="-1">请选择操作状态</option>
                            </select></td>
                        <th class="r" width="11%">所属机构：</th>
                        <td width="10%">
                            <input id="orgNames" type="text" readonly value="" class="select"
                                   name="orgNames"/>
                            <input id="orgCodes" type="hidden" readonly name="orgCodes"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="r" width="12%">查询时间段：</th>
                        <td width="50%">
                            <input id="startOperateDate" name="startOperateDate" class="inputW180"
                                   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                            -
                            <input id="endOperateDate" name="endOperateDate" class="inputW180"
                                   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                        </td>
                    </tr>
                </table>
            </form>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th class="r n_b_b">&nbsp;</th>
                    <td class="n_b_b">&nbsp;</td>
                    <th class="r n_b_b">&nbsp;</th>
                    <th colspan="3" class="r n_b_b">
                        <a href="javascript:void(0)" onclick="reloadGrid();"
                           class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-success"><span
                                class="icon-search"></span>查 询</a>
                        <a href="javascript:void(0)" onclick="resetCondition()"
                           class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-gray"><span
                                class="icon-retweet"></span>重 置</a>
                    </th>
                </tr>
            </table>
        </div>
        <!--交易记录查询条件 end-->
        <div>
            <table id="makeCard" width="100%" border="0" cellspacing="0" cellpadding="0">

            </table>
            <div id="makeCard_pager"></div>
        </div>
    </div>
</div>
</body>
</html>