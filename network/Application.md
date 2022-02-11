# Application layer
- 네트워크 기능이 있는 프로세스
- 브라우저
- 네트워크 엣지에 있는 서버와 클라이언트에서 동작
## 클라이언트, 서버
- 서버
    - always on host
    - permanent ip address(고정된 아이피)
- 클라이언트
    - 고정되지 않아도됨
    - 서버와 소통
## Processes communicating
- 프로세스간의 통신과 비슷하다
- 시스템콜과 비슷한 소켓을 이용
## Sochet
- 주소를 알아야 연결가능
    - ip: 컴퓨터의 주소
    - port: 컴퓨터 안에 소켓의 주소(서버에 요청을 보낸 프로세스)
- 사이트 주소를 입력하면 DNS가 ip주소를 찾아준다
- 서버가 보통 80번 포트를 사용
    - DNS에서 포트까지 만들 수 없어서 통일
## 계층의 개념
- 상위 계층이 하위 계층의 기능을 사용가능
## transport layer의 서비스
- 데이터 유실 방지만 제공
- UDP는 그마저도 제공불가
- 보안, 타이밍등은 application layer에서 해줘야함
### 타이밍과 스루풋
- 스루풋은 각 패킷이 동시에 가야함(양)
- 타이밍은 패킷들이 일정 시간안에 도착해야함
## HTTP(Hypertext transfer protocol)
- hyper text를 transfer 해주는 protocol
- request
- response
- TCP를 사용
    - TCP Connection을 해야함
- 상대방의 상태를 기억하지 않음
    - 요청에 응답만하기 때문에 상태를 저장하지 않는다
## HTTP Connections
- non-persistent HTTP
    - 응답하고 연결을 끊음
- persistent HTTP
    - 응답하고도 연결을 끊지 않음