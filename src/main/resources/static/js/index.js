$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");
	//CSRF
	// var token = $("mete[name='_csrf']").attr("content");
	// var header = $("mete[name='_csrf_header']").attr("content");
	// $(document).ajaxSend(function (e,xhr,options){
	// 	xhr.setRequestHeader(header,token);
	// });

	// 获取标题和内容
	var title = $("#recipient-name").val();
	var content = $("#message-text").val();
	// 发送异步请求(POST)
	$.post(
	    CONTEXT_PATH + "/discuss/add",
	    {"title":title,"content":content},
	    function(data) {
	        data = $.parseJSON(data);
	        // 在提示框中显示返回消息
	        $("#hintBody").text(data.msg);
	        // 显示提示框
            $("#hintModal").modal("show");
            // 2秒后,自动隐藏提示框
            setTimeout(function(){
                $("#hintModal").modal("hide");
                // 刷新页面
                if(data.code == 0) {
                    window.location.reload();
                }
            }, 2000);
	    }
	);

}


/*-----------------删除景点时的提示信息------------------------*/
/*let btn=document.querySelectorAll(".debtn")
let deleteId
btn.forEach((a)=>{
	a.onclick=()=>{
		console.log(btn.values())
		if(confirm("确定要删除？")){
			// document.querySelector("#formxx").submit()
			deleteId = a.getAttribute('id')
			console.log(deleteId)
			$.ajax({
				type: "get",
				dataType: "json",
				url: "/itravel/delete",
				data: {'id':deleteId},
				success: function (result) {
					console.log(result);
				},
				error: function () {
					console.log("异常");
				}
			})
		}
	}
})*/

let btn=document.querySelectorAll(".debtn")
let abc=document.querySelectorAll(".fff")
let deleteId
btn.forEach((a)=>{
	a.onclick=()=>{
		console.log(btn.values())
		if(confirm("确定要删除？")){
			// document.querySelector("#formxx").submit()
			deleteId = a.getAttribute('id')
			console.log(deleteId)
			abc.forEach((item)=>{
				if(item.getAttribute('id')===deleteId){
					item.submit()
				}
			})
		}
	}
})

/*const btn111=document.querySelectorAll("#inp2")
btn111.forEach((a)=>{
	a.onclick=()=>{
	confirm("确定要删除？")
	}
})*/
/*---------------------增加经典时输入框提示------------------------------------------*/
const addName = document.querySelector("#addname")
const where = document.querySelector("#addwhere")
const addbu = document.querySelector("#addbutton")
const p1 = document.querySelector(".p1")
const p2 = document.querySelector(".p2")
let ali=1
let ali1=1

addbu.onclick=()=>{
	if(ali===0&&ali1===0){
		console.log(ali,ali1);
		addbu.setAttribute('type','submit')
	}
	if(addbu.getAttribute('type')==='button'){
		alert("请输入景点名称和地址")
	}
}

addName.addEventListener('blur',()=>{
	const val=addName.value
	if(val.length===0){
		addName.classList.add("tip")
		p1.style.display="block"
		ali=1
	}else{
		ali=0
	}
	console.log("ali     "+ali);
})
addName.addEventListener('focus',()=>{
	addName.classList.remove("tip")
	p1.style.display="none"
})

where.addEventListener('blur',()=>{
	const val=where.value
	if(val.length===0){
		where.classList.add("tip")
		p2.style.display="block"
		ali1=1
	}else{
		ali1=0
	}
	console.log("ali1     "+ali1);
})
where.addEventListener('focus',()=>{
	where.classList.remove("tip")
	p2.style.display="none"
})

/*-----------------------修改提示----------------------------*/
const modName = document.querySelector("#modname")
const modaddr = document.querySelector("#modaddr")
const p3 = document.querySelector(".p3")
const p4 = document.querySelector(".p4")

modName.addEventListener('change',()=>{
	console.log("change出发")
	const val=modName.value
	console.log(val);
	if(val.length===0){
		modName.classList.add("tip")
		p3.style.display="block"
	}else{
		modName.classList.remove("tip")
		p3.style.display="none"
	}
})
modName.addEventListener('focus',()=>{
	modName.classList.remove("tip")
	p3.style.display="none"
})

modaddr.addEventListener('change',()=>{
	const val=modaddr.value
	if(val.length===0){
		modaddr.classList.add("tip")
		p4.style.display="block"
	}else{
		modaddr.classList.remove("tip")
		p4.style.display="none"
	}
})
modaddr.addEventListener('focus',()=>{
	modaddr.classList.remove("tip")
	p4.style.display="none"
})
