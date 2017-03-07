/*function formElements(data,formName){
    for(var i = 0; i < data.rows.length; i++){
        var columnNumber = data.rows[i].columnNumber;
        if(columnNumber%2!=0)
        continue;
        if(columnNumber==data.rows.length){
            showFormElements(formName,data.rows[columnNumber-1].configColumnId,data.rows[columnNumber-1].columnNameAlias,false);
            //alert("最后一个："+data.rows[columnNumber-1].configColumnId+"\n"+data.rows[columnNumber-1].columnNameAlias);
        }else{
            showFormElements(formName,data.rows[columnNumber-1].configColumnId,data.rows[columnNumber-1].columnNameAlias,true,data.rows[columnNumber].columnNameAlias,data.rows[columnNumber].configColumnId);
           // alert("其他的："+data.rows[columnNumber-1].configColumnId+"\n"+data.rows[columnNumber-1].columnNameAlias+"\n"+data.rows[columnNumber].columnNameAlias);
            //showFormElements(data,formName);
        }
        //showFormElements(data,formName);
    }

}




function showFormElements(formName,value1,text1,flag,value2,text2,i){
    alert(value1+'/n'+text1+'/n'+value2+'/n'+text2);
    var s = '<div class="row" >'+
        '<div id="div1"  class="col-md-6" style="margin-bottom:10px">' +
        '<div class="col-md-4 tdAlign">' +
        '<label >' + text1 + '</label>' +
        '</div>' +
        '<div class="col-md-8">' +
        '<input type="text" class="k-textbox" id="' + value1 + '"  data-bind="value:model.' + value1 + '" style="width: 70%" >' +
        '</div>' +
        '</div>';
    if (flag) {
        s += '<div id="div1"  class="col-md-6" style="margin-bottom:10px">'+
            '<div class="col-md-4 tdAlign">'+
            '<label >' + value2 + '</label>'+
            '</div>' +
            '<div class="col-md-8">' +
            '<input type="text" class="k-textbox" id="' + text2 + '"  data-bind="value:model.' + text2 + '" style="width: 70%" >' +
            '</div>' +
            '</div>'+
            '</div>';
    }else{
        s += '</div>';
    }
    $("#" + formName).append(s);


}*/

/**
 * 根据后台json动态拼接
 * author  hufuchun 2017年3月7日 09:43:40
 * @param data
 * @param formName
 */
function showFormElements(data,formName) {

    //循环当前行div，加在当前行div中
    for (var i = 0; i < data.rows.length; i++) {

        if (data.rows[i].columnStyle == "TEXT")//text
        {
            $("#" + formName).append(
                '<div id="div1" class="col-sm-6" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input class="k-textbox" id="'+ data.rows[i].columnNameAlias+'"' +
                'name="'+ data.rows[i].columnNameAlias+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].columnNameAlias+'" style="width: 70%;" />'+
               '</div>'+
                '<div  style="margin-left:52%">'+
                '<span data-for="'+ data.rows[i].columnNameAlias+'" class=".k-invalid-msg"></span>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }else if(data.rows[i].columnStyle == "DECIMAL"){  //DECIMAL
            $("#" + formName).append(
                '<div id="div1" class="col-sm-6" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input onblur="validateNumber(this)" class="k-textbox" id="'+ data.rows[i].columnNameAlias+'"' +
                'name="'+ data.rows[i].columnNameAlias+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].columnNameAlias+'" style="width: 70%;" />'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }
        /*else if(data.rows[i].columnStyle=="LIST")//combobox
         {
         $("#" + formName).append('<div class="col-md-6" style="margin-bottom:10px">' +
         '<div class="col-md-4 tdAlign">' +
         '<label >'+data.rows[i].columnNameAlias+'</label>' +
         '</div>' +
         '<div class="col-md-8">' +
         '<input type="text" class="k-textbox" id="'+data.rows[i].columnNameAlias+'" name="'+data.rows[i].columnNameAlias+'" style="width: 70%;" data-bind="value:model.'+data.rows[i].columnNameAlias+'"/>' +
         '</div>' +
         '</div>');
         // showComboboxs(data.rows[i],null);
         }
         else if(data.rows[i].columnStyle=="DATE")//Date
         {
         var $str=$beforeStr;
         $str+="<input  id="+data.rows[i].columnNameAlias+" style='width:"+data.rows[i].columnNameAlias+"px;height:28px;vertical-align:middle;margin-left:8px'/>";
         $str+=$afterStr;
         $("#row"+rowNum).append($str);
         showDate(data.rows[i],null);
         }
         else if(data.rows[i].formElement=="TIME")//Time
         {
         var $str=$beforeStr;
         $str+="<input id="+data.rows[i].paramsName+" style='width:"+data.rows[i].showWidth+"px;vertical-align:middle;margin-left:8px'/>";
         $str+=$afterStr;
         $("#row"+rowNum).append($str);
         showTime(data.rows[i],null);
         }
         }*/

    }
}

//校验输入框内只能输入小数
function validateNumber(self){
    var reg =/^\d+\.\d+$/;

    if (! reg.test(self.value)) {
        kendo.ui.showErrorDialog({
            message: "只能输入小数"
        }).done(function (e) {
            self.value= "";
        })
    }
}

/*function showComboboxs(data,defaultValue)
 {
 var dataSource=[];
 dataSource=getContentSource(data.trxDetailId);
 $("#"+data.formCode).kendoComboBox({
 dataTextField: "detailTrxTypeName",
 dataValueField: "trxDetailId",
 filter: "contains",
 dataSource: dataSource
 });
 }*/
function showDate(data, defaultValue) {
    //设置默认值
    var code = GetQueryString("code");
    var header = getHeader(code);
    var dsId = header.dsId;
    var paramId = param.queryParamsId;
    var defaultValues = [];
    // var defaultValue="";
    var defaultType = param.defaultType;
    if (defaultValue != null) {
    }
    else if (param.defaultValue == "" || param.defaultValue == null) {
        defaultValue = new Date();
    }
    else {
        if (defaultType == "SQL") {
            defaultValues = getSqlDefaultValue(paramId, dsId);
            if (defaultValues.length != undefined && defaultValues.length > 0) {
                defaultValue = new Date(defaultValues[0].id);
            }
        }
        else if (defaultType == "STRING") {
            defaultValue = new Date(param.defaultValue);
        }
    }
    $("#" + param.paramsName).kendoDatePicker({
        culture: "zh-CN",
        format: "yyyy-MM-dd",
        value: defaultValue
    });
}

//获取url参数
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var search = window.location.search;
    search = decodeURI(search);
    var r = search.substr(1).match(reg);
    if (r != null)return unescape(r[2]);
    return null;
}

//获取header
function getHeader(code) {
    var headerInformation = getHeaderInformation(code);
    if (headerInformation.success == false) {
        kendo.ui.showInfoDialog({
            message: headerInformation.message
        });
        return null;
    }
    else {
        var headers = headerInformation.rows;
        var header = headers[0];
        return header;
    }
}


function getContentSource(trxDetailId) {
    var dataSource = [];
    $.ajax({
        url: _basePath + "/task/taskOrder/trxDetailQuery",
        type: 'POST',
        data: {
            "trxDetailId": trxDetailId
        },
        async: false,
        success: function (data) {
            if (data.success) {
                dataSource = data.rows;
            }
            else {
                kendo.ui.showInfoDialog({
                    message: data.message
                });
                dataSource = [];
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            kendo.ui.showInfoDialog({
                message: error
            })
        }
    });
    return dataSource;
}

