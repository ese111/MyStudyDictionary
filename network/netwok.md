# 네트워크
## 인터넷의 역사
- 알파넷이 군사 목적으로 4대로 시작해서 셀 수도 없는 많은 노드가 연결된 인터넷으로 발전
## 네트워크의 구조
- nerwork edge
    - 사용자들
    - applications and hosts
- network core
    - 라우터
    - network of networks
- access networks, physical media
    - communication links
    - 하우터 사이(케이블), 와이파이 등
## nerwork edge
- end systems(hosts)
- client/server model
    - client: 필요할때 요청으로 응답을 받아옴
    - server: client가 요청을 보내기를 기다리고 응답을 줌
- perr-peer model
## nerwork edge: connection-oriented service
- [TCP](tele.md)
    - 신뢰성
    - 비용이 큼
- [UDP](tele.md)
    - 패킷이 조금 유실될 수도 있음
## 프로토콜이란
- 중요한 메세지를 주고 받기위한 준비 동작
## 패킷
- 비트들의 집합으로 출발지에서 목적지까지 목적지를 거처가는 묶음 단위
## network core
- 네트워크의 중심
- 라우터들의 집합
    - circuit switching
        - 우저를 위해 출발지에서 목적지까지 정해놓고 이용
        - 유선 전화망
    - packet Switching
        - 인터넷에서 사용
        - 패킷을 받아서 들어오는대로 보내줌
## 패킷 스위칭 사용이유
- 인터넷을 이용할때 데이터를 이용하는 시간보다 쉬는 시간이 많기 때문에 유저가 보통 분산되기 때문에 서킷 스위칭보다 패킷스위칭을 사용한다
## 패킷 스위칭 단점
- 패킷을 받아서 위치로 보내야하는데 유저가 많아질 경우 임시 버퍼/큐에 저장공간 필요
- processing delay: 페킷 검사 시간 
- Queueing delay: 큐에 있을때 딜레이 
- transmission deldey: 프로마지막 비트까지 큐에서 나갈때 딜레이
- propagation delay: 마지막 비트가 다음 라우터까지 도달하는 시간(빛의 속도)
## 딜레이 개선
- processing delay
    - 라우터 업그레이드
- transmission delay
    - 케이블 공사를 해서 bandwidth를 늘린다
- Queueing delay
    - 사용자 수로 정해져서 개선 불가
    - 큐가 넘치면 패킷 로스 발생
- propagation delay
    - 빛의 속도라서 개선 불가
## 패킷 유실
TCP는 신뢰성이 있다 하지만 라우터의 큐가 차서 패킷 유실이 일어나면 어떻게 될까?
- 네트워크 엣지에서 재전송해준다
- 네트워크 코어는 단순히 전송만해줌
## layer
- application
    - HTTP
- transport
    - TCP/UDP
- network
    - IP
- datalink
    - wifi, LTE, 이더넷
- physical