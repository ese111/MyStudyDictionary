# Context
## Context?

Interface to global information about an application environment. This is an abstract class whose implementation is provided by the Android system. It allows access to application-specific resources and classes, as well as up-calls for application-level operations such as launching activities, broadcasting and receiving intents, etc.

응용 프로그램 환경에 대한 전역 정보를 갖는 인터페이스입니다. 이것은 안드로이드 시스템에 의해 구현되는 추상 클래스입니다. 애플리케이션별 리소스 및 클래스뿐만 아니라 시작 활동, 브로드캐스팅 및 수신 등과 같은 애플리케이션 수준 운영을 위한 업콜에 액세스할 수 있습니다.

- 애플리케이션의 현재 상태
- 액티비티와 어플리케이션의 정보를 얻기 위해 사용
- 리소스, 데이터 베이스, shared preference 등에 접근할때 사용
- 액티비티와 애플리케이션 클래스는 Context를 확장한것

## 종류
- Application Context
    - 싱글턴 인스턴스
    - getApplicationContext()를 통해 접근
    - 애플리케이션 라이프 사이클에 연관
    - 현재 컨택스트가 종료된 이후 컨택스트가 필요할때 액티비티 스코프를 벗어난 컨택스트가 필요할떄
- Activity Context
    - 액티비티내에서 유효한 컨택스트
    - 액티비티 라이프사이클과 연결
    - 액티비티와 함께 소멸해야할때
    