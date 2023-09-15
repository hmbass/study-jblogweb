// Post Object 객체 선언
let postObject = {
    //init 함수 선언
    init: function () {
        let _this = this;

        $("#btn-insert").on("click", () => {
            _this.insertPost();
        })
    },

    insertPost: function () {
        alert("포스트 등록 요청됨");
        let post = {
            title : $("#title").val(),
            content : $("#content").val()
        }

        $.ajax({
            type: "POST",
            url: "/post",
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            let message = response["data"];
            alert(message);
            location = "/";
        // 에러 발생 시 Error로 에러 정보를 받음
        }).fail(function (error) {
            let message = error["data"];
            alert("에러 발생: " + message);
        });
    }
}

postObject.init();