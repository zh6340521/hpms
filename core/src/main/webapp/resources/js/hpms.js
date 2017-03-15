
/**
 * 查询建筑类型下对应的字段
 * @param configValueId
 * @param configId
 * @author  fuchun.hu@hand-china.com 2017年3月7日 09:43:40
 */
function findConfigColumn(configValueId,configId,formName,viewModel){
    $.ajax({
        url: _basePath+"/bs/configcolumn/queryByCache?configValueId="+configValueId+'&configId='+configId,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        success: function (args) {

            //判断是否渲染了后台div
            /*var node = document.getElementById('div1');
            if(node!=null){
                //如果已存在渲染div,切换时将div清除
                $("div#div1").remove();

            }*/



            //调用js 根据行号进行分组
            //showFormElements(args,formName,viewModel);
            findFormElementsBydisplayLineNo(args,formName,viewModel,configValueId,configId);

        },

    });
}



/**
 * 根据前台输入的字段行号分组
 * @author  fuchun.hu@hand-china.com  2017年3月14日 10:48:48
 * @param data
 * @param formName
 * @param viewModel
 */
function findFormElementsBydisplayLineNo(data,formName,viewModel,configValueId,configId){
 var displayLineNos =[];
 for(var m=0;m<data.rows.length;m++){
     displayLineNos.push(data.rows[m].displayLineNo);
 }

 var str1=[];
        for(i=0;i<displayLineNos.length;i++){
            if(str1.indexOf(displayLineNos[i])<0){
                str1.push(displayLineNos[i])
            }
        }



    //alert(displayLineNos);

    for (var i = 0; i < data.rows.length; i++) {
        //alert(data.rows[i].configValueId+"____________"+data.rows[i].configId+"______________"+data.rows[i].displayLineNo);
//alert(data.rows[i].displayLineNo);

        $.ajax({
            url: _basePath+"/bs/configcolumn/queryDataByCache?configValueId="+configValueId+'&configId='+configId+'&displayLineNo='+str1,
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            success: function (args) {

                //判断是否渲染了后台div
                var node = document.getElementById('div1');
                if(node!=null){
                    //如果已存在渲染div,切换时将div清除
                    $("div#div1").remove();
                    //node.parentNode.removeChild(node);
                }
                //     viewModel.get("buildType");

                //调用js
                showFormElements(args,formName,viewModel);


            },

        });
    }

}



/**
 * 根据后台json动态拼接
 * @author fuchun.hu@hand-china.com 2017年3月7日 09:43:40
 * @param data
 * @param formName
 */
function showFormElements(data,formName,viewModel) {

   // alert(12/datacount);
    //循环当前行div，加在当前行div中
    for (var i = 0; i < data.rows.length; i++) {

        if (data.rows[i].columnStyle == "TEXT")//text
        {
           // alert(data.rows[i].columnLength);
           // var vaildateMessage = data.rows[i].vaildateMessage;
            $("#" + formName).append(

                '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input onblur="validateLength('+data.rows[i].vaildateMessage +','+data.rows[i].columnLength+',this)" class="k-textbox" id="'+ data.rows[i].columnId+'"' +
                'name="'+ data.rows[i].configColumnId+'"  data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;" />'+
                '</div>'+
                '<div  style="margin-left:52%">'+
                '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                '</div>'+
                '</div>'+
                '</div>'




        );
        }else if(data.rows[i].columnStyle == "DECIMAL")//只能输入小数
        {
            $("#" + formName).append(
                '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input onblur="validateDecimal('+data.rows[i].vaildateMessage +','+data.rows[i].columnLength+',this)" class="k-textbox" id="'+ data.rows[i].columnId+'"' +
                'name="'+ data.rows[i].configColumnId+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;" />'+
                '</div>'+
                '<div  style="margin-left:52%">'+
                '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }else if(data.rows[i].columnStyle == "NUMBER") //只能输入整数
        {
            $("#" + formName).append(
                '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input onblur="validateNumber('+data.rows[i].vaildateMessage +','+data.rows[i].columnLength+',this)" class="k-textbox" id="'+ data.rows[i].columnId+'"' +
                'name="'+ data.rows[i].configColumnId+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;" />'+
                '</div>'+
                '<div  style="margin-left:52%">'+
                '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }
        else if(data.rows[i].columnStyle == "DATE")  //日期格式
        {

            $("#" + formName).append(
                '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                '<div class="form-group">' +
                '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                '<div class="col-sm-7">'+
                '<input onblur="vaildateRequired('+data.rows[i].vaildateMessage +',this)"  id="'+ data.rows[i].columnId+'"' +
                'name="'+ data.rows[i].configColumnId+'"  data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;" />'+
                '<script type="text/javascript">'+
                '$("#"+"'+ data.rows[i].columnId+'").kendoDatePicker({ format : "yyyy-MM-dd"});'+
                '</script>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }
        else if(data.rows[i].columnStyle == "LIST")  //下拉框
        {
            //当sqlId不为空且没有级联时，只解析sqlId
            if(data.rows[i].sqlId!=null&&data.rows[i].cascadeFrom==null){

              //  alert(data.rows[i].columnId);
                $("#" + formName).append(
                    '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                    '<div class="col-sm-7">'+
                    '<input name="'+data.rows[i].columnId+'"   id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;"/>'+


                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                    'valuePrimitive: true,'+
                    'dataTextField: "'+data.rows[i].dataTextField+'",'+
                    'dataValueField: "'+data.rows[i].dataValueField+'",'+
                    'dataSource: {'+
                    'transport: {'+
                    ' read:function(options) {'+
                    ' $.ajax({'+
                    ' type   : "POST",'+
                    ' url: "'+_basePath+'/configcolumn/code/queryBySqlId?configColumnId='+data.rows[i].configColumnId+'",'+

                    'success: function(json) { options.success(json.rows);}'+
                    '});'+
                    '}'+
                    '}'+
                    '},'+
                    'select:function(e){'+
                     'v=e.sender.dataItem(e.item)[e.sender.options.dataValueField]' +
                     '}'+
                    ' });'+

                    '</script>'+
                    '</div>'+
                    '</div>'+
                    '</div>'

                );
            }
            //拼接code
            if(data.rows[i].sysCode!=null){
                $("#" + formName).append(
                    '<script src="'+_basePath+'/common/code?codeData='+data.rows[i].sysCode+'" type="text/javascript"></script>'+
                    '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                    '<div class="col-sm-7">'+
                    '<input onblur="vaildateRequired('+data.rows[i].vaildateMessage +',this)" id="'+ data.rows[i].columnId+'"  data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;"/>'+

                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                    'valuePrimitive: true,'+
                    'dataTextField: "meaning",'+
                    'dataValueField: "value",'+
                    'dataSource:codeData ,'+
                    ' });'+

                    '</script>'+
                    '</div>'+
                    '<div  style="margin-left:52%">'+
                    '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                    '</div>'+
                    '</div>'+
                    '</div>'
                );
            }

            //级联下拉框
            if(data.rows[i].cascadeFrom!=null&&data.rows[i].sqlId!=null){
                var cascadeFrom=data.rows[i].cascadeFrom;
                //alert(cascadeFrom);

                $("#" + formName).append(
                    '<div id="div1" class="col-sm-'+data.rows[i].dataLength+'" style="margin-bottom: 5px;">'+
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                    '<div class="col-sm-7">'+
                    '<input id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].configColumnId+'" style="width: 70%;"/>'+

                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                    'autoBind: false,'+
                    ' filter: "contains",'+
                    'cascadeFrom: "'+data.rows[i].cascadeFrom+'",'+
                    'valuePrimitive: true,'+
                    'dataTextField: "'+data.rows[i].dataTextField+'",'+
                    'dataValueField: "'+data.rows[i].dataValueField+'",'+

                    'dataSource: {'+
                    'serverFiltering:true,'+
                    'transport: {'+
                     'read: {'+
                    ' url: "'+_basePath+'/configcolumn/code/queryBySqlId?configColumnId='+data.rows[i].configColumnId+'",'+
                      'type : "POST"'+
                    '},'+
                    'contentType : "application/json",'+
                        ' parameterMap: function(options, type) {'+
                    'if (type === "read") {'+
                    'var filter = options.filter.filters[0];'+
                    'var map = {};'+
                        'map[filter.field] = filter.value;'+
                    'return map;'+
                    ' }'+
                    ' }'+
                    ' },'+
                        ' schema: {'+
                        ' data: "rows"'+
                    '}'+

                    '},'+
                    ' });'+

                    '</script>'+
                    '</div>'+
                    '</div>'+
                    '</div>'

                );
            }
        }

    }
}

//校验输入框内只能输入小数
function validateDecimal(validatemessage,columnLength,self){
    var reg =/^\d+\.\d+$/;

    if (! reg.test(self.value)&&(self.value!="")) {
        kendo.ui.showErrorDialog({
            message: "只能输入小数"
        }).done(function (e) {
            self.value= "";
        })
    }

    //限制字段输入长度和是否必输
    validateLength(validatemessage,columnLength,self);


}

//校验输入框内只能输入整数
function validateNumber(validatemessage,columnLength,self){
    var reg =/^[0-9]*[1-9][0-9]*$/;

    if (! reg.test(self.value)&&(self.value!="")) {
        kendo.ui.showErrorDialog({
            message: "只能输入整数"
        }).done(function (e) {
            self.value= "";
        })
    }

    //限制字段输入长度和是否必输
    validateLength(validatemessage,columnLength,self);
}

//限制字段输入长度和是否必输
function validateLength(validatemessage,columnLength,self){
    //当传入的参数为1时，表示必输
    if(validatemessage=="1"&&(self.value=="")){
        kendo.ui.showErrorDialog({
            message:"必输！"
        })
    }

    //当输入的长度大于数据库限定的长度时，弹出错误提示
    if(self.value.length>columnLength){
        kendo.ui.showErrorDialog({
            message:"只能输入"+columnLength+"位有效长度!"
        }).done(function (e) {
            self.value= "";
        })
    }

}

//校验是否必输
function vaildateRequired(validatemessage,self){
    //当传入的参数为1时，表示必输
    if(validatemessage=="1"&&(self.value=="")){
        kendo.ui.showErrorDialog({
            message:"必输！"
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


