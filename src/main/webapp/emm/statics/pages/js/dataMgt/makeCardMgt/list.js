var masterTypeMap;
var daughterTypeMap;
var statusMap;
var sexMap;

var userStation =top.userStation;
var orgCode = top.org.orgCode;
var orgName = top.org.orgName;

$(function () {
    selectList();
    initDicts();
    resetCondition();
});

function resetCondition() {
    com.ai.bdx.util.reset('searchForm');
    if (userStation == 'EMM_ADMIN') {
        com.ai.bdx.util.ztreeComp("orgNames", true, top.optionForMulti, callFuncForOrgNames);
    } else {
        $('#orgCodes').val(orgCode);
        $('#orgNames').val(orgName);
    }
    reloadGrid();
}
function callFuncForOrgNames(zTree) {
    var nodes = zTree.getCheckedNodes(true);
    var v = "";
    var n = "";
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i].orgCode + ",";
        n += nodes[i].orgName + ",";
    }
    if (v.length > 0) v = v.substring(0, v.length - 1);
    if (n.length > 0) n = n.substring(0, n.length - 1);
    $('#orgCodes').val(v);
    $('#orgNames').val(n);
}
function reloadGrid(){
    var data = $("#searchForm").serializeObject();
	$("#makeCard").jqGrid('setGridParam', {postData: data,page:1,pageSize:10}).trigger("reloadGrid");
}

//查询列表
function selectList() {
	var grid_selector = "#makeCard";
    var pager_selector = "#makeCard_pager";
    var data = $("#searchForm").serializeObject();
	$(grid_selector).jqGrid({
        url: GLOBAL.WEBROOT + "/makeCardDataMgt/queryMakeCardList.ajax",
        mtype : "post",
        datatype: "json",
        height: '100%',
        width : '100%',
        colNames: ['机构名称','机构编码','应用城市代码','发卡序列号', '卡号', '芯片序列号', '主卡类型','子卡类型','持卡人姓名','性别','身份证号','电话号码','地址','状态','序列号','压缩文件名','Txt文件名','接收地址','创建人','创建时间'],
        colModel: [
            {name: 'orgName', index: 'orgName', sortable: false,fixed:false,width:130,align:'center'},
            {name: 'orgCode', index: 'orgCode', sortable: false,align:'center',resizable:true,fixed:false ,width:80},
            {name: 'cityCode', index: 'cityCode', sortable: false,resizable:true,fixed:false,width:80,align:'center'},
            {name: 'cardSerial', index: 'cardSerial',  sortable: false,align:'center',resizable:true,fixed:false,width:150},
            {name: 'cardNo', index: 'cardNo', sortable: false,align:'center',resizable:true,fixed:false ,width:80},
            {name: 'chipSerial', index: 'chipSerial', sortable: false,width:100},
            {name: 'masterType', index: 'masterType',  sortable: false,align:'right' ,width:80,
                formatter: function (cellvalue, options, rowObject) {
                    if (masterTypeMap.containsKey(cellvalue)) {
                        return masterTypeMap.get(cellvalue);
                    }else{
                        return "";
                    }
                }
            },
            {name: 'daughterType', index: 'daughterType',  sortable: false,align:'right',width:80,
                formatter: function (cellvalue, options, rowObject) {
                    if (daughterTypeMap.containsKey(cellvalue)) {
                        return daughterTypeMap.get(cellvalue);
                    }else{
                        return "";
                    }
                }

            },
            {name: 'name', index: "name", sortable: false,align:'right',width:100},
            {name: 'sex', index: "sex", sortable: false,align:'right',width:80,
                formatter: function (cellvalue, options, rowObject) {
                    if (sexMap.containsKey(cellvalue)) {
                        return sexMap.get(cellvalue);
                    }else{
                        return "";
                    }
                }},
            {name: 'idNo', index: "idNo", sortable: false,align:'right',width:100},
            {name: 'phoneNo', index: "phoneNo", sortable: false,align:'right',width:100},
            {name: 'address', index: "address",  sortable: false,width:100,align:'center'},
            {name: 'status', index: "status",  sortable: false,width:100,align:'center',
                formatter: function (cellvalue, options, rowObject) {
                    if (statusMap.containsKey(cellvalue)) {
                        return statusMap.get(cellvalue);
                    }else{
                        return "";
                    }
                }
            },
            {name: 'id', index: "id",  sortable: false,width:100,align:'center'},
            {name: 'zipFileName', index: "zipFileName",  sortable: false,width:100,align:'center',
                formatter: function (cellvalue, options, rowObject) {
                    return  '<a class="blue" href="javascript:void(0)" onclick="dwlZipFile(\''+cellvalue+ '\',\''+cellvalue+ '\')"  title="下载"><i class="icon-download bigger-120"></i></a>' ;
                }
            },
            {name: 'txtFileName', index: "txtFileName",  sortable: false,width:100,align:'center'},
            {name: 'receiveAddr', index: "receiveAddr",  sortable: false,width:100,align:'center'},
            {name: 'creatorName', index: "creatorName",  sortable: false,width:100,align:'center'},
            {name: 'createTime', index: "createTime",  sortable: false,width:160,align:'center'}
        ],
        viewrecords: false,
        rowNum:10,
        rowList:[10,15,20,30],
        multiselect: false,
        multiboxonly: true,
        pager: pager_selector,
        altRows: true,
        loadComplete: function () {
            com.ai.bdx.util.updatePagerIcons(this);
        },
        autowidth: true
    }).jqGrid("navGrid",pager_selector,{refresh: true});
}

function afterProcessUpload(windowName){
    closeSubLayer(windowName);
    reloadGrid();
}

function closeSubLayer(name){
    var index = layer.getFrameIndex(name);
    layer.close(index);
}

function uploadFile(){
    layer.open({
        type: 2,
        title:"上传文件",
        area: ['700px', '600px'],
        fix: false, //不固定
        maxmin: true,
        content: GLOBAL.WEBROOT + "/makeCardDataMgt/page/uploadData.html",
        closeBtn:0
    });
}


function dwlZipFile(fileName,oldName){
    $("#oldName").val(oldName);
    $("#fileName").val(fileName);
    $("#dwlForm").attr("action" , GLOBAL.WEBROOT + "/common/downloadFile.ajax");
    $("#dwlForm").submit();
}

function initDicts() {

    $.ajax({
        type: "POST",
        async:false,
        data:{"masterType":"CARD_MAIN_TYPE","daughterType":"CARD_SUB_TYPE","status":"MAKE_CARD_STATUS","sex":"CARD_SEX"},
        datatype: "json",
        url: GLOBAL.WEBROOT + "/common/dictItem/getDictItemCondition.ajax",
        success: function (data) {
            var masterType = eval(data.masterType);
            masterTypeMap = new Map();
            for (var i = 0; i < masterType.length; i++) {
                masterTypeMap.put(masterType[i].itemNo,masterType[i].itemName);
            }

            var daughterType = eval(data.daughterType);
            daughterTypeMap = new Map();
            for (var i = 0; i < daughterType.length; i++) {
                daughterTypeMap.put(daughterType[i].itemNo,daughterType[i].itemName);
            }

            var status = eval(data.status);
            statusMap = new Map();
            for (var i = 0; i < status.length; i++) {
                statusMap.put(status[i].itemNo,status[i].itemName);
            }

            var sex = eval(data.sex);
            sexMap = new Map();
            for (var i = 0; i < sex.length; i++) {
                sexMap.put(sex[i].itemNo,sex[i].itemName);
            }
        }
    });
}
