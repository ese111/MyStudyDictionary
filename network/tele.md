# 통신
## 패킷
- 내용이 길때 통신라인을 점유해서 효율적이지 못해지니 패킷으로 나눠서 보냄
## 알파넷
- 군용으로 만들어진 망
- 인터넷의 시초
## Network topology
- ring
- mesh
- star
- fully connected
    - 좋은데 비용이 큼
- line
- tree
- bus
## 주소
큰주소 -> 작은주소로
10.0.1.120
사이트는 미국식
작은거 -> 큰거
ex) lucas.codesquad.co.kr
## packet switching(routing)
- 경로를 찾아가는 방식
- 라우터가 옆으로 전달하는 방식
## lan, wan
- lan
    - 내부에 연결하는 네트워크
- wan
    - 외부에 연결하는 네트워크
## OSI 7 layer
- 표준은 아님
- application
- presentation
- session
- transport
- network
- datalink
- physical
## tcp
- 연결 지향
- 전송에 대한 신뢰성
- 상대적으로 느림
- http, ftp, telnet, ssh
- 헤더 크기 20바이트
- 흐름제어 + 혼잡제어
- ack 확인
- handshake 사용
- 1 대 1
## udp
- 비연결형
- 전송에 대한 보장 없음
- 효율적인 전송 속도
- dns, dhcp, tftp, snmp, sip
- 헤더 8바이트
- 흐름제어 없음
- ack
- no handshacke
## 헤더
- tcp header
## 3 way handshack
## 4 way handshack
## i/o stream
- content length만큼만 읽고 뒤에는 다른 데이터 취급

