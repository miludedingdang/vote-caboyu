/*
<select name="" >
	<option>--请选择--</option>
	<option>*****</option>
	<option>*****</option>
</select>
*/
//访问后台Action加载枚举json数据. 将数据封装成select下拉选. 
//参数1: 数据字典类型code
//参数2: 放置的页面元素所在位置id
//参数3: 生成的下拉选的name属性
//参数4: 需要默认被选中的option的id值
function prepareEnumSelect(typeCode,position,key,selected){
		//1 创建select对象,并添加name属性
		var $select = $("<select name='"+key+"' ></select>");
		//2 创建提示option,并添加到select对象中
		var $option = $("<option>--请选择--</option>")
		
		$select.append($option);
		//3 发送ajax请求,加载后台字典数据(json)
		$.getJSON("${pageContext.request.contextPath }/BaseDictAction", { dict_type_code: typeCode}, function(json){
			for(var i=0;i<json.length;i++){
		//4 遍历json对象,创建一个option,并放入select对象中
				var $opt = $("<option value='"+json[i]['dict_id']+"' >"+json[i]['dict_item_name']+"</option>")
				
					//判断当前option是否需要被选中=> 选中(添加selected属性)
				if(json[i]['dict_id']==selected){
					$opt.attr("selected","selected");
				}				
				
				$select.append($opt);
			}
		});
		//5 将select对象放入页面指定位置
		$("#"+position).append($select);
};

function confirmDel(cname,url){
	//1 向用户确认是否要删除
	var result = 	confirm("您确定要删除"+cname+"吗?");
	if(result){
	//2 确定要删除=>将页面跳转到url路径
		window.location.href=url;
	}
	
}