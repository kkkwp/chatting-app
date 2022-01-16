# chatting-app
2020학년도 2학기 네트워크 과제
- 웹 상에서 여러 명의 사용자가 이용할 수 있는 채팅 앱 만들기

### Functions
User
- 접속 시 채팅에 사용할 닉네임 입력
- 스레드를 이용하여 여러 명의 User와 채팅 가능
- 자신이 입력한 내용은 오른쪽에, 상대방이 입력한 내용은 왼쪽에 닉네임과 함께 표시됨

Server

- User 접속 시 접속한 IP, 입력한 닉네임이 전송됨
- User의 I/O stream, socket 관리
- Server의 내용들은 Console에 표시됨
- 스레드를 이용하여 User의 채팅과 별개로 운영

---

### Files
- Client : User가 사용할 채팅 앱. User에게 닉네임을 입력 받고 Window를 실행시키며, IP 주소를 Server로 전송
- Console : Server의 내용이 표시되는 창. User 화면과 독립적으로 운영됨.
- Server : 채팅 앱의 서버. 채팅에 접속한 User들의 I/O stream, socket 관리
- User : 채팅의 참여자. 채팅 앱 접속 시 IP 주소가 Server로 넘어감.
- Window : User가 보게 되는 화면. User들의 닉네임과 채팅 내용이 표시됨.

---

### Library
- java.net
- java.io
- java.awt
- javax.swing
