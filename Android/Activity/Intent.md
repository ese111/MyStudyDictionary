# Intent
- 컴포넌트간 메시지를 주고 받는 전달자
- 각 컴포넌트를 호출, 실행
- 예 : 액티비티간의 화면 전환
    - startActivity(): 새로운 액티비티 시작
    - startService(), bindService(): 서비스 관련
    - sendBroadcast(), sendOrderBroadcast(): 브로드캐스팅 수행
- 명시적 인텐트와 암시적 인텐트가 있음

## 명시적 인텐트
- 대상 컴포넌트가 패키지명을 포함해서 확실한 경우
- 인텐트를 충족하는 앱 지정
- 시스템이 해당 구성 ㅛ소를 즉시 실행
## 암시적 인텐트
- 특정 구성 요소의 이름은 대지 않지만, 대신 수행할 일반적인 작업을 선언하여 다른 앱의 구성 요소가 이를 처리할 수 있도록 함
- 예 : 지도에 위치 표시 -> 암시적 인테트로 해당 기능이 있는 다른앱이 위치를 표시하게 함
- 시스템에서 적절한 구성 요소를 탐색 (매니페스트 파일의 인텐트 필터와 비교) -> 해당 구성 요소 시작, 인텐트 객체에 전달
- 여러개면 사용자에게 지정하게 함
- 인태트 필터가 없으면 명시적인 인텐트만 사용 가능
- 서비스를 사용할때는 명시적인 텐트를 사용하는 것이 보안에 좋음
## Intent Build
- component name
    - 

