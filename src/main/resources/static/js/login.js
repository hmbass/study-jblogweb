// login Object 객체 선언
let loginObject = {
    //init 함수 선언
    init: function () {
        $("#btn-login").on("click", () => {
            _this.login();
        });
    },

    login: function () {
        alert("로그인 요청됨");
        //사용자가 입력한 값 username, password, email 추출
        let data = {
            username: $("#username").val(),
            password: $("#password").val()
        }

        $.ajax({
            type: "POST",
            url: "/auth/login",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8"
            // 응답으로 들어온 JSON 데이터를 response로 받음
        }).done(function (response) {
            let message = response["data"];
            // 응답 메시지를 콘솔에 출력하고 메인 페이지로 이동
            alert(message);
            location = "/";
            // 에러 발생 시 Error로 에러 정보를 받음
        }).fail(function (error) {
            let message = error["data"];
            alert("에러 발생: " + message);
        });
    }
}

loginObject.init();