// User Object 객체 선언
let userObject = {
    //init 함수 선언
    init: function () {
        let _this = this;

        // #btn-save 버튼에 click 이벤트가 발생하면 insertUser() 함수 호출
        $("#btn-save").on("click", () => {
            _this.insertUser();
        })
/*
        // #btn-save 버튼에 click 이벤트가 발생하면 insertUser() 함수 호출
        $("#btn-save2").on("click", () => {
            _this.insertUser2();
        });
 */
    },

    insertUser: function () {
        alert("회원가입 요청됨");
        //사용자가 입력한 값 username, password, email 추출
        let user = {
            username : $("#username").val(),
            password : $("#password").val(),
            email : $("#email").val()
        }

        // Ajax를 이용한 비동기 호출
        // done() 함수: 요청 처리에 성공했을 때 실행될 코드
        // Fail() 함수: 요청 처리에 실패했을 때 실행될 코드
        $.ajax({
            type: "POST",
            url: "/auth/insertUser",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        // 응답으로 들어온 JSON 데이터를 response로 받음
        }).done(function (response) {
            // 응답 메시지를 콘솔에 출력하고 메인 페이지로 이동
            console.log(response);
            location = "/";
        // 에러 발생 시 Error로 에러 정보를 받음
        }).fail(function (error) {
            alert("에러 발생: " + error);
        });

        // user 객체의 값을 콘솔에 출력
        console.log(user);
    }
/*
    insertUser2: function () {
        alert("회원dsfdsfadsfasfasdf가입 요청됨");
    }
*/
}

// userObject 객체의 init() 함수 호출.
userObject.init();