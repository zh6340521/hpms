/**
 * 在【建筑档案】界面点击查看或者编辑时 触发的方法
 * @param formName
 * @param viewModel
 * @param propertyId
 */
function showProperty(formName,viewModel,propertyId,isview){

    $.ajax({
        url: _basePath+"/mdm/property/showproperty?propertyId="+propertyId,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        success: function (args) {

            if(args.success==true){
                showPropertyElements(args,formName,viewModel,isview);
            }


        },

    });
}

/**
 * 动态渲染出建筑档案的字段
 * @param data
 * @param formName
 * @param viewModel
 */
function showPropertyElements(data,formName,viewModel,isview){

    //只查看
   if(isview=="1"){
       for (var i = 0; i < data.rows.length; i++) {
          /* $("#" + formName).append(
               '<div id="div1" class="col-md-6" style="margin-top:5px">'+
               '<div class="col-md-4 tdAlign">'+
               '<label >' + data.rows[i].columnNameAlias + '</label>'+
               '</div>'+
               '<div class="col-md-8">'+
               '<input  disabled="disabled"  class="k-textbox"  id="' + data.rows[i].columnId + '"   style="width: 70%; background-color:#DDDDDD" value="'+viewModel.model.get(data.rows[i].columnId)+'" />'+

               '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
               '</div>'+
               '</div>'


           );*/
           ViewConfigColumn(data.rows[i].configValueId,data.rows[i].configId,formName,viewModel);
       }
   }


    //编辑
    if(isview=="2"){
       // showFormElements(data,formName,viewModel);
        for (var i = 0; i < data.rows.length; i++) {
            //编辑时，直接调用该行号下的列的信息
            findConfigColumn(data.rows[i].configValueId,data.rows[i].configId,formName,viewModel);
        }
    }

}

/**
 * 点击查看时调用的方法  先查询该建筑类型下所有的字段
 * @param configValueId
 * @param configId
 * @param formName
 * @param viewModel
 * @constructor
 */
function ViewConfigColumn(configValueId,configId,formName,viewModel){
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

            if(args.success==true){
                //调用js 根据行号进行分组
                //showFormElements(args,formName,viewModel);
                ViewFormElementsBydisplayLineNo(args,formName,viewModel,configValueId,configId);
            }else{
                var node = document.getElementById('div1');
                if(node!=null){
                    //如果已存在渲染div,切换时将div清除
                    $("div#div1").remove();
                    //node.parentNode.removeChild(node);
                }
            }


        },

    });
}

/**
 * 按行号进行分组
 * @param args
 * @param formName
 * @param viewModel
 * @param configValueId
 * @param configId
 * @constructor
 */
function ViewFormElementsBydisplayLineNo(data,formName,viewModel,configValueId,configId){
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

                //将分组后的数据遍历并动态拼接
                ViewFormElements(args,formName,viewModel);


            },

        });
    }
}

/**
 * 查看时的动态拼接  因为查看时所有字段都是不可编辑，所以不能用之前的js,只能自己写方法让字段不可编辑
 * @param args
 * @param formName
 * @param viewModel
 * @constructor
 */
function ViewFormElements(data,formName,viewModel){
    //alert(data.rows.length);
    for (var i = 0; i < data.rows.length; i++) {

        //文本框
        if (data.rows[i].columnStyle == "TEXT"){
            $("#" + formName).append(
                '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top:5px">' +
                '<div class="col-md-4 tdAlign">' +
                '<label >' + data.rows[i].columnNameAlias + '</label>' +
                '</div>' +
                '<div class="col-md-8">' +
               // '<input  disabled="disabled"  class="k-textbox"  id="' + data.rows[i].columnId + '"   style="width: 70%; background-color:#DDDDDD" value="' + viewModel.model.get(data.rows[i].columnId) + '" />' +
                '<input disabled="disabled" class="k-textbox" onblur="validateDecimal('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '"  style="width: 70%; background-color:#DDDDDD" value="' + viewModel.model.get(data.rows[i].columnId) + '"  />'+

                '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>' +
                '</div>' +
                '</div>'

            );
        }else if(data.rows[i].columnStyle == "DECIMAL")//只能输入小数
        {


                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input disabled="disabled" class="k-textbox" onblur="validateDecimal('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '"  style="width: 70%; background-color:#DDDDDD" value="' + viewModel.model.get(data.rows[i].columnId) + '"  />'+
                    '</div>'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>'
                );



        }else if(data.rows[i].columnStyle == "NUMBER") //只能输入整数
        {

                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input  disabled="disabled" class="k-textbox" onblur="validateNumber('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%; background-color:#DDDDDD" value="' + viewModel.model.get(data.rows[i].columnId) + '"" />'+
                    '</div>'+

                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                    '</div>'
                );



        }
        else if(data.rows[i].columnStyle == "DATE")  //日期格式
        {


                $("#" + formName).append(

                    '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                    '<div class="col-md-4 tdAlign">'+
                    '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input disabled="disabled"  id="'+ data.rows[i].columnId+'" name="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'"   style="width: 70%; background-color:#DDDDDD" value="' + viewModel.model.get(data.rows[i].columnId) + '""" />'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoDatePicker({ format : "yyyy-MM-dd"});'+
                    '</script>'+
                    '</div>'+
                    '<div>'+

                    '</div>'+

                    '</div>'
                );


        }else if(data.rows[i].columnStyle == "LIST")  //下拉框
        {
            //当sqlId不为空且没有级联时，只解析sqlId
            if(data.rows[i].sqlId!=null&&data.rows[i].cascadeFrom==null){

                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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




                        '</div>'

                    );
                }else{
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'"  value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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

                        '</div>'

                    );
                }
                //  alert(data.rows[i].columnId);

            }
            //拼接code
            if(data.rows[i].sysCode!=null){

                //当设为必输时
                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<script src="'+_basePath+'/common/code?codeData='+data.rows[i].sysCode+'" type="text/javascript"></script>'+
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                        '<script type="text/javascript">'+
                        '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                        'valuePrimitive: true,'+
                        'dataTextField: "meaning",'+
                        'dataValueField: "value",'+
                        'dataSource:codeData ,'+
                        ' });'+

                        '</script>'+
                        '</div>'+


                        '</div>'
                    );
                }else{
                    $("#" + formName).append(
                        '<script src="'+_basePath+'/common/code?codeData='+data.rows[i].sysCode+'" type="text/javascript"></script>'+
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'"  value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                        '<script type="text/javascript">'+
                        '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                        'valuePrimitive: true,'+
                        'dataTextField: "meaning",'+
                        'dataValueField: "value",'+
                        'dataSource:codeData ,'+
                        ' });'+

                        '</script>'+
                        '</div>'+


                        '</div>'
                    );
                }


            }

            //级联下拉框
            if(data.rows[i].cascadeFrom!=null&&data.rows[i].sqlId!=null){
                var cascadeFrom=data.rows[i].cascadeFrom;
                //alert(cascadeFrom);

                //当设为必输时
                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label >'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'" value="'+viewModel.model.get(data.rows[i].columnId)+'" id="'+ data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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




                        '</div>'

                    );
                }else{
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label >'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input disabled="disabled" background-color:#DDDDDD" name="'+data.rows[i].columnId+'" value="'+viewModel.model.get(data.rows[i].columnId)+'" id="'+ data.rows[i].columnId+'"  data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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



                        '</div>'

                    );
                }

            }
        }

    }
}

/*--------------------------------------我是分割线----------------【动态渲染】和在界面上点击【编辑】时的渲染-------------------------------------------*/
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

            if(args.success==true){
                //调用js 根据行号进行分组
                //showFormElements(args,formName,viewModel);
                findFormElementsBydisplayLineNo(args,formName,viewModel,configValueId,configId);
            }else{
                var node = document.getElementById('div1');
                if(node!=null){
                    //如果已存在渲染div,切换时将div清除
                    $("div#div1").remove();
                    //node.parentNode.removeChild(node);
                }
            }


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

                //将分组后的数据遍历并动态拼接
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
    /*$("#" + formName).append(
        '<div style="margin-left:50px;padding:0;  width:1000px;height:1px;background-color:	#A0A0A0;overflow:hidden;"> </div>'
)   ;*/
   // alert(12/datacount);
    //循环当前行div，加在当前行div中
    for (var i = 0; i < data.rows.length; i++) {
        //alert(data.rows[i].columnStyle);

        if (data.rows[i].columnStyle == "TEXT")//text
        {
            //当文本框为必输时
            if (data.rows[i].requiredFlag == "Y") {
                $("#" + formName).append(
                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-bottom: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input class="k-textbox" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />'+
                    '</div>'+
                    '<div style="width:65%;position: absolute;margin-left:75%; margin-top:1%;z-index:99">'+
                    '<span class="red">&nbsp;&nbsp;*</span>'+
                    '<span data-for="' + data.rows[i].columnId + '" class=".k-invalid-msg"></span>'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>'+
                    '</div>'





                         );
            } else {
                $("#" + formName).append(
                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top:5px">' +
                    '<div class="col-md-4 tdAlign">'+
                    '<label>' + data.rows[i].columnNameAlias + '</label>' +
                    '</div>'+
                    '<div class="col-md-8">' +
                    ' <input class="k-textbox" onblur="validateLength(' + data.rows[i].columnLength + ',this)" value="'+viewModel.model.get(data.rows[i].columnId)+'" id="' + data.rows[i].columnId + '"' +
                    'name="' + data.rows[i].columnId + '"  data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />' +
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>' +

                    '</div>'
                );
            }

        }else if(data.rows[i].columnStyle == "DECIMAL")//只能输入小数
        {

            //当为必输时
            if (data.rows[i].requiredFlag == "Y"){
                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input class="k-textbox" onblur="validateDecimal('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />'+
                    '</div>'+
                    '<div style="width:65%;position: absolute;margin-left:75%; margin-top:1%;z-index:99">'+
                    '<span class="red">&nbsp;&nbsp;*</span>'+
                    '<span data-for="' + data.rows[i].columnId + '" class=".k-invalid-msg"></span>'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>'+
                    '</div>'
                );
            }else{
                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input class="k-textbox" onblur="validateDecimal('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />'+
                    '</div>'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>'
                );
            }


        }else if(data.rows[i].columnStyle == "NUMBER") //只能输入整数
        {
            //当为必输时
            if(data.rows[i].requiredFlag == "Y"){
                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input class="k-textbox" onblur="validateNumber('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />'+
                    '</div>'+
                    '<div style="width:65%;position: absolute;margin-left:75%; margin-top:1%;z-index:99">'+
                    '<span class="red">&nbsp;&nbsp;*</span>'+
                    '<span data-for="' + data.rows[i].columnId + '" class=".k-invalid-msg"></span>'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '</div>'+
                    '</div>'
                );
            }else{
                $("#" + formName).append(


                    '<div id="div1" class="col-md-' + data.rows[i].dataLength + '" style="margin-top: 5px;">'+

                    '<div class="col-md-4 tdAlign">'+

                    '<label >' + data.rows[i].columnNameAlias + '</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input class="k-textbox" onblur="validateNumber('+data.rows[i].columnLength+',this)" id="' + data.rows[i].columnId + '"  name="' + data.rows[i].columnId + '" '+ data.rows[i].vaildateMessage+'  validationMessage="必输" data-bind="value:model.' + data.rows[i].columnId + '" style="width: 70%;" />'+
                    '</div>'+

                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                    '</div>'
                );
            }


        }
        else if(data.rows[i].columnStyle == "DATE")  //日期格式
        {

            if(data.rows[i].requiredFlag == "Y"){
                $("#" + formName).append(


                    '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                    '<div class="col-md-4 tdAlign">'+
                    '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input   id="'+ data.rows[i].columnId+'" name="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'"   style="width: 70%;" '+ data.rows[i].vaildateMessage+' validationMessage="必输" />'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoDatePicker({ format : "yyyy-MM-dd"});'+
                    '</script>'+
                    '</div>'+
                    '<div>'+
                    '<div style="width:65%;position: absolute;margin-left:75%; margin-top:2%;z-index:99">'+
                    '<span class="red">&nbsp;&nbsp;*</span>'+
                    '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                    '</div>'+
                    '</div>'+

                    '</div>'
                );
            }else{
                $("#" + formName).append(
                    /*'<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                    '<div class="form-group">' +
                    '<label class="col-md-4 control-label">'+ data.rows[i].columnNameAlias+'</label>'+
                    '<div class="col-md-8">'+
                    '<input   id="'+ data.rows[i].columnId+'"' +
                    'name="'+ data.rows[i].columnId+'" value="'+viewModel.model.get(data.rows[i].columnId)+'"   data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" />'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoDatePicker({ format : "yyyy-MM-dd"});'+
                    '</script>'+
                    '</div>'+
                    '</div>'+
                    '</div>'*/

                    '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                    '<div class="col-md-4 tdAlign">'+
                    '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                    '</div>'+
                    '<div class="col-md-8">'+
                    '<input   id="'+ data.rows[i].columnId+'" name="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'"   style="width: 70%;" />'+
                    '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+
                    '<script type="text/javascript">'+
                    '$("#"+"'+ data.rows[i].columnId+'").kendoDatePicker({ format : "yyyy-MM-dd"});'+
                    '</script>'+
                    '</div>'+
                    '<div>'+

                    '</div>'+

                    '</div>'
                );
            }

        }
        else if(data.rows[i].columnStyle == "LIST")  //下拉框
        {
            //当sqlId不为空且没有级联时，只解析sqlId
            if(data.rows[i].sqlId!=null&&data.rows[i].cascadeFrom==null){

                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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




                        '</div>'

                    );
                }else{
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'"  value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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

                        '</div>'

                    );
                }
              //  alert(data.rows[i].columnId);

            }
            //拼接code
            if(data.rows[i].sysCode!=null){

                //当设为必输时
                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<script src="'+_basePath+'/common/code?codeData='+data.rows[i].sysCode+'" type="text/javascript"></script>'+
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                        '<script type="text/javascript">'+
                        '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                        'valuePrimitive: true,'+
                        'dataTextField: "meaning",'+
                        'dataValueField: "value",'+
                        'dataSource:codeData ,'+
                        ' });'+

                        '</script>'+
                        '</div>'+


                        '</div>'

                    );
                }else{
                    $("#" + formName).append(
                        '<script src="'+_basePath+'/common/code?codeData='+data.rows[i].sysCode+'" type="text/javascript"></script>'+
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label>'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'"  value="'+viewModel.model.get(data.rows[i].columnId)+'"  id="'+ data.rows[i].columnId+'" data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

                        '<script type="text/javascript">'+
                        '$("#"+"'+ data.rows[i].columnId+'").kendoComboBox({'+
                        'valuePrimitive: true,'+
                        'dataTextField: "meaning",'+
                        'dataValueField: "value",'+
                        'dataSource:codeData ,'+
                        ' });'+

                        '</script>'+
                        '</div>'+


                        '</div>'
                    );
                }


            }

            //级联下拉框
            if(data.rows[i].cascadeFrom!=null&&data.rows[i].sqlId!=null){
                var cascadeFrom=data.rows[i].cascadeFrom;
                //alert(cascadeFrom);

                //当设为必输时
                if(data.rows[i].requiredFlag == "Y"){
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label >'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'" value="'+viewModel.model.get(data.rows[i].columnId)+'" id="'+ data.rows[i].columnId+'" '+ data.rows[i].vaildateMessage+' data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;" validationMessage="必输"/>'+
                        '<span class="red">&nbsp;&nbsp;*</span>'+
                        '<span data-for="'+ data.rows[i].columnId+'" class=".k-invalid-msg"></span>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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




                        '</div>'

                    );
                }else{
                    $("#" + formName).append(
                        '<div id="div1" class="col-md-'+data.rows[i].dataLength+'" style="margin-top:5px">'+
                        '<div class="col-md-4 tdAlign">'+
                        '<label >'+ data.rows[i].columnNameAlias+'</label>'+
                        '</div>'+
                        '<div class="col-md-8">'+
                        '<input name="'+data.rows[i].columnId+'" value="'+viewModel.model.get(data.rows[i].columnId)+'" id="'+ data.rows[i].columnId+'"  data-bind="value:model.'+ data.rows[i].columnId+'" style="width: 70%;"/>'+
                        '<script>kendo.bind($("#" + "' + data.rows[i].columnId + '"), viewModel);</script>'+

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



                        '</div>'

                    );
                }

            }
        }

    }
}

//校验输入框内只能输入小数
function validateDecimal(columnLength,self){
    var reg =/^\d+\.\d+$/;

    if (! reg.test(self.value)&&(self.value!="")) {
        kendo.ui.showErrorDialog({
            message: "只能输入小数"
        }).done(function (e) {
            self.value= "";
        })
    }

    //限制字段输入长度和是否必输
    validateLength(columnLength,self);


}

//校验输入框内只能输入整数
function validateNumber(columnLength,self){
    var reg =/^[0-9]*[1-9][0-9]*$/;

    if (! reg.test(self.value)&&(self.value!="")) {
        kendo.ui.showErrorDialog({
            message: "只能输入整数"
        }).done(function (e) {
            self.value= "";
        })
    }

    //限制字段输入长度和是否必输
    validateLength(columnLength,self);
}

//限制字段输入长度
function validateLength(columnLength,self){
    //当传入的参数为1时，表示必输
    /*if(validatemessage=="1"&&(self.value=="")){
        kendo.ui.showErrorDialog({
            message:"必输！"
        })
    }*/

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


/**
 * 查询缓存中的必输字段,并在前台保存时进行校验
 * @author fuchun.hu@hand-china.com 2017年3月24日 10:03:59
 * @param configValueId
 * @param configId
 * @param viewModel
 *
 */
function findAllRequiredData(configValueId,configId,viewModel){
    //alert(viewModel.model.get("groupId"));
    $.ajax({
        url: _basePath+"/bs/configcolumn/queryRequiredByCache?configValueId="+configValueId+"&configId="+configId,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        success: function (data) {

            if(data.success==true){
                for (var i = 0; i < data.rows.length; i++){
                    if(viewModel.model.get(data.rows[i].columnId)==''||viewModel.model.get(data.rows[i].columnId)==null){
                        kendo.ui.showInfoDialog({
                            message:data.rows[i].columnNameAlias+'不能为空'
                        })
                    }
                }

            }


        },

    });
}





