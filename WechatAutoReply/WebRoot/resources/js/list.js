function deleteOne(basePath, id) {
	if (confirm('你确定删除吗？')) {
		document.getElementById("id").value = id
		document.getElementById("mainForm").action = basePath+"DeleteOneServlet"
		document.getElementById("mainForm").submit()
	}
}
function deleteBatch(basePath){
	if(confirm('你确定删除选择数据吗？')){
		document.getElementById("mainForm").action=basePath+"DeleteBatchServlet"
		document.getElementById("mainForm").submit();
	}
}