$.ajax({
    url:'/template/testError',
    type:'post',
    data:{},
    success:function () {
        alert("ok");
    },
    error:function () {
        alert("error");
    }
});